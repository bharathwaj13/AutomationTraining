package org.onboard.api.task2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class TestNumberOfResources {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testNumberOfResources() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()", is(100));


        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/comments")
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()", is(500));

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/albums")
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()", is(100));

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/photos")
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()", is(5000));

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/todos")
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()", is(200));

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()", is(10));
    }
}
