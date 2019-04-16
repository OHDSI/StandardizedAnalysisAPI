package org.ohdsi.analysis.versioning;

import org.apache.commons.lang3.StringUtils;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;

import java.util.List;

import static org.ohdsi.analysis.Utils.GetResourceAsString;

public class SemverUtils {

    private static final String JS_LANG = "js";
    private static final String SEMVER_JS = GetResourceAsString("/semver/semver.js");
    private static final String SEMVER_INTERSECT_JS = GetResourceAsString("/semver/semver-intersect.js");

    // Due to absence of Java libraries which implement required functionality
    // existing Javascript modules are used
    public static String getRangesIntersection(List<String> ranges) {

        Context jsContext = Context.create(JS_LANG);
        jsContext.eval(JS_LANG, "var exports = module = {}; " + SEMVER_JS + " ; var semver = exports;");
        jsContext.eval(JS_LANG, SEMVER_INTERSECT_JS);
        String rangesLine = "'" + StringUtils.join(ranges, "', '") + "'";
        try {
            jsContext.eval(JS_LANG, "var intersection = intersect(" + rangesLine + ").toString()");
        } catch (PolyglotException ex) {
            if (ex.getMessage().matches("Error: Range .+ is not compatible with .+")) {
                return null;
            } else {
                throw ex;
            }
        }
        return jsContext.getBindings(JS_LANG).getMember("intersection").asString();
    }
}
