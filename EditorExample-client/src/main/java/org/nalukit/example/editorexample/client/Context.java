package org.nalukit.example.editorexample.client;

import com.github.nalukit.nalu.client.context.IsContext;
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
public class Context
    implements IsContext {
  
  private boolean      loggedIn;
  private PersonSearch personSearch;
  
  public Context() {
    personSearch = new PersonSearch();
  }
  
  public boolean isLoggedIn() {
    return this.loggedIn;
  }
  
  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }
  
  public PersonSearch getPersonSearch() {
    return personSearch;
  }
  
  public void setPersonSearch(PersonSearch personSearch) {
    this.personSearch = personSearch;
  }
  
}
