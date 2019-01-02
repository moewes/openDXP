package org.opendxp.solutionmanager.ui.solutions;

import com.github.dockerjava.api.model.Network;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.opendxp.solutionmanager.services.Feature;
import org.opendxp.solutionmanager.services.FeatureService;
import org.opendxp.solutionmanager.ui.infrastruture.InfrastructureLayout;

import javax.inject.Inject;

@Route(value = "landing", layout = SolutionsLayout.class)
@PageTitle("Solutions")
public class LandingView extends VerticalLayout {

  @Inject
  public LandingView(FeatureService featureService) {

    Div branding = new Div();
    branding.setText("Solutions Landing Page");

    add(branding);

    Grid<Feature> grid = new Grid<>();

    grid.setItems(featureService.getFeatures());

    grid.addColumn(Feature::getName).setHeader("Name");
    grid.addColumn(Feature::getDescription).setHeader("Description");

    add(grid);

  }
}
