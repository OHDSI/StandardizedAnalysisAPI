/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author asena5
 */
public interface EstimationAnalysisSettings {
    
    @JsonGetter("estimationType")
    EstimationTypeEnum getEstimationType();
    
    @JsonGetter("analysisSpecification")
    Object getAnalysisSpecification();
}
