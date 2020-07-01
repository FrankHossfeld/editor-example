package org.nalukit.example.editorexample.client.ui.application.shell.content.statusbar;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

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
public class StatusbarComponent
    extends AbstractComponent<IStatusbarComponent.Controller, Widget>
    implements IStatusbarComponent {
  
  private Label label;
  
  public StatusbarComponent() {
    super();
  }
  
  @Override
  public void edit(String message) {
    label.setText(message);
  }
  
  @Override
  public void render() {
    SimplePanel container = new SimplePanel();
    container.setSize("100%",
                      "100%");
    container.getElement()
             .getStyle()
             .setBackgroundColor("whitesmoke");
    container.getElement()
             .getStyle()
             .setPadding(12,
                         Style.Unit.PX);
    label = new Label();
    container.setWidget(label);
    initElement(container);
  }
  
}
