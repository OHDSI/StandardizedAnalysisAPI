package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

public interface Prior extends RLangClass {
    /**
     * A vector of numbers or covariateId names to exclude from prior
     * @return exclude
     **/
    @JsonGetter(value = "exclude")
    Integer getExclude();

    /**
     * Child-to-parent mapping for a hierarchical prior
     * @return graph
     **/
    @JsonGetter(value = "graph")
    String getGraph();

    /**
     * A list of first-order neighborhoods for a partially fused prior
     * @return neighborhood
     **/
    @JsonGetter(value = "neighborhood")
    String getNeighborhood();

    /**
     * Perform cross-validation to determine prior variance. 
     * @return useCrossValidation
     **/
    @JsonGetter(value = "useCrossValidation")
    Boolean getUseCrossValidation();
    
    /**
     * Force intercept coefficient into prior 
     * @return forceIntercept
     **/
    @JsonGetter(value = "forceIntercept")
    Boolean getForceIntercept();
    
    /**
     * Specifies prior distribution. We specify all priors in terms of their variance parameters. Similar fitting tools for regularized regression often parameterize the Laplace distribution in terms of a rate \&quot;lambda\&quot; per observation. See \&quot;glmnet\&quot;, for example.    variance &#x3D; 2 * / (nobs * lambda)^2 or lambda &#x3D; sqrt(2 / variance) / nobs
     * @return priorType
     **/
    @JsonGetter(value = "priorType")
    PriorTypeEnum getPriorType();

    /**
     * prior distribution variance
     * @return variance
     **/
    @JsonGetter(value = "variance")
    Integer getVariance();   
}
