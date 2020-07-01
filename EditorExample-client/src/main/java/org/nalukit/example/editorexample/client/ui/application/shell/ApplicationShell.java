package org.nalukit.example.editorexample.client.ui.application.shell;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.IsShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.plugin.gwt.client.annotation.Selector;
import com.github.nalukit.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.*;
import org.nalukit.example.editorexample.client.Context;
import org.nalukit.example.editorexample.client.Slots;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Shell("application")
public class ApplicationShell
    extends AbstractShell<Context> {
  
  ResizeLayoutPanel shell;
  
  private SimpleLayoutPanel headerWidget;
  
  private SimpleLayoutPanel navigationWidget;
  
  private SimpleLayoutPanel footerWidget;
  
  private SimpleLayoutPanel contentWidget;
  
  public ApplicationShell() {
    super();
  }
  
  @Override
  public void attachShell() {
    RootLayoutPanel.get()
                   .add(this.render());
  }
  
  private Widget render() {
    shell = new ResizeLayoutPanel();
    shell.setSize("100%",
                  "100%");
    shell.addResizeHandler(new ResizeHandler() {
      
      @Override
      public void onResize(ResizeEvent event) {
        forceLayout();
      }
    });
    DockLayoutPanel container = new DockLayoutPanel(Style.Unit.PX);
    container.setSize("100%",
                      "100%");
    shell.add(container);
    headerWidget = new SimpleLayoutPanel();
    container.addNorth(headerWidget,
                       128);
    navigationWidget = new SimpleLayoutPanel();
    container.addWest(navigationWidget,
                      212);
    footerWidget = new SimpleLayoutPanel();
    container.addSouth(footerWidget,
                       42);
    contentWidget = new SimpleLayoutPanel();
    container.add(contentWidget);
    return shell;
  }
  
  private void forceLayout() {
  }
  
  @Override
  public void bind(IsShell.ShellLoader loader) {
    IsSelectorProvider<ApplicationShell> provider = new ApplicationShellSelectorProviderImpl();
    provider.initialize(this);
    loader.continueLoading();
  }
  
  @Override
  public void detachShell() {
    this.shell.removeFromParent();
  }
  
  @Selector(Slots.SLOT_HEADER)
  public void addHeader(Widget widget) {
    this.headerWidget.clear();
    this.headerWidget.add(widget);
  }
  
  @Selector(Slots.SLOT_NAVIGATION)
  public void addNavigation(Widget widget) {
    this.navigationWidget.clear();
    this.navigationWidget.add(widget);
  }
  
  @Selector(Slots.SLOT_FOOTER)
  public void addFooter(Widget widget) {
    this.footerWidget.clear();
    this.footerWidget.add(widget);
  }
  
  @Selector(Slots.SLOT_CONTENT)
  public void addContent(Widget widget) {
    this.contentWidget.clear();
    this.contentWidget.add(widget);
  }
  
}
