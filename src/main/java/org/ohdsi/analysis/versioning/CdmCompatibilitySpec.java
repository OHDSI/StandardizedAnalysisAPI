package org.ohdsi.analysis.versioning;

public interface CdmCompatibilitySpec {

  String getCdmVersionRange();
  void setCdmVersionRange(String cdmRange);
}
