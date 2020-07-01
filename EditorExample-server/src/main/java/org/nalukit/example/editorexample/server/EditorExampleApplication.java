package org.nalukit.example.editorexample.server;

import org.nalukit.example.editorexample.server.filter.LoggingRequestFilter;
import org.nalukit.example.editorexample.server.filter.LoggingResponseFilter;

import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EditorExampleApplication
    extends Application {
  
  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<>();
    classes.add(LoggingRequestFilter.class);
    classes.add(LoggingResponseFilter.class);
    return classes;
  }
  
  @Override
  public Map<String, Object> getProperties() {
    Map<String, Object> properties = new HashMap<>();
    return properties;
  }
  
}