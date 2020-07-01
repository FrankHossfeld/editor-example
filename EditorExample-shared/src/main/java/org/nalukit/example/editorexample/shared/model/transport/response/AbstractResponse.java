package org.nalukit.example.editorexample.shared.model.transport.response;

import org.nalukit.example.editorexample.shared.model.AbstractDto;

public class AbstractResponse
    extends AbstractDto {
  
  private Status status;
  
  public Status getStatus() {
    return status;
  }
  
  public void setStatus(Status status) {
    this.status = status;
  }
  
}
