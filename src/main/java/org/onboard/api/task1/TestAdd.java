package org.onboard.api.task1;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;


/**
 * Use the below webservice to perform the Webservice testing
 * http://www.dneonline.com/calculator.asmx
 *
 * The webservice exposes 4 methods. Test all the 4 methods with different combinations.
 * Testing of each method gets 2 mark. There are some defects in the application.
 * You need to find as many defects as possible.
 *
 */
public class TestAdd {

    private String baseUrl;

    @Before
    public void setUp() {
        baseUrl = "http://www.dneonline.com/calculator.asmx";
    }

    @Test
    public void testAddMethod() {
        String requestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <Add xmlns=\"http://tempuri.org/\">\n" +
                "      <intA>5</intA>\n" +
                "      <intB>3</intB>\n" +
                "    </Add>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

        Response response = given()
                .log()
                .all()
                .header("Content-Type", "text/xml;charset=UTF-8")
                .body(requestBody)
                .when()
                .post(baseUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        String result = response.body().xmlPath().getString("//*[local-name()='AddResult']");
        Assert.assertEquals("8", result);

    }
}
