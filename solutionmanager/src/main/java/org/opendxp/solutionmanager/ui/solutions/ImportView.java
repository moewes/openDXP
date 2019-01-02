package org.opendxp.solutionmanager.ui.solutions;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.InputStream;

@Route(value = "import", layout = SolutionsLayout.class)
@PageTitle("Import Feature")
public class ImportView extends VerticalLayout {

  public ImportView() {

    Div branding = new Div();
    branding.setText("Import Page");

    add(branding);

    MemoryBuffer buffer = new MemoryBuffer();
    Upload upload = new Upload(buffer);

    upload.addSucceededListener(event -> {
      //Component component = createComponent(event.getMIMEType(),
       //       event.getFileName(), buffer.getInputStream());
      //showOutput(event.getFileName(), component, output);
      //buffer.getInputStream().

      Notification.show("File Upload " + event.getFileName() + " " + event.getMIMEType() + " " + event.getContentLength() + " Bytes");

    });

    add(upload);
  }

  private Component createComponent(String mimeType, String fileName, InputStream inputStream) {
    return null;
  }

}
