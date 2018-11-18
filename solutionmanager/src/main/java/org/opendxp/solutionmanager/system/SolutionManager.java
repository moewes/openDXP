package org.opendxp.solutionmanager.system;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SolutionManager {

  public String getVersion() {
    return "development 0.1.0";
  }
}
