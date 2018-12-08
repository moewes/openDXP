package org.opendxp.solutionmanager.vaadin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.opendxp.solutionmanager.system.DockerMaschine;
import org.opendxp.solutionmanager.system.SolutionManager;

import javax.inject.Inject;

@Route("")
public class MainView extends VerticalLayout {

  @Inject
  private SolutionManager sm;

  @Inject
  public MainView(DockerMaschine dm) {
    Button button = new Button("Test",
            event -> Notification.show("Hello from openDXP Solutionmanager - Version: " + sm.getVersion() + dm.getInfo()));
    add(button);
    Text text = new Text(dm.getInfo());
    add(text);

    Div menu = new Div();
    menu.add(new RouterLink("Home", InfrastructureView.class));
    menu.add(new RouterLink("Greeting", InfrastructureView.class));
    add(menu);
  }

}
