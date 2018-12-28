package org.opendxp.solutionmanager.ui.landscape;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.opendxp.solutionmanager.services.SystemLandscape;
import org.opendxp.solutionmanager.services.SystemLandscapeService;
import org.opendxp.solutionmanager.ui.infrastruture.InfrastructureLayout;

import javax.inject.Inject;

@Route(value = "landing", layout = LandscapeLayout.class)
@PageTitle("Systemlandscape")
public class LandingView extends VerticalLayout {

  private SystemLandscapeService landscapeService;

  private Binder<SystemLandscape> binder = new Binder<>();

  @Inject
  public LandingView(SystemLandscapeService landscapeService) {

    this.landscapeService = landscapeService;

    Div branding = new Div();
    branding.setText("Landscape Landing Page");

    add(branding);

    Button button = new Button("Save");

    button.addClickListener(this::showButtonClickedMessage);
    add(button);

    TextField name = new TextField();
    name.setLabel("Name");
    binder.bind(name,SystemLandscape::getName,SystemLandscape::setName);

    add(name);

    binder.readBean(landscapeService.getSystemLandscape());
  }

  private void showButtonClickedMessage(ClickEvent<Button> buttonClickEvent) {

    SystemLandscape landscape = new SystemLandscape();

    try {
      binder.writeBean(landscape);
    } catch (ValidationException e) {
      e.printStackTrace();
    }

    landscapeService.saveSystemLandscape(landscape);

    Notification.show("saved");

    binder.readBean(landscapeService.getSystemLandscape());

  }
}
