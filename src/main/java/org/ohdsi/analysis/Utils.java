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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;

public class Utils {

    private static ObjectMapper getObjectMapper() {

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

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }

    public static String serializePretty(Object object) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();
        
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

        try {
            ObjectMapper objectMapper = getObjectMapper();
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
        try{
            return objectMapper.readValue(data, type);
        }catch(Exception ex) {
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
}
