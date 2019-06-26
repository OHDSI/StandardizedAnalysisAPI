package org.ohdsi.analysis.versioning;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

import java.util.Arrays;

public class VersionedDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {

        if (Arrays.asList(beanDesc.getBeanClass().getInterfaces()).contains(CdmCompatibilitySpec.class)) {
            return new VersionedDeserializer(beanDesc.getBeanClass(), deserializer);
        }
        return deserializer;
    }
}
