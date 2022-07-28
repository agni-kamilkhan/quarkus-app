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
    public void testProducts() {
        given()
                .when().get("/products")
                .then()
                .statusCode(200)
                .body("size()", is(0));
    }

    @Test
    public void testGuessHigher() {
        given()
                .when().get("/guess/10")
                .then()
                .statusCode(200)
                .body(is("It should be higher"));
    }

    @Test
    public void testGuessLower() {
        given()
                .when().get("/guess/20")
                .then()
                .statusCode(200)
                .body(is("It should be lower"));
    }

    @Test
    public void testGuessEqual() {
        given()
                .when().get("/guess/12")
                .then()
                .statusCode(200)
                .body(is("Congrats. Your guess is correct. It is 12"));
    }

}
