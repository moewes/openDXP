package org.opendxp.solutionmanager.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.opendxp.solutionmanager.system.SolutionManager;

import javax.inject.Inject;

@Route("")
public class MainView extends VerticalLayout {

  @Inject
  private SolutionManager sm;

  public MainView() {
    Button button = new Button("Test",
            event -> Notification.show("Hello from openDXP Solutionmanager - Version: " + sm.getVersion()));
    add(button);
  }
}
