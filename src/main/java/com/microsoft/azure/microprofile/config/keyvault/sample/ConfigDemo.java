package com.microsoft.azure.microprofile.config.keyvault.sample;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_HTML;

@ApplicationScoped
@Path("/")
public class ConfigDemo {

    @Inject
    org.eclipse.microprofile.config.Config config;

    @Inject
    @ConfigProperty(name = "demo-key", defaultValue = "Unknown")
    String demoKeyValue;

    @GET
    @Path("config")
    @Produces(TEXT_HTML)
    public String info() {
        return "Welcome to the server! I know that the value for the key 'demo-key' is: '" + demoKeyValue
                + "'<br/><br/>"
                + "By the way, I can also look it up in a non-DI fashion: '" + config.getValue("demo-key", String.class) + "'";
    }
}
