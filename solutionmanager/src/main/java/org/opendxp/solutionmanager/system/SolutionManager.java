package org.opendxp.solutionmanager.system;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SolutionManager {

  @Inject
  @ConfigProperty(name="userId", defaultValue="me")
  String userId;

  public String getVersion() {
    return "development 0.1.0";
  }

  public String getUserId() { return userId; }
}
