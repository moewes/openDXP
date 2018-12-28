package org.opendxp.solutionmanager.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Home")
public class MainView extends VerticalLayout {

  public MainView() {

    Div branding = new Div();
    branding.setText("Hallo Welt");

    add(branding);
  }

  public void logout() {

  }
}
