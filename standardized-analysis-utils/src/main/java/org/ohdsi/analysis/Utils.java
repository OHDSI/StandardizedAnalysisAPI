package org.ohdsi.analysis;

import static com.fasterxml.jackson.core.util.DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.io.IOUtils;
import org.ohdsi.analysis.versioning.VersionedDeserializerModifier;
import org.ohdsi.analysis.versioning.VersionedSerializerModifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final Set<Module> OBJECT_MAPPER_MODULES = ConcurrentHashMap.newKeySet();
    private static HandlerInstantiator OBJECT_MAPPER_HANDLER_INSTANTIATOR = null;
    private static final Map<ObjectMapperConfig, ObjectMapper> OBJECT_MAPPER = new ConcurrentHashMap<>();

    protected static class ObjectMapperConfig {

        private boolean includeNulls;

        public static ObjectMapperConfig newInstance() {

            return new ObjectMapperConfig();
        }

        public ObjectMapperConfig withIncludeNulls(boolean includeNulls) {

            this.includeNulls = includeNulls;
            return this;
        }

        public boolean isIncludeNulls() {

            return includeNulls;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ObjectMapperConfig that = (ObjectMapperConfig) o;
            return includeNulls == that.includeNulls;
        }

        @Override
        public int hashCode() {

            return Objects.hash(includeNulls);
        }
    }

    public static void registerObjectMapperModule(Module module) {

        OBJECT_MAPPER_MODULES.add(module);
        OBJECT_MAPPER.clear();
    }

    public static void unregisterObjectMapperModule(Module module) {

        OBJECT_MAPPER_MODULES.remove(module);
        OBJECT_MAPPER.clear();
    }

    public static void setObjectMapperHandlerInstantiator(HandlerInstantiator instantiator) {

        OBJECT_MAPPER_HANDLER_INSTANTIATOR = instantiator;
        OBJECT_MAPPER.clear();
    }

    private static ObjectMapper getObjectMapper() {

        return getObjectMapper(ObjectMapperConfig.newInstance().withIncludeNulls(false));
    }

    private static ObjectMapper getObjectMapper(ObjectMapperConfig objectMapperConfig) {

        return OBJECT_MAPPER.computeIfAbsent(objectMapperConfig, config -> buildObjectMapper(objectMapperConfig));
    }

    private static ObjectMapper buildObjectMapper(ObjectMapperConfig config) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(
                MapperFeature.AUTO_DETECT_CREATORS,
                MapperFeature.AUTO_DETECT_GETTERS,
                MapperFeature.AUTO_DETECT_IS_GETTERS
        );

        objectMapper.disable(
                SerializationFeature.FAIL_ON_EMPTY_BEANS
        );

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if (!config.isIncludeNulls()) {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }

        objectMapper.registerModule(
                new SimpleModule()
                        .setSerializerModifier(new VersionedSerializerModifier())
                        .setDeserializerModifier(new VersionedDeserializerModifier())
        );

        OBJECT_MAPPER_MODULES.forEach(objectMapper::registerModule);

        if (OBJECT_MAPPER_HANDLER_INSTANTIATOR != null) {
            objectMapper.setHandlerInstantiator(OBJECT_MAPPER_HANDLER_INSTANTIATOR);
        }

        return objectMapper;
    }

    public static String serializePretty(Object object) throws JsonProcessingException {

        return serializePretty(object, false);
    }

    public static String serializePretty(Object object, Boolean includeNulls) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper(ObjectMapperConfig.newInstance().withIncludeNulls(includeNulls));

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter() {

            public DefaultPrettyPrinter withSeparators(Separators separators) {

                _separators = separators;
                _objectFieldValueSeparatorWithSpaces = separators.getObjectFieldValueSeparator() + " ";
                return this;
            }
        };

        prettyPrinter.indentArraysWith(SYSTEM_LINEFEED_INSTANCE);

        return objectMapper.writer(prettyPrinter).writeValueAsString(object);
    }

    public static String serialize(Object object) {

        return serialize(object, false);
    }

    public static String serialize(Object object, Boolean includeNulls) {

        try {
            ObjectMapper objectMapper = getObjectMapper(ObjectMapperConfig.newInstance().withIncludeNulls(includeNulls));
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T deserialize(String data, TypeReference<T> typeRef) {

        ObjectMapper objectMapper = getObjectMapper();
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, typeRef);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T deserialize(String data, JavaType typeRef) {

        ObjectMapper objectMapper = getObjectMapper();
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, typeRef);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T deserialize(String data, Function<TypeFactory, JavaType> typeFunction) {

        Objects.requireNonNull(typeFunction);
        ObjectMapper objectMapper = getObjectMapper();
        JavaType type = typeFunction.apply(objectMapper.getTypeFactory());
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, type);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T deserialize(String data, Class<T> objectClass) {

        Objects.requireNonNull(objectClass);
        ObjectMapper objectMapper = getObjectMapper();
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, objectClass);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean isAlphaNumeric(String str) {

        Pattern p = Pattern.compile("^[a-zA-Z0-9.]+$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static String GetResourceAsString(String resource) {

        try (InputStream inputStream = Utils.class.getResourceAsStream(resource)) {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("Resource not found: " + resource);
        }
    }
}
