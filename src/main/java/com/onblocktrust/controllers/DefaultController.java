package com.onblocktrust.controllers;

import com.onblocktrust.models.Product;
import com.onblocktrust.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    int guessNumber = 12;

    @GET
    @Path("/guess/{q}")
    @Produces(MediaType.TEXT_PLAIN)
    public String guess(@PathParam("q") Integer q) {
        StringBuilder sb = new StringBuilder();
        if(q > guessNumber) {
            sb.append("It should be lower");
        } else if(q < guessNumber){
            sb.append("It should be higher");
        } else {
            sb.append("Congrats. Your guess is correct. It is ").append(guessNumber);
        }
        return sb.toString();
    }

}
