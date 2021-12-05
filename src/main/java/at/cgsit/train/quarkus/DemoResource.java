package at.cgsit.train.quarkus;

import at.cgsit.train.quarkus.service.DemoServiceDb;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * doku
 */
@Path("/helloDemo")
public class DemoResource {
    private static final Logger LOG = Logger.getLogger(DemoResource.class);

    @Inject
    DemoServiceDb service;

    /**
     * Quarkus uses MicroProfile Config annotations
     * to inject the configuration properties in the application.
     */
    @ConfigProperty(name = "greeting.message")
    String message;

    /**
     * http://localhost:8080/helloDemo/echo/<inputString>
     * @param inputString
     * @return service processed input string
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/echo/{inputString}")
    public String greeting(@PathParam("inputString") String inputString) {
        LOG.debug("log: " + inputString);
        return "Hello [" + service.reverseEcho(inputString ) + "]";
    }

    /**
     * read configuration property and resturn it.
     *
     * http://localhost:8080/helloDemo/showMessage
     * @return message
     */
    @GET
    @Path("/showMessage")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloMicroProfileMessage() {
        return "Hello: " + message;
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloSimple2() {
        return "Hello helloDemo TEST2";
    }
}
