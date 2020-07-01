package org.nalukit.example.editorexample.shared.model.transport.response;

import org.dominokit.jacksonapt.annotation.JSONMapper;
import org.nalukit.example.editorexample.shared.model.dto.Person;

import java.util.ArrayList;
import java.util.List;

@JSONMapper
public class PersonSearchResponse
    extends AbstractResponse {
  
  private List<Person> personList;
  
  public PersonSearchResponse() {
    this.personList = new ArrayList<>();
  }
  
  public List<Person> getPersonList() {
    return personList;
  }
  
  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }
  
}
