package org.opendxp.solutionmanager.ui.solutions;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.opendxp.solutionmanager.services.Feature;
import org.opendxp.solutionmanager.services.FeatureService;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

import javax.inject.Inject;
import java.io.InputStream;

@Route(value = "import", layout = SolutionsLayout.class)
@PageTitle("Import Feature")
public class ImportView extends VerticalLayout {

  @Inject
  public ImportView(FeatureService featureService) {

    Div branding = new Div();
    branding.setText("Import Page");

    add(branding);

    MemoryBuffer buffer = new MemoryBuffer();
    Upload upload = new Upload(buffer);

    upload.addSucceededListener(event -> {

      try {
        Yaml yaml = new Yaml();
        InputStream inputStream = buffer.getInputStream();
        Feature feature = yaml.loadAs(inputStream, Feature.class);
        featureService.importFeature(feature);
      } catch (YAMLException ex) {
        Notification.show(ex.getLocalizedMessage());
      }
      Notification.show("File Upload " + event.getFileName() + " " + event.getMIMEType() + " " + event.getContentLength() + " Bytes");
      upload.getUI().ifPresent(ui -> ui.navigate(LandingView.class));
    });

    add(upload);
  }

  private Component createComponent(String mimeType, String fileName, InputStream inputStream) {
    return null;
  }

}
