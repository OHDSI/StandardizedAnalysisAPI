/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ohdsi.analysis.pathway;

import java.util.ArrayList;
import java.util.Collection;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.analysis.pathway.design.PathwayAnalysis;

/**
 *
 * @author cknoll1
 */
public class DefaultMockPathwayAnalysis implements PathwayAnalysis{

	@Override
	public String getName() {
		return "Mock Analysis";
	}

	@Override
	public Collection<? extends Cohort> getTargetCohorts() {
		return new ArrayList<>();
	}

	@Override
	public Collection<? extends Cohort> getEventCohorts() {
		return new ArrayList<>();
	}

	@Override
	public Integer getCombinationWindow() {
		return 0;
	}

	@Override
	public Integer getMinSegmentLength() {
		return 0;
	}

	@Override
	public Integer getMinCellCount() {
		return 0;
	}

	@Override
	public Integer getMaxDepth() {
		return 5;
	}

	@Override
	public boolean isAllowRepeats() {
		return false;
	}
}
