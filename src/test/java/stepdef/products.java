package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class products {

    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;

    public ResponseBody body;


    @Given("Hit the api url to get the value")
    public void getTheProducts() {

        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("^Go to endpoint (.*) when request the API$")
    public void hitTheUrl(String endpoint) {

        httpRequest = RestAssured.given();
        response = httpRequest.get(endpoint);
    }

    @Then("Verify the response code is (.*)$")
    public void getTheCode(int code) {

        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, code);
    }

    @Then("^verify value of the (.*) is equals with(.*)$")
    public void verifyTheParameterData(String path, String cat) {

        body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        String exptd = jsnpath.getJsonObject(path).toString();
        assertEquals(cat, exptd);
    }
}
