package org.nalukit.example.editorexample.client.ui.login.content.login;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.user.client.ui.*;
import org.nalukit.example.editorexample.client.ui.widget.text.PasswordField;
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
public class LoginComponent
    extends AbstractComponent<ILoginComponent.Controller, Widget>
    implements ILoginComponent {
  
  private TextField userId;
  
  private PasswordField password;
  
  public LoginComponent() {
    super();
  }
  
  @Override
  public void render() {
    this.userId   = new TextField("User:");
    this.password = new PasswordField("Password");
    Button button = new Button("login");
    button.addClickHandler(e -> getController().doLogin(this.userId.getValue(),
                                                        this.password.getValue()));
    VerticalPanel vlc = new VerticalPanel();
    vlc.setWidth("312px");
    vlc.setHeight("256px");
    vlc.add(new Label("Login"));
    vlc.add(this.userId);
    vlc.add(this.password);
    vlc.add(button);
    vlc.setCellHorizontalAlignment(button,
                                   HasHorizontalAlignment.ALIGN_RIGHT);
    initElement(vlc);
  }
  
}
