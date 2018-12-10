package org.opendxp.solutionmanager.vaadin;

import com.vaadin.flow.component.applayout.AbstractAppRouterLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RoutePrefix;

public class MainLayout extends AbstractAppRouterLayout {

  @Override
  protected void configure(AppLayout appLayout, AppLayoutMenu appLayoutMenu) {

    Div branding = new Div();
    branding.setText("openDXP Solutionmanager");

    appLayout.setBranding(branding);

    AppLayoutMenu menu = appLayout.createMenu();

    appLayoutMenu.addMenuItems(
            new AppLayoutMenuItem(VaadinIcon.HOME.create(), "", ""),
            new AppLayoutMenuItem(VaadinIcon.TRENDING_UP.create(), "Tests", "test/Docker"));

    appLayout.setMenu(appLayoutMenu);
  }
}
