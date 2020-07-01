package org.nalukit.example.editorexample.client.ui.application.content.search;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import org.nalukit.example.editorexample.client.resources.ApplicationConstants;
import org.nalukit.example.editorexample.client.resources.ApplicationCss;
import org.nalukit.example.editorexample.client.resources.ApplicationStyleFactory;
import org.nalukit.example.editorexample.client.ui.widget.text.TextField;

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
public class SearchComponent
    extends AbstractComponent<ISearchComponent.Controller, Widget>
    implements ISearchComponent {
  
  private TextField searchName;
  
  private TextField searchCity;
  
  private Button searchButton;
  
  private Button resetButton;
  
  public SearchComponent() {
    super();
  }
  
  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();
    ScrollPanel panel = new ScrollPanel();
    panel.getElement()
         .getStyle()
         .setPadding(20,
                     Style.Unit.PX);
    
    FlowPanel searchPanel = new FlowPanel();
    searchPanel.addStyleName(style.searchPanel());
    panel.add(searchPanel);
    
    Label headline = new Label(ApplicationConstants.CONSTANTS.searchHeadline());
    headline.addStyleName(style.headline());
    searchPanel.add(headline);
    
    searchName = new TextField(ApplicationConstants.CONSTANTS.searchName());
    searchPanel.add(searchName);
    
    searchCity = new TextField(ApplicationConstants.CONSTANTS.searchCity());
    searchPanel.add(searchCity);
    
    FlowPanel buttonBar = new FlowPanel();
    buttonBar.addStyleName(style.searchPanelButtonBar());
    searchPanel.add(buttonBar);
    
    searchButton = new Button(ApplicationConstants.CONSTANTS.searchButton());
    searchButton.addStyleName(style.button());
    buttonBar.add(searchButton);
    
    resetButton = new Button(ApplicationConstants.CONSTANTS.resetButton());
    resetButton.addStyleName(style.button());
    buttonBar.add(resetButton);
    
    initElement(panel);
  }
  
  @Override
  public void bind() {
    searchButton.addClickHandler(event -> getController().doClickSearchButton(searchName.getText(),
                                                                              searchCity.getText()));
    
    resetButton.addClickHandler(event -> {
      searchName.setText("");
      searchCity.setText("");
    });
  }
  
  @Override
  public void setSearchName(String searchName) {
    this.searchName.setText(searchName);
  }
  
  @Override
  public void setSearchCity(String searchCity) {
    this.searchCity.setText(searchCity);
  }
  
}
