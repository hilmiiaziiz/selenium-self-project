package stepdef;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.*;

public class products {

    public int StatusCode;
    public RequestSpecification httpRequest;

    public Response response;

    public int responseCode;

    @Given("I hit the url of get the products")
    public void i_hit_the_url_of_get_the_products() {

        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
        responseCode =  response.statusCode();
        assertEquals(responseCode,"200");

    }



}
