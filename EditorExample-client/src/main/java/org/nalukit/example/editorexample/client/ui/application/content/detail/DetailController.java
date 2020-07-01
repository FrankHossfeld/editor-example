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

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import elemental2.dom.DomGlobal;
import org.nalukit.example.editorexample.client.Context;
import org.nalukit.example.editorexample.client.Routes;
import org.nalukit.example.editorexample.client.event.StatusChangeEvent;
import org.nalukit.example.editorexample.shared.model.dto.Person;
import org.nalukit.example.editorexample.shared.model.service.PersonServiceFactory;

@Controller(route = "/application/detail/:id",
            selector = "content",
            componentInterface = IDetailComponent.class,
            component = DetailComponent.class)
public class DetailController
    extends AbstractComponentController<Context, IDetailComponent, Widget>
    implements IDetailComponent.Controller {
  
  private Person person;
  
  private long id;
  
  public DetailController() {
  }
  
  @Override
  public String mayStop() {
    return this.component.isDirty() ? "Would youlike to cancel your edits?" : null;
  }
  
  @Override
  public void start() {
    if (this.id == 0) {
      this.router.route(Routes.ROUTE_SEARCH);
    }
    PersonServiceFactory.INSTANCE.get(String.valueOf(id))
                                 .onSuccess(response -> {
                                   person = response.getPerson();
                                   component.edit(person);
                                   eventBus.fireEvent(new StatusChangeEvent("Edit person data with id: " + this.person.getId()));
                                 })
                                 .onFailed(failedResponse -> Window.alert("PANIC ... turn around and clap your hands ..."))
                                 .send();
  }
  
  @Override
  public void stop() {
    this.eventBus.fireEvent(new StatusChangeEvent(""));
  }
  
  @AcceptParameter("id")
  public void setId(String id)
      throws RoutingInterceptionException {
    try {
      this.id = Long.parseLong(id);
    } catch (NumberFormatException e) {
      DomGlobal.window.alert("id is not valid ->  moving to search");
      throw new RoutingInterceptionException(this.getClass()
                                                 .getCanonicalName(),
                                             Routes.ROUTE_SEARCH,
                                             this.context.getPersonSearch()
                                                         .getName(),
                                             this.context.getPersonSearch()
                                                         .getCity());
    }
  }
  
  @Override
  public Person getPerson() {
    return this.person;
  }
  
  @Override
  public void doRevert() {
    this.router.route(Routes.ROUTE_LIST,
                      this.context.getPersonSearch()
                                  .getName(),
                      this.context.getPersonSearch()
                                  .getCity());
  }
  
  @Override
  public void doUpdate() {
    PersonServiceFactory.INSTANCE.update(component.flush(person))
                                 .onSuccess(response -> {
                                   if (this.context.getPersonSearch()
                                                   .getName() == null && this.context.getPersonSearch()
                                                                                     .getCity() == null) {
                                     this.router.route(Routes.ROUTE_SEARCH);
                                   } else {
                                     this.router.route(Routes.ROUTE_LIST,
                                                       this.context.getPersonSearch()
                                                                   .getName(),
                                                       this.context.getPersonSearch()
                                                                   .getCity());
                                   }
                                 })
                                 .onFailed(failedResponse -> Window.alert("Panic!"))
                                 .send();
  }
  
  @Override
  public String getHRef() {
    return "#" +
           this.router.generate(Routes.ROUTE_SEARCH,
                                this.context.getPersonSearch()
                                            .getName(),
                                this.context.getPersonSearch()
                                            .getCity());
  }
  
}
