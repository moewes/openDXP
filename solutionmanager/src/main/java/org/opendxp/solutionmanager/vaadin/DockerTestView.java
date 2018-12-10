package org.opendxp.solutionmanager.vaadin;

import com.github.dockerjava.api.model.Network;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.opendxp.solutionmanager.system.DockerMaschine;
import org.opendxp.solutionmanager.system.SolutionManager;

import javax.inject.Inject;
import java.util.List;

@Route(value = "Docker", layout = TestLayout.class)
@PageTitle("Docker Test")
public class DockerTestView extends VerticalLayout  {

  @Inject
  private SolutionManager sm;

  @Inject
  public DockerTestView(DockerMaschine dm) {


    Button button = new Button("Test",
            event -> Notification.show("Hello from openDXP Solutionmanager - Version: " + sm.getVersion() + dm.getInfo()));
    add(button);
    Text text = new Text(dm.getInfo());
    add(text);

    Div menu = new Div();
    menu.add(new RouterLink("Home", MainView.class));
    menu.add(new RouterLink("Greeting", MainView.class));
    add(menu);

    List<Network> networks = dm.getNetworks();

    for (Network network : networks) {
      Div entry = new Div();
      entry.setText(network.getId() + " " + network.getName() + " " + network.getOptions().toString());
      add(entry);
    }
  }

}
