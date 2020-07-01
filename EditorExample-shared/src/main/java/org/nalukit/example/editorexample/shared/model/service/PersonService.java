package org.nalukit.example.editorexample.shared.model.service;

import org.dominokit.domino.rest.shared.request.service.annotations.RequestBody;
import org.dominokit.domino.rest.shared.request.service.annotations.RequestFactory;
import org.nalukit.example.editorexample.shared.model.dto.Person;
import org.nalukit.example.editorexample.shared.model.dto.PersonSearch;
import org.nalukit.example.editorexample.shared.model.transport.response.PersonChangeResponse;
import org.nalukit.example.editorexample.shared.model.transport.response.PersonGetResponse;
import org.nalukit.example.editorexample.shared.model.transport.response.PersonSearchResponse;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RequestFactory
public interface PersonService {
  
  @GET
  @Path("/person/get/{id}")
  PersonGetResponse get(@PathParam("id") String id);
  
  @POST
  @Path("/person/getAll")
  PersonSearchResponse getAll(@RequestBody PersonSearch request);
  
  @POST
  @Path("/person/insert")
  PersonChangeResponse insert(@RequestBody Person request);
  
  @POST
  @Path("/person/update")
  PersonChangeResponse update(@RequestBody Person request);
  
}
