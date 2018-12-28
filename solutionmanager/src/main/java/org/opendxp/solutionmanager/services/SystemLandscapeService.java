package org.opendxp.solutionmanager.services;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class SystemLandscapeService {

  private SystemLandscape systemLandscape;

  @Lock(LockType.READ)
  public SystemLandscape getSystemLandscape() {

    if (systemLandscape == null) {
      systemLandscape = new SystemLandscape();
      systemLandscape.setName("New Instance");
    }

    return systemLandscape;
  }

  @Lock(LockType.WRITE)
  public void saveSystemLandscape(SystemLandscape systemLandscape) {

    this.systemLandscape = systemLandscape;

    this.systemLandscape.setName(systemLandscape.getName() + "!");
  }
}
