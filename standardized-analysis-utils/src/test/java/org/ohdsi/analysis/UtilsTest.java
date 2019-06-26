package org.ohdsi.analysis;

import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;
import org.ohdsi.analysis.pojos.BaseJson;
import org.ohdsi.analysis.pojos.SampleJson;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UtilsTest extends BaseTest {

    private static final SimpleModule CUSTOM_TYPE_MODULE = new SimpleModule().registerSubtypes(
            new NamedType(org.ohdsi.analysis.pojos.custom.SampleJson.class, "SampleJson")
    );

    @Test
    public void serializeDefaultWithoutNulls() throws IOException {

        String serialized = Utils.serialize(SampleJson.newInstance().withName("Sample").withCount(123));
        assertEquals(readResource("/sample.json"), serialized);
    }

    @Test
    public void serializeDefaultWithNulls() throws IOException {

        String serialized = Utils.serialize(SampleJson.newInstance().withName("Sample").withCount(123), true);
        assertEquals(readResource("/sampleWithNulls.json"), serialized);
    }

    @Test
    public void deserializePolymorphic() throws IOException {

        Utils.unregisterObjectMapperModule(CUSTOM_TYPE_MODULE);
        String json = readResource("/polymorphic.json");
        BaseJson result = Utils.deserialize(json, BaseJson.class);
        assertEquals(result.getClass(), SampleJson.class);
    }

    @Test
    public void deserializePolymorphicWithCustomInjection() throws IOException {

        Utils.registerObjectMapperModule(CUSTOM_TYPE_MODULE);
        String json = readResource("/polymorphic.json");
        BaseJson result = Utils.deserialize(json, BaseJson.class);
        assertEquals(result.getClass(), org.ohdsi.analysis.pojos.custom.SampleJson.class);
        assertEquals(((org.ohdsi.analysis.pojos.custom.SampleJson) result).getCustomField(), Integer.valueOf(777));
    }
}
