package org.onboard.api.task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

/**
 *
 * openweathermap.org exposes APIs for reading the weather data from various cities. The documentation is at https://openweathermap.org/guide#how
 *
 * 1. Use the below weather end-point to get the current weather details of Hyderabad
 * 	http://api.openweathermap.org/data/2.5/weather?q=hyderabad&appid={your_key}
 *
 * 2. Use the coordinates (longitude and latitude) of of the above response to the end-point
 * http://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid={your_key} and verify the below in response
 * 	- name --> Hyderabad
 * 	- sys.country --> IN
 * 	- main.temp_min --> greater than 0
 * 	- main.temp --> greater than 0
 *
 * Hint:
 * - You need to register in the application and get your API key as mentioned here in your API requests
 */

public class TestOpenWeather {

    //0ced65cee0e63aa7392454af54e6b417

    @Before
    public void setup(){
        RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
    }

    @Test
    public void testWeather(){
        Response response = RestAssured.given()
                .queryParam("q", "chennai")
                .queryParam("appid", "0ced65cee0e63aa7392454af54e6b417")
                .when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
        String longitude = response.jsonPath().getString("coord.lon");
        String latitude = response.jsonPath().getString("coord.lat");
        System.out.println(longitude+" : "+latitude);

        Response response1 = RestAssured.given()
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("appid", "0ced65cee0e63aa7392454af54e6b417")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200)
                .contentType("application/json")
                .body("name", equalTo("Chennai"))
                .body("sys.country", equalTo("IN"))
                .extract()
                .response();

        double minTemp = response1.jsonPath().getDouble("main.temp_min");
        double maxTemp = response1.jsonPath().getDouble("main.temp_max");

        Assert.assertTrue(minTemp>0);
        Assert.assertTrue(maxTemp>0);

    }

}
