package org.ohdsi.analysis.versioning;

public interface CdmCompatibilitySpec {

  double getMinCdmVersion();
  void setMinCdmVersion(double version);

  double getMaxCdmVersion();
  void setMaxCdmVersion(double version);
}
