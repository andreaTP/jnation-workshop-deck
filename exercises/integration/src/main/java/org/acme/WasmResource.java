package org.acme;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/wasm")
public class WasmResource {

    private static final Logger LOG = Logger.getLogger(WasmResource.class);

    @Inject
    WasmService service;

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.APPLICATION_JSON)
    public Response load(InputStream program) throws IOException {
        try (program) {
            if (program.available() <= 0) {
                throw new IllegalArgumentException("WASM program not imported, lenght is 0");
            }
            service.setModule(new ByteArrayInputStream(program.readAllBytes()));
            LOG.info("WASM program imported.");
            return new Response(0);
        }
    }
}
