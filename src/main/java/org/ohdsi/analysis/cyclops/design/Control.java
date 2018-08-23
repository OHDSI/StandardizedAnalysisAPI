package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;
import org.ohdsi.analysis.RLangClass;

public interface Control extends RLangClass {
    /**
     * The algorithm setting
     * @return algorithm
     **/
    @JsonGetter(value = "algorithm")
    String getAlgorithm();

    /**
     * name of convergence criterion to employ
     * @return convergenceType
     **/
    @JsonGetter(value = "convergenceType")
    ConvergenceTypeEnum getConvergenceType();

    /**
     * Number of repetitions of X-fold cross validation
     * @return cvRepetitions
     **/
    @JsonGetter(value = "cvRepetitions")
    BigDecimal getCvRepetitions();

    /**
     * name of cross validation search. Option \&quot;auto\&quot; selects an auto-search following BBR. Option \&quot;grid\&quot; selects a grid-search cross validation
     * @return cvType
     **/
    @JsonGetter(value = "cvType")
    CvTypeEnum getCvType();

    /**
     * Number of random folds to employ in cross validation
     * @return fold
     **/
    @JsonGetter(value = "fold")
    BigDecimal getFold();

    /**
     * Number of steps in grid-search
     * @return gridSteps
     **/
    @JsonGetter(value = "gridSteps")
    BigDecimal getGridSteps();

    /**
     * Starting trust-region size
     * @return initialBound
     **/
    @JsonGetter(value = "initialBound")
    BigDecimal getInitialBound();

    /**
     * Lower prior variance limit for grid-search
     * @return lowerLimit
     **/
    @JsonGetter(value = "lowerLimit")
    BigDecimal getLowerLimit();

    /**
     * Maximum number of tries to decrease initial trust-region size
     * @return maxBoundCount
     **/
    @JsonGetter(value = "maxBoundCount")
    BigDecimal getMaxBoundCount();

    /**
     * The auto search setting 
     * @return autoSearch
     **/
    @JsonGetter(value = "autoSearch")
    Boolean getAutoSearch();

    /**
     * maximum iterations of Cyclops to attempt before returning a failed-to-converge error
     * @return maxIterations
     **/
    @JsonGetter(value = "maxIterations")
    Integer getMaxIterations();

    /**
     * Minimum number of data for cross validation
     * @return minCVData
     **/
    @JsonGetter(value = "minCVData")
    BigDecimal getMinCVData();

    /**
     * level of Cyclops screen output (\&quot;silent\&quot;, \&quot;quiet\&quot;, \&quot;noisy\&quot;)
     * @return noiseLevel
     **/
    @JsonGetter(value = "noiseLevel")
    NoiseLevelEnum getNoiseLevel();

    /**
     * Specify random number generator seed. A null value sets seed via Sys.time.
     * @return seed
     **/
    @JsonGetter(value = "seed")
    BigDecimal getSeed();
    
    /**
     * Reset all coefficients to 0 between model fits under cross-validation 
     * @return resetCoefficients
     **/
    @JsonGetter(value = "resetCoefficients")
    Boolean getResetCoefficients();
    

    /**
     * name of exchangeable sampling unit. Option \&quot;byPid\&quot; selects entire strata. Option \&quot;byRow\&quot; selects single rows. If set to \&quot;auto\&quot;, \&quot;byRow\&quot; will be used for all models except conditional models where the average number of rows per stratum is smaller than the number of strata.
     * @return selectorType
     **/
    @JsonGetter(value = "selectorType")
    String getSelectorType();

    /**
     * Starting variance for auto-search cross-validation; default &#x3D; -1 (use estimate based on data)
     * @return startingVariance
     **/
    @JsonGetter(value = "startingVariance")
    BigDecimal getStartingVariance();

    /**
     * Use the Karush-Kuhn-Tucker conditions to limit search 
     * @return useKKTSwindle
     **/
    @JsonGetter(value = "useKKTSwindle")
    Boolean getUseKKTSwindle();
    
    /**
     * Specify number of CPU threads to employ in cross-validation; default &#x3D; 1 (auto &#x3D; -1)
     * @return threads
     **/
    @JsonGetter(value = "threads")
    BigDecimal getThreads();

    /**
     * maximum relative change in convergence criterion from successive iterations to achieve convergence
     * @return tolerance
     **/
    @JsonGetter(value = "tolerance")
    BigDecimal getTolerance();

    /**
     * Size multiplier for active set
     * @return tuneSwindle
     **/
    @JsonGetter(value = "tuneSwindle")
    BigDecimal getTuneSwindle();

    /**
     * Upper prior variance limit for grid-search
     * @return upperLimit
     **/
    @JsonGetter(value = "upperLimit")
    BigDecimal getUpperLimit();    
}
