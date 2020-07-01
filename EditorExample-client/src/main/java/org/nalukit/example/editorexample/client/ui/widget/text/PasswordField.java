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

package org.nalukit.example.editorexample.client.ui.widget.text;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.user.client.ui.*;

public class PasswordField
    extends Composite
    implements HasText,
               HasValue<String>,
               IsEditor<ValueBoxEditor<String>>,
               Focusable {
  
  private TextFieldStyle style;
  
  private Label label;
  
  private PasswordTextBox passwordTextBox;
  
  private FlowPanel panel;
  
  private ResizeLayoutPanel widgetPanel;
  
  public PasswordField() {
    this(null);
  }
  
  public PasswordField(String label) {
    Resources resources = GWT.create(Resources.class);
    this.style = resources.style();
    this.style.ensureInjected();
    
    createWidget();
    
    setLabel(label);
  }
  
  private void createWidget() {
    widgetPanel = new ResizeLayoutPanel();
    widgetPanel.addStyleName(style.widgetPanel());
    widgetPanel.addResizeHandler(event -> forceLayout());
    
    panel = new FlowPanel();
    panel.addStyleName(style.panel());
    widgetPanel.add(panel);
    
    label = new Label();
    label.addStyleName(style.label());
    panel.add(label);
    
    passwordTextBox = new PasswordTextBox();
    passwordTextBox.addStyleName(style.textBox());
    panel.add(passwordTextBox);
    
    initWidget(widgetPanel);
  }
  
  public void forceLayout() {
    if (this.isAttached()) {
      Widget parent = getParent();
      if (parent != null) {
        int parentWidth = parent.getOffsetWidth();
        
        label.setWidth(Integer.toString(parentWidth - 48) + "px");
        passwordTextBox.setWidth(Integer.toString(parentWidth - 48) + "px");
      }
    }
  }
  
  public String getLabel() {
    return label.getText();
  }
  
  public void setLabel(String label) {
    if (label != null && label.length() > 0) {
      this.label.setText(label);
      this.label.setVisible(true);
      super.setHeight("68px");
    } else {
      this.label.setText("");
      this.label.setVisible(false);
      super.setHeight("42px");
    }
  }
  
  @Override
  public int getTabIndex() {
    return passwordTextBox.getTabIndex();
  }
  
  @Override
  public void setTabIndex(int index) {
    passwordTextBox.setTabIndex(index);
  }
  
  @Override
  public void setAccessKey(char key) {
    passwordTextBox.setAccessKey(key);
  }
  
  @Override
  public void setFocus(boolean focused) {
    passwordTextBox.setFocus(focused);
  }
  
  @Override
  public String getText() {
    return passwordTextBox.getText();
  }
  
  @Override
  public void setText(String text) {
    this.passwordTextBox.setText(text);
  }
  
  public void setWidth(String width) {
    assert false : "setting width not allowed";
  }
  
  public void onLoad() {
    super.onLoad();
    Scheduler.get()
             .scheduleDeferred(new ScheduledCommand() {
      
               @Override
               public void execute() {
                 forceLayout();
               }
             });
  }
  
  @Override
  public ValueBoxEditor<String> asEditor() {
    return passwordTextBox.asEditor();
  }
  
  @Override
  public String getValue() {
    return passwordTextBox.getValue();
  }
  
  @Override
  public void setValue(String s) {
    passwordTextBox.setValue(s);
  }
  
  @Override
  public void setValue(String s,
                       boolean b) {
    passwordTextBox.setValue(s,
                             b);
  }
  
  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> valueChangeHandler) {
    return passwordTextBox.addValueChangeHandler(valueChangeHandler);
  }
  
  public interface Resources
      extends ClientBundle {
    
    @Source("TextFieldStyle.css")
    TextFieldStyle style();
    
  }
  
}
