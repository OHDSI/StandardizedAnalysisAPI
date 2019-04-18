package org.ohdsi.analysis.versioning;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class VersionedSerializer extends JsonSerializer<CdmCompatibilitySpec> {

    private final JsonSerializer<Object> defaultSerializer;

    public VersionedSerializer(JsonSerializer<Object> defaultSerializer) {

        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(CdmCompatibilitySpec cdmCompatibilitySpec, JsonGenerator gen, SerializerProvider provider) throws IOException {

        CdmVersionUtils.determineCdmCompatibility(cdmCompatibilitySpec);
        defaultSerializer.serialize(cdmCompatibilitySpec, gen, provider);
    }
}
