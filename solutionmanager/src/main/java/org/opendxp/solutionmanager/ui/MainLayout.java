package org.opendxp.solutionmanager.ui;

import com.vaadin.flow.component.applayout.AbstractAppRouterLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.NoTheme;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;

public class MainLayout extends AbstractAppRouterLayout {

  @Override
  protected void configure(AppLayout appLayout, AppLayoutMenu appLayoutMenu) {

    Div branding = new Div();
    branding.setText("openDXP Solutionmanager");

    appLayout.setBranding(branding);

    AppLayoutMenu menu = appLayout.createMenu();

    appLayoutMenu.addMenuItems(
            new AppLayoutMenuItem(VaadinIcon.HOME.create(), "", ""),
            new AppLayoutMenuItem(VaadinIcon.CLUSTER.create(), "System Landscape", "systemlandscape/landing"),
            new AppLayoutMenuItem(VaadinIcon.SERVER.create(), "Infrastructure", "infrastructure/landing"),
            new AppLayoutMenuItem(VaadinIcon.OPEN_BOOK.create(), "Solutions", "solutions/landing"),
            new AppLayoutMenuItem(VaadinIcon.TERMINAL.create(), "Tests", "test/Docker"));

    appLayout.setMenu(appLayoutMenu);
  }
}
