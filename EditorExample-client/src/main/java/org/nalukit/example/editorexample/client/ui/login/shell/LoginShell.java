package org.nalukit.example.editorexample.client.ui.login.shell;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.IsShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.plugin.gwt.client.annotation.Selector;
import com.github.nalukit.nalu.plugin.gwt.client.selector.IsSelectorProvider;
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
@Shell("login")
public class LoginShell
    extends AbstractShell<Context> {
  
  VerticalPanel shell;
  
  private SimpleLayoutPanel contentWidget;
  
  public LoginShell() {
    super();
  }
  
  @Override
  public void attachShell() {
    RootLayoutPanel.get()
                   .add(this.render());
  }
  
  private Widget render() {
    shell = new VerticalPanel();
//    shell.setSize("100%",
//                  "100%");
    shell.setWidth("100%");
    shell.setHeight("100%");
    shell.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    shell.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
    contentWidget = new SimpleLayoutPanel();
    contentWidget.setWidth("312px");
    contentWidget.setHeight("256px");
    shell.add(contentWidget);
    return shell;
  }
  
  private void forceLayout() {
  }
  
  @Override
  public void bind(IsShell.ShellLoader loader) {
    IsSelectorProvider<LoginShell> provider = new LoginShellSelectorProviderImpl();
    provider.initialize(this);
    loader.continueLoading();
  }
  
  @Override
  public void detachShell() {
    this.shell.removeFromParent();
  }
  
  @Selector(Slots.SLOT_CONTENT)
  public void addContent(Widget widget) {
    this.contentWidget.clear();
    this.contentWidget.add(widget);
  }
  
}
