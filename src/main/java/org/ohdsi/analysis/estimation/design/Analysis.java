/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author asena5
 */
public interface Analysis extends RLangClass {
    @JsonGetter("analysisId")
    Integer getAnalysisId();
    
    @JsonGetter("description")
    String getDescription();
}
