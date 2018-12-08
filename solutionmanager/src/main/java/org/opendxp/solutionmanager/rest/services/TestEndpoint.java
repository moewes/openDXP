package org.opendxp.solutionmanager.rest.services;

import org.opendxp.solutionmanager.system.DockerMaschine;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestEndpoint {

  @Inject
  DockerMaschine dm;

  @GET
  @Produces("text/plain")
  public Response doGet() {
    return Response.ok("Hello from openDXP Solutionmanager!" + dm.getInfo()).build();
  }
}
