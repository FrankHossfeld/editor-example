package org.nalukit.example.editorexample.client.ui.application.shell.content.header;

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
public class HeaderComponent
    extends AbstractComponent<IHeaderComponent.Controller, Widget>
    implements IHeaderComponent {
  
  private SimplePanel container;
  
  public HeaderComponent() {
    super();
  }
  
  @Override
  public void render() {
    container = new SimplePanel();
    container.setSize("100%",
                      "100%");
    container.getElement()
             .getStyle()
             .setBackgroundColor("whitesmoke");
    container.getElement()
             .getStyle()
             .setPadding(12,
                         Style.Unit.PX);
    Label label = new Label("That's the header area. Create your header here");
    container.setWidget(label);
    initElement(container);
  }
  
}
