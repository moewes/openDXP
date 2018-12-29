package org.opendxp.solutionmanager.services;

import org.yaml.snakeyaml.Yaml;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import java.io.*;

@Singleton
public class SystemLandscapeService {

  private SystemLandscape systemLandscape;

  @Lock(LockType.READ)
  public SystemLandscape getSystemLandscape() {

    if (systemLandscape == null) {
      
      File file = new File("./newfile.txt");
      
      if (file.exists()) {
        
        try {
          FileInputStream fip = new FileInputStream(file);
          Yaml yaml = new Yaml();
          systemLandscape = yaml.load(fip);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      } else {
        systemLandscape = new SystemLandscape();
        systemLandscape.setName("New Instance");
      }
    }

    return systemLandscape;
  }

  @Lock(LockType.WRITE)
  public void saveSystemLandscape(SystemLandscape systemLandscape) {

    this.systemLandscape = systemLandscape;

    this.systemLandscape.setName(systemLandscape.getName() + "!");


    Yaml yaml = new Yaml();
    File file = new File("./newfile.txt");
    try (FileOutputStream fop = new FileOutputStream(file)) {

      String s = yaml.dumpAsMap(systemLandscape);
      fop.write(s.getBytes());
      fop.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
