package org.opendxp.solutionmanager.services;

import com.helger.commons.annotation.Singleton;
import org.yaml.snakeyaml.Yaml;

import javax.ejb.Lock;
import javax.ejb.LockType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class FeatureService {

  class Features {
    private List<Feature> features = new ArrayList<>();;

    public List<Feature> getFeatures() {
      return features;
    }

    public void setFeatures(List<Feature> features) {
      this.features = features;
    }
  }

  private static final String FILENAME = "features.yml";

  private Features features = new Features();

  public FeatureService() {
    File file = new File(FILENAME);
    if (file.exists()) {
      try {
        FileInputStream fip = new FileInputStream(file);
        Yaml yaml = new Yaml();
        features = yaml.loadAs(fip, Features.class);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  @Lock(LockType.WRITE)
  public Feature importFeature(String importedYaml) {

    Yaml yaml = new Yaml();
    Feature feature = yaml.loadAs(importedYaml, Feature.class);
    features.getFeatures().add(feature);

    return feature;
  }

  @Lock(LockType.READ)
  public List<Feature> getFeatures() {
    return features.getFeatures();
  }
}
