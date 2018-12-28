package org.opendxp.solutionmanager.ui.infrastruture;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "landing", layout = InfrastructureLayout.class)
@PageTitle("Infrastructure")
public class LandingView extends VerticalLayout {

  public LandingView() {

    Div branding = new Div();
    branding.setText("Infrastructure Landing Page");

    add(branding);
  }
}
