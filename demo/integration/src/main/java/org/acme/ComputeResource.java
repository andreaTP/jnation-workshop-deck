package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/compute")
public class ComputeResource {

    private static final Logger LOG = Logger.getLogger(ComputeResource.class);

    @Inject
    WasmService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response compute(int content) {

        int output = service.compute(content);

        LOG.infof("Compute(%d) -> %d", content, output);

        return new Response(output);
    }
}