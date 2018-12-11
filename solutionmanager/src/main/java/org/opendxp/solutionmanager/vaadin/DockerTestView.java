package org.opendxp.solutionmanager.vaadin;

import com.github.dockerjava.api.model.Network;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
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

  private VerticalLayout tabContent = new VerticalLayout();

  @Inject
  public DockerTestView(DockerMaschine dm) {


    Button button = new Button("Test",
            event -> Notification.show("Hello from openDXP Solutionmanager - Version: " + sm.getVersion() + dm.getInfo() + sm.getUserId()));
    add(button);
    Text text = new Text(dm.getInfo());
    add(text);

    Div menu = new Div();
    menu.add(new RouterLink("Home", MainView.class));
    menu.add(new RouterLink("Greeting", MainView.class));
    add(menu);

    Tab tab1 = new Tab("Networks");
    Tab tab2 = new Tab("Tab two");
    Tab tab3 = new Tab("Tab three");
    Tabs tabs = new Tabs(tab1, tab2, tab3);
    tabs.setFlexGrowForEnclosedTabs(1);

    tabs.addSelectedChangeListener(event -> {

      tabContent.removeAll();
      switch (tabs.getSelectedIndex()) {
        case 0:
          addNetworksToTabContent(tabContent,dm);
          break;
        case 1:
          Div a = new Div();
          a.setText("Page 2");
          tabContent.add(a);
          break;
        case 2:
          Div b = new Div();
          b.setText("Page 3");
          tabContent.add(b);
      }
    });

    add(tabs);

    addNetworksToTabContent(tabContent,dm);

    add(tabContent);

  }

  private void addNetworksToTabContent(HasComponents parent, DockerMaschine dm) {

    Grid<Network> grid = new Grid<>();

    grid.setItems(dm.getNetworks());

    grid.addColumn(Network::getName).setHeader("Name");
    grid.addColumn(Network::getOptions).setHeader("Options");

    parent.add(grid);
  }



}
