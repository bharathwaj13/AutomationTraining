package org.onboard.api.task3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 *
 * Create a PET using the POST call from http://petstore.swagger.io/#/
 *
 * Request Body:
 * {
 *   "id": 12345,
 *   "category": {
 *     "id": 1,
 *     "name": "dog"
 *   },
 *   "name": "snoopie",
 *   "photoUrls": [
 *     "string"
 *   ],
 *   "tags": [
 *     {
 *       "id": 0,
 *       "name": "string"
 *     }
 *   ],
 *   "status": "pending"
 * }
 *
 * once the pet is created write the test cases using REST assured for the below calls
 *
 * https://petstore.swagger.io/v2/pet/12345
 * GET call
 * Validate the below from API response:
 *
 * That the status code is equal to ‘200’
 * That the content type is ‘application/json’
 * That if the pet is a ‘dog’
 * That its name is ‘snoopie’
 * That its current status is ‘pending’
 */

public class TestPet {

    private static int id=12345;
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testCreatePet() {
        String requestBody = "{\n" +
                "  \"id\": "+id+ ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"dog\"\n" +
                "  },\n" +
                "  \"name\": \"snoopie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"pending\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .log()
                .body()
                .statusCode(200)
                .contentType("application/json")
                .extract().response();


        given()
                .when()
                .get("/pet/" + id)
                .then()
                .log()
                .body()
                .statusCode(200)
                .contentType("application/json")
                .body("name", equalTo("snoopie"))
                .body("status", equalTo("pending"))
                .body("category.name", equalTo("dog"));
    }
}
