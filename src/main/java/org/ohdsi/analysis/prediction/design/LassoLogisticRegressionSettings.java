package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.LASSO_LOGISTIC_REGRESSION)
public interface LassoLogisticRegressionSettings extends ModelSettings, SeedSettings {

    @JsonGetter("variance")
    BigDecimal getVariance();
}
