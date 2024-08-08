package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static org.junit.Assert.*;

public class products {

    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;


    @Given("I hit the url of get the products")
    public void getTheProducts() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("^I pass the (.*) of products in the request")
    public void hitTheUrl(String endpoint) {
        httpRequest = RestAssured.given();
        response = httpRequest.get(endpoint);
    }

    @Then("^I receive the response code (.*)")
    public void getTheCode(int int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, int1);
    }
}
