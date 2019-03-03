/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.web;

/**
 *
 * @author meagangould
 */
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Main {

    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/")
                .port(8080)
                .build();

        ResourceConfig config = new ResourceConfig(ReportingResource.class);
        config.register(MultiPartFeature.class);

        JettyHttpContainerFactory.createServer(baseUri, config);
    }

}