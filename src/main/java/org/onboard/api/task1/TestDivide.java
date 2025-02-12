package org.onboard.api.task1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDivide {

    private String baseUrl;

    @Before
    public void setUp(){
        baseUrl="http://www.dneonline.com/calculator.asmx";
    }

    @Test
    public void testDivide(){
        String request="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <Divide xmlns=\"http://tempuri.org/\">\n" +
                "      <intA>3</intA>\n" +
                "      <intB>2</intB>\n" +
                "    </Divide>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

        Response response = RestAssured.given()
                .log()
                .all()
                .contentType("text/xml;charset=UTF-8")
                .body(request)
                .when()
                .post(baseUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .extract()
                .response();

        String result = response.xmlPath().getString("//*[local-name()='SubtractResult'");
        Assert.assertEquals("1",result);
    }

}
