package org.ohdsi.analysis.versioning;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class VersionedDeserializer extends StdDeserializer<CdmCompatibilitySpec> implements ResolvableDeserializer {

    private final JsonDeserializer<?> defaultDeserializer;

    public VersionedDeserializer(Class<?> clazz, JsonDeserializer<?> defaultDeserializer) {

        super(clazz);
        this.defaultDeserializer = defaultDeserializer;
    }

    @Override
    public CdmCompatibilitySpec deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        CdmCompatibilitySpec obj = (CdmCompatibilitySpec) defaultDeserializer.deserialize(p, ctxt);
        CdmVersionUtils.determineCdmCompatibility(obj);
        return obj;
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {

        ((ResolvableDeserializer) defaultDeserializer).resolve(ctxt);
    }

}
