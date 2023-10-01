/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ohdsi.analysis.cohortincidence.design;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author cknoll1
 */
public class StratifySettings {

	@JsonProperty("byAge")
	public boolean byAge;

	@JsonProperty("byGender")
	public boolean byGender;

	@JsonProperty("byYear")
	public boolean byYear;

	@JsonProperty("ageBreaks")
	public List<Integer> ageBreaks;
	
}
