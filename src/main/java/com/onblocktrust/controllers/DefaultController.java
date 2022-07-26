package com.onblocktrust.controllers;

import com.onblocktrust.models.Product;
import com.onblocktrust.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class DefaultController {

    @Inject
    ProductService productService;

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "pong";
    }

    @GET
    @Path("/products")
    public List<Product> list() {
        return productService.list();
    }

}
