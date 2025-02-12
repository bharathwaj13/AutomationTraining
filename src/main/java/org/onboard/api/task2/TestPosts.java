package org.onboard.api.task2;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;



import static io.restassured.RestAssured.*;

public class TestPosts {

    //private String baseUrl = "https://jsonplaceholder.typicode.com";

    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetSpecificPost() {
        String postId = "1";
        given()
                .basePath("/posts/")
                .log()
                .all()
                .when()
                .get(postId)
                .then()
                .statusCode(200)
                .body("id", is(Integer.parseInt(postId)))
                .body("title", notNullValue())
                .body("body", notNullValue())
                .body("userId", notNullValue());
    }

    @Test
    public void testUpdateSpecificPost() {
        String postId = "1";
        String updatedTitle = "Updated Post Title";
        String updatedBody = "Updated post body content.";

        String requestBody = "{\n" +
                "  \"id\": " + postId + ",\n" +
                "  \"title\": \"" + updatedTitle + "\",\n" +
                "  \"body\": \"" + updatedBody + "\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .basePath("/posts/")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .put( postId)
                .then()
                .statusCode(200)
                .body("id", is(Integer.parseInt(postId)))
                .body("title", is(updatedTitle))
                .body("body", is(updatedBody))
                .body("userId", is(1));
    }

    @Test
    public void testDeleteSpecificPost() {
        String postId = "1";
        given()
                .basePath("/posts/")
                .when()
                .delete(postId)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void testCreateNewPost() {
        String newTitle = "New Post Title";
        String newBody = "This is the body of the new post.";
        int newUserId = 1;

        String requestBody = "{\n" +
                "  \"title\": \"" + newTitle + "\",\n" +
                "  \"body\": \"" + newBody + "\",\n" +
                "  \"userId\": " + newUserId + "\n" +
                "}";

        given()
                .basePath("/posts/")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("title", is(newTitle))
                .body("body", is(newBody))
                .body("userId", is(newUserId));
    }
}
