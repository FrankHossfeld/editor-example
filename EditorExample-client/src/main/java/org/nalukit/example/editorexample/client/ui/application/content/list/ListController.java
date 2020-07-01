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

package org.nalukit.example.editorexample.client.ui.application.content.list;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import org.nalukit.example.editorexample.client.Context;
import org.nalukit.example.editorexample.client.Routes;
import org.nalukit.example.editorexample.client.Slots;
import org.nalukit.example.editorexample.client.event.StatusChangeEvent;
import org.nalukit.example.editorexample.shared.model.dto.Person;
import org.nalukit.example.editorexample.shared.model.dto.PersonSearch;
import org.nalukit.example.editorexample.shared.model.service.PersonServiceFactory;

@Controller(route = Routes.ROUTE_LIST,
            selector = Slots.SLOT_CONTENT,
            componentInterface = IListComponent.class,
            component = ListComponent.class)
public class ListController
    extends AbstractComponentController<Context, IListComponent, Widget>
    implements IListComponent.Controller {
  
  private String name;
  
  private String city;
  
  public ListController() {
  }
  
  @Override
  public void start() {
    PersonServiceFactory.INSTANCE.getAll(new PersonSearch(this.name,
                                                          this.city))
                                 .onSuccess(response -> {
                                   this.component.resetTable();
                                   this.component.setData(response.getPersonList());
                                   if (response.getPersonList()
                                               .size() == 0) {
                                     this.eventBus.fireEvent(new StatusChangeEvent("No person found"));
                                   } else if (response.getPersonList()
                                                      .size() == 1) {
                                     this.eventBus.fireEvent(new StatusChangeEvent("Found one person"));
                                   } else {
                                     this.eventBus.fireEvent(new StatusChangeEvent("Found " + response.getPersonList()
                                                                                                      .size() + " persons"));
                                   }
                                 })
                                 .onFailed(repsonse -> Window.alert("PANIC!"))
                                 .send();
  }
  
  @Override
  public void doUpdate(Person object) {
    this.router.route(Routes.ROUTE_DETAIL,
                      Long.toString(object.getId()));
  }
  
  @AcceptParameter("name")
  public void setName(String name) {
    this.name = name;
  }
  
  @AcceptParameter("city")
  public void setCity(String city) {
    this.city = city;
  }
  
}
