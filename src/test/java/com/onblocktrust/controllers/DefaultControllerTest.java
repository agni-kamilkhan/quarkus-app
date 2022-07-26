package com.onblocktrust.controllers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DefaultControllerTest {

    @Test
    public void testPing() {
        given()
                .when().get("/ping")
                .then()
                .statusCode(200)
                .body(is("pong"));
    }

    @Test
    public void testList() {
        given()
                .when().get("/products")
                .then()
                .statusCode(200)
                .body("size()", is(0));
    }

}
