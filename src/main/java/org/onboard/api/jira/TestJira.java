package org.onboard.api.jira;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.util.Base64;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJira {

    // ATATT3xFfGF0UNLRS-vQnGXP89WukvhlFNosFd2mAwmYqUx2ci-4O3d38O_sv4dW-v4X2GTSfYiWYlC4s8WjENqdboUweXPNq_s4OLHJEXVwm1gn02hymrw_8lbyzOoH8ddO0u-5F464AwOOsf-q0WGIaKNXWbouU6_2_mvEs22aFfyE99JlC58=BED8C6E3



    private String jiraUrl = "https://epamtest.atlassian.net";
    private static String username = "iambharathwaj@gmail.com";
    private static String apiToken = "ATATT3xFfGF0UNLRS-vQnGXP89WukvhlFNosFd2mAwmYqUx2ci-4O3d38O_sv4dW-v4X2GTSfYiWYlC4s8WjENqdboUweXPNq_s4OLHJEXVwm1gn02hymrw_8lbyzOoH8ddO0u-5F464AwOOsf-q0WGIaKNXWbouU6_2_mvEs22aFfyE99JlC58=BED8C6E3";

    private static String issueKey;


    @Before
    public void setUp() {
        RestAssured.baseURI = jiraUrl;

    }

    private String getEncodedAuth() {
        String auth = username + ":" + apiToken;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

    @Test
    public void test_01_CreateDefect() {

        String jsonBody = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"key\": \"MFLP\"\n" +
                "    },\n" +
                "    \"summary\": \"Test Defect created via API\",\n" +
                "    \"description\": \"This is a test defect created via Rest Assured API\",\n" +
                "    \"issuetype\": {\n" +
                "      \"name\": \"Bug\"\n" +
                "    }\n" +
                "  }\n" +
                "}";


        Response response = given()
                .header("Authorization", "Basic " + getEncodedAuth())
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .log()
                .all()
                .when()
                .post("/rest/api/latest/issue")
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract().response();


        issueKey = response.jsonPath().getString("key");
        System.out.println("Created Defect with Key: " + issueKey);
    }


    @Test
    public void test_02_UpdateDefect() {
        String jsonBody = "{\n" +
                "  \"fields\": {\n" +
                "    \"summary\": \"Updated Defect Summary via API\",\n" +
                "    \"description\": \"Updated defect description via Rest Assured\"\n" +
                "  }\n" +
                "}";


        given()
                .header("Authorization", "Basic " + getEncodedAuth())
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .log()
                .all()
                .when()
                .put("/rest/api/latest/issue/" + issueKey)
                .then()
                .log()
                .all()
                .statusCode(204);
    }


    @Test
    public void test_03_SearchDefect() {

        given()
                .header("Authorization", "Basic " + getEncodedAuth())
                .contentType(ContentType.JSON)
                .get("/rest/api/latest/issue/" + issueKey)
                .then()
                .statusCode(200)
                .body("key", equalTo(issueKey))
                .body("fields.summary", containsString("Updated Defect Summary"));
    }

    @Test
    public void test_04_AddAttachment() {
        String filePath = "src/main/java/org/onboard/api/jira/bugscreenshot.png";

        given()
                .header("Authorization", "Basic " + getEncodedAuth())
                .header("X-Atlassian-Token","no-check")
                .multiPart("file", new File(filePath))
                .log()
                .all()
                .when()
                //.post("/rest/api/latest/issue/" + issueKey + "/attachments")
                .post("/rest/api/latest/issue/MLFP-15/attachments")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void test_05_DeleteDefect() {
        given()
                .header("Authorization", "Basic " + getEncodedAuth())
                .contentType(ContentType.JSON)
                .when()
                .delete("/rest/api/latest/issue/" + issueKey)
                .then()
                .statusCode(204);
    }
}
