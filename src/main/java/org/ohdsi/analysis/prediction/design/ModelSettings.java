package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.WRAPPER_OBJECT)
public interface ModelSettings {

}
