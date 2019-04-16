package org.ohdsi.analysis.versioning;

public interface CdmCompatibilitySpec {

  String getCdmVersion();
  void setCdmVersion(String version);
}
