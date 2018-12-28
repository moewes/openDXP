package org.opendxp.solutionmanager.services;

import java.util.ArrayList;
import java.util.List;

public class SystemLandscape {

  private String name;
  private List<SystemEnvironment> environments = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SystemEnvironment> getEnvironments() {
    return environments;
  }

  public void setEnvironments(List<SystemEnvironment> environments) {
    this.environments = environments;
  }
}
