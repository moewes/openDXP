package org.opendxp.solutionmanager.ui.solutions;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.opendxp.solutionmanager.ui.infrastruture.InfrastructureLayout;

@Route(value = "landing", layout = SolutionsLayout.class)
@PageTitle("Solutions")
public class LandingView extends VerticalLayout {

  public LandingView() {

    Div branding = new Div();
    branding.setText("Solutions Landing Page");

    add(branding);
  }
}
