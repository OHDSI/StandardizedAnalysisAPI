package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import static com.fasterxml.jackson.core.util.DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;

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

    public static String serialize(Object object) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
