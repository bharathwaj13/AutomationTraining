package org.onboard.api.task3;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 *
 * task - 2:(test data might be already present)
 * https://jsonplaceholder.typicode.com/users
 * GET call
 * Validate the below from API response:
 *
 * That the status code is equal to ‘200’
 * That there more than ‘3’ users in the list
 * That one of the users has a name of “Ervin Howell”
 */

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

