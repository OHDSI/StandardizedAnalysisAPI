package org.ohdsi.analysis.pathway;

import java.io.IOException;
import org.json.JSONException;
import org.junit.Test;
import org.ohdsi.analysis.BaseTest;
import org.ohdsi.analysis.Utils;
import org.skyscreamer.jsonassert.JSONAssert;

public class PathwaysTest extends BaseTest {
	
    @Test
    public void testDefaultPathwaySerialization() throws IOException, JSONException {
			DefaultMockPathwayAnalysis mock = new DefaultMockPathwayAnalysis();
			JSONAssert.assertEquals(readResource("/pathways/DefaultMockPathwayAnalysis.json"), Utils.serializePretty(mock), false);
		}	
}
