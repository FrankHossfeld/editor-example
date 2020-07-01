/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package org.nalukit.example.editorexample.client.ui.application.content.detail;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.*;
import org.nalukit.example.editorexample.client.resources.ApplicationConstants;
import org.nalukit.example.editorexample.client.resources.ApplicationCss;
import org.nalukit.example.editorexample.client.resources.ApplicationStyleFactory;
import org.nalukit.example.editorexample.client.ui.widget.text.TextField;
import org.nalukit.example.editorexample.shared.model.dto.Person;

public class DetailComponent
    extends AbstractComponent<IDetailComponent.Controller, Widget>
    implements IDetailComponent,
               Editor<Person> {

  @Path("firstName")
  TextField detailFirstName;
  @Path("name")
  TextField detailName;
  @Path("address.street")
  TextField detailStreet;
  @Path("address.zip")
  TextField detailZip;
  @Path("address.city")
  TextField detailCity;
  
  private Button saveButton;
  private Button revertButton;
  private Driver driver;

  public DetailComponent() {
  }
  
  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();

    ScrollPanel panel = new ScrollPanel();
    panel.getElement().getStyle().setPadding(20, Style.Unit.PX);

    FlowPanel detailPanel = new FlowPanel();
    detailPanel.addStyleName(style.detailPanel());
    panel.add(detailPanel);

    Label headline = new Label(ApplicationConstants.CONSTANTS.detailHeadline());
    headline.addStyleName(style.headline());
    detailPanel.add(headline);

    detailFirstName = new TextField(ApplicationConstants.CONSTANTS.detailFirstName());
    detailPanel.add(detailFirstName);

    detailName = new TextField(ApplicationConstants.CONSTANTS.detailName());
    detailPanel.add(detailName);

    detailStreet = new TextField(ApplicationConstants.CONSTANTS.detailStreet());
    detailPanel.add(detailStreet);

    detailZip = new TextField(ApplicationConstants.CONSTANTS.detailZip());
    detailPanel.add(detailZip);

    detailCity = new TextField(ApplicationConstants.CONSTANTS.detailCity());
    detailPanel.add(detailCity);

    FlowPanel buttonBar = new FlowPanel();
    buttonBar.addStyleName(style.searchPanelButtonBar());
    detailPanel.add(buttonBar);

    saveButton = new Button(ApplicationConstants.CONSTANTS.saveButton());
    saveButton.addStyleName(style.button());
    buttonBar.add(saveButton);

    revertButton = new Button(ApplicationConstants.CONSTANTS.revertButton());
    revertButton.addStyleName(style.button());
    buttonBar.add(revertButton);

    Anchor anchor = new Anchor("Quick link to search screen");
    anchor.getElement()
          .getStyle()
          .setMarginLeft(6,
                         Style.Unit.PX);
    anchor.setHref(getController().getHRef());
    detailPanel.add(anchor);

    initElement(panel);
  }

  public void bind() {
    driver = GWT.create(Driver.class);
    driver.initialize(this);
    
    saveButton.addClickHandler(event -> {
      getController().doUpdate();
    });

    revertButton.addClickHandler(event -> getController().doRevert());
  }

  @Override
  public void edit(Person result) {
    if (result != null) {
      driver.edit(result);
    }
  }

  @Override
  public boolean isDirty() {
    return driver.isDirty();
  }

  @Override
  public Person flush() {
    return driver.flush();
  }
  
  interface Driver
      extends SimpleBeanEditorDriver<Person, DetailComponent> {
  }

}
