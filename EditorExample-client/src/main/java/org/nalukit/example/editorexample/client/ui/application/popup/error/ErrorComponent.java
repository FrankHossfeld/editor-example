package org.nalukit.example.editorexample.client.ui.application.popup.error;

import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

import java.util.Map;
import java.util.Objects;

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
public class ErrorComponent
    extends AbstractErrorPopUpComponent<IErrorComponent.Controller>
    implements IErrorComponent {
  
  DialogBox dialog;
  
  DockLayoutPanel dlp;
  
  VerticalPanel center;
  
  public ErrorComponent() {
    super();
  }
  
  @Override
  public void render() {
    dlp = new DockLayoutPanel(Style.Unit.PX);
    dlp.setSize("712px",
                "512px");
    center = new VerticalPanel();
    center.setSpacing(24);
    SimplePanel cpWest  = new SimplePanel();
    SimplePanel cpSouth = new SimplePanel();
    SimplePanel sp02    = new SimplePanel();
    cpSouth.add(sp02);
    sp02.setWidth("100%");
    sp02.getElement()
        .getStyle()
        .setTextAlign(Style.TextAlign.CENTER);
    sp02.getElement()
        .getStyle()
        .setVerticalAlign(Style.VerticalAlign.MIDDLE);
    dlp.addSouth(cpSouth,
                 48);
    sp02.add(new Button("OK",
                        (ClickHandler) clickEvent -> {
                          dialog.hide();
                          getController().doRouteHome();
                        }));
    SimplePanel sp01 = new SimplePanel();
    cpWest.add(sp01);
    dlp.addWest(cpWest,
                192);
    SimplePanel cpCenter = new SimplePanel();
    cpCenter.setWidget(this.center);
    dlp.add(cpCenter);
    dialog = new DialogBox();
    dialog.setText("Error Message");
    dialog.setGlassEnabled(true);
    dialog.setModal(true);
    dialog.setWidget(dlp);
  }
  
  @Override
  public void show() {
    GWT.debugger();
    dialog.show();
    dialog.center();
  }
  
  @Override
  public void hide() {
    dialog.hide();
  }
  
  @Override
  public void bind() {
  }
  
  @Override
  public void clear() {
    center.clear();
  }
  
  @Override
  public void edit(ErrorInfo.ErrorType errorEventType,
                   String route,
                   String message,
                   Map<String, String> dataStore) {
    Label errorType = new Label();
    errorType.getElement()
             .getStyle()
             .setProperty("fontSize",
                          "18px");
    setUpElement(errorType.getElement(),
                 true);
    if (ErrorInfo.ErrorType.APPLICATION_ERROR == errorEventType) {
      errorType.setText("An Application Error occured!");
    } else {
      errorType.setText("A Nalu Error occured!");
    }
    center.add(errorType);
    if (!Objects.isNull(route)) {
      printMessage("Route:",
                   route);
      ;
    }
    printMessage("Error:",
                 message);
    ;
    dlp.forceLayout();
  }
  
  private void setUpElement(Element element,
                            Boolean bold) {
    element.getStyle()
           .setProperty("fontSize",
                        "18px");
    element.getStyle()
           .setProperty("fontFamily",
                        "Helvetica,Arial,sans-serif");
    element.getStyle()
           .setProperty("color",
                        "black");
    if (bold) {
      element.getStyle()
             .setProperty("fontWeight",
                          "bold");
    }
  }
  
  private void printMessage(String headline,
                            String text) {
    Label headlineLine = new Label(headline);
    this.setUpElement(headlineLine.getElement(),
                      true);
    this.center.add(headlineLine);
    Label textLabel = new Label(text);
    this.setUpElement(textLabel.getElement(),
                      false);
    this.center.add(textLabel);
  }
  
}
