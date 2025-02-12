package org.onboard.api.task3;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestUsers {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testGetUsers() {
        given()
                .when()
                .get("/users")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("size()", greaterThan(3))
                .body("name", hasItem("Ervin Howell"));
    }
}

