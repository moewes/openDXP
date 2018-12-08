package org.opendxp.solutionmanager.vaadin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("infrastructure")
public class InfrastructureView extends Div {

  public InfrastructureView() {

    AppLayout appLayout = new AppLayout();
   // AppLayoutMenu menu = appLayout.createMenu();

  /*  menu.addMenuItems(
            new AppLayoutMenuItem(VaadinIcon.USER.create(), "My Profile", ""),
            new AppLayoutMenuItem(VaadinIcon.TRENDING_UP.create(), "Trending Topics", "infrastructure"),
            new AppLayoutMenuItem(VaadinIcon.SIGN_OUT.create(), "Sign Out", e -> logout()));

    appLayout.setMenu(menu); */

    Div branding = new Div();
    branding.setText("Hallo Welt");

    appLayout.setBranding(branding);
    Text text = new Text("Hallo");
   // add(text);

    appLayout.setContent(text);

    add(appLayout);


  }

  public void logout() {

  }
}
