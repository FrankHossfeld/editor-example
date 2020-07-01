package org.nalukit.example.editorexample.client.ui.application.shell.content.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import org.nalukit.example.editorexample.client.resources.ApplicationConstants;
import org.nalukit.example.editorexample.client.resources.ApplicationCss;
import org.nalukit.example.editorexample.client.resources.ApplicationStyleFactory;

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
public class NavigationComponent
    extends AbstractComponent<INavigationComponent.Controller, Widget>
    implements INavigationComponent {
  
  private Button searchButton;
  
  private Button listButton;
  
  public NavigationComponent() {
  }
  
  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();
    FlowPanel panel = new FlowPanel();
    panel.getElement().getStyle().setPadding(10, Style.Unit.PX);
    
    searchButton = new Button(ApplicationConstants.CONSTANTS.searchFormButton());
    searchButton.addStyleName(style.navigationButton());
    panel.add(searchButton);
    
    listButton = new Button(ApplicationConstants.CONSTANTS.listFormButton());
    listButton.addStyleName(style.navigationButton());
    panel.add(listButton);
    
    initElement(panel);
  }
  
  @Override
  public void bind() {
    searchButton.addClickHandler(event -> getController().doShowSearch());
    listButton.addClickHandler(event -> getController().doShowList());
  }
  
}
