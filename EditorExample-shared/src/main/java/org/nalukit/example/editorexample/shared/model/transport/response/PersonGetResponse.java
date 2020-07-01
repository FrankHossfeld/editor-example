package org.nalukit.example.editorexample.shared.model.transport.response;

import org.dominokit.jacksonapt.annotation.JSONMapper;
import org.nalukit.example.editorexample.shared.model.dto.Person;

@JSONMapper
public class PersonGetResponse
    extends AbstractResponse {
  
  private Person person;
  
  public PersonGetResponse() {
  }
  
  public Person getPerson() {
    return person;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
}
