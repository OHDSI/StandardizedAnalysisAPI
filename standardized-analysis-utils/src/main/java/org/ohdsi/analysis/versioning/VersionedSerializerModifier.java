package org.ohdsi.analysis.versioning;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.Arrays;

public class VersionedSerializerModifier extends BeanSerializerModifier {

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {

        if (Arrays.asList(beanDesc.getBeanClass().getInterfaces()).contains(CdmCompatibilitySpec.class)) {
            return new VersionedSerializer((JsonSerializer<Object>) serializer);
        }
        return serializer;
    }
}
