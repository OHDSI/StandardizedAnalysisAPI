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

    public static String serialize(Object object) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(
                MapperFeature.AUTO_DETECT_CREATORS,
                MapperFeature.AUTO_DETECT_GETTERS, 
                MapperFeature.AUTO_DETECT_IS_GETTERS
        );
        
        objectMapper.disable(
                SerializationFeature.FAIL_ON_EMPTY_BEANS
        );
        
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

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
}
