package org.nalukit.example.editorexample.client.ui.application.content.search;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.ui.Widget;
import org.nalukit.example.editorexample.client.Context;
import org.nalukit.example.editorexample.client.Routes;
import org.nalukit.example.editorexample.client.Slots;
import org.nalukit.example.editorexample.client.event.StatusChangeEvent;
import org.nalukit.example.editorexample.shared.model.MyModel;
import org.nalukit.example.editorexample.shared.model.dto.PersonSearch;

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
@Controller(
    route = Routes.ROUTE_SEARCH,
    selector = Slots.SLOT_CONTENT,
    componentInterface = ISearchComponent.class,
    component = SearchComponent.class
)
public class SearchController
    extends AbstractComponentController<Context, ISearchComponent, Widget>
    implements ISearchComponent.Controller {
  
  private PersonSearch search;
  
  public SearchController() {
  }
  
  @Override
  public void start() {
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>Search<<"));
  }
  
  @Override
  public void doClickSearchButton(String searchName,
                                  String searchCity) {
    this.context.getPersonSearch().setCity(searchCity);
    this.context.getPersonSearch().setName(searchName);
    this.router.route(Routes.ROUTE_LIST,
                      searchName,
                      searchCity);
  }
  
  @AcceptParameter("searchName")
  public void setSearchName(String searchName) {
    if (!"undefined".equals(searchName) &&
        searchName.trim()
                  .length() > 0) {
      this.component.setSearchName(searchName);
    } else {
      if (context.getPersonSearch().getName() != null) {
        this.component.setSearchName(context.getPersonSearch().getName());
      } else {
        this.component.setSearchName("");
      }
    }
  }
  
  @AcceptParameter("searchCity")
  public void setSearchCity(String searchCity) {
    if (!"undefined".equals(searchCity) &&
        searchCity.trim()
                  .length() > 0) {
      this.component.setSearchCity(searchCity);
    } else {
      if (context.getPersonSearch().getCity() != null) {
        this.component.setSearchCity(context.getPersonSearch().getCity());
      } else {
        this.component.setSearchCity("");
      }
    }
  }
  
}
