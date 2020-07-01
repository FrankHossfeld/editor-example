package org.nalukit.example.editorexample.shared.model.transport.response;

import org.dominokit.jacksonapt.annotation.JSONMapper;
import org.nalukit.example.editorexample.shared.model.dto.Person;

@JSONMapper
public class PersonChangeResponse
    extends AbstractResponse {
  
  private Person person;
  
  public PersonChangeResponse() {
  }
  
  public PersonChangeResponse(Person person) {
    this.person = person;
  }
  
  public Person getPerson() {
    return person;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
}
