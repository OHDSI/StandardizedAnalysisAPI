package org.ohdsi.analysis;

import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;
import org.ohdsi.analysis.pojos.BaseJson;
import org.ohdsi.analysis.pojos.SampleJson;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UtilsTest extends BaseTest {

    @Test
    public void serializeDefaultWithoutNulls() throws IOException {

        String serialized = Utils.serialize(SampleJson.newInstance().withName("SampleJson").withCount(123));
        assertEquals(readResource("/sample.json"), serialized);
    }

    @Test
    public void serializeDefaultWithNulls() throws IOException {

        String serialized = Utils.serialize(SampleJson.newInstance().withName("SampleJson").withCount(123), true);
        assertEquals(readResource("/sampleWithNulls.json"), serialized);
    }

    @Test
    public void deserializePolymorphic() throws IOException {

        String json = readResource("/polymorphic.json");
        BaseJson result = Utils.deserialize(json, BaseJson.class);
        assertEquals(result.getClass(), SampleJson.class);
    }

    @Test
    public void deserializePolymorphicWithCustomInjection() throws IOException {

        Utils.registerObjectMapperModule(
                new SimpleModule().registerSubtypes(new NamedType(org.ohdsi.analysis.pojos.custom.SampleJson.class, "SampleJson"))
        );
        String json = readResource("/polymorphic.json");
        BaseJson result = Utils.deserialize(json, BaseJson.class);
        assertEquals(result.getClass(), org.ohdsi.analysis.pojos.custom.SampleJson.class);
        assertEquals(((org.ohdsi.analysis.pojos.custom.SampleJson) result).getCustomField(), Long.valueOf(777));
    }
}
