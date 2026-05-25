package stepdefinitions;

import base.BaseTest;
import endpoints.Routes;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import payloads.ObjectPayload;
import utilities.ExtentTestManager;

import static io.restassured.RestAssured.given;

public class UserSteps {

    Response response;
    ObjectPayload payload;
    ObjectPayload.Data payloaddata;

    @Given("Object endpoint is available")
    public void user_endpoint_is_available() {

        BaseTest.setup();
    }

    @When("User sends GET request")
    public void user_sends_get_request() {

        response =
                given()
                        .when()
                        .get(Routes.GET_OBJECTS);
    }

    @Then("User should get status code {int}")
    public void user_should_get_status_code(Integer statusCode) {

        response.then().statusCode(statusCode);
    }

    @Given("Create object payload")
    public void create_object_payload() {

        payload = new ObjectPayload();
        payloaddata = new ObjectPayload.Data();
        payloaddata.setCPUModel("CPU");
        payloaddata.setPrice(33.33);
        payloaddata.setYear(1993);
        payloaddata.setHardDiskSize("1 TB");
        payload.setName("John1");
        payload.setData(payloaddata);
    }

    @When("User sends POST request")
    public void user_sends_post_request() {

        response =
                given()
                        .header("Content-Type", "application/json")
                        .body(payload)
                        .when()
                        .post(Routes.CREATE_OBJECT);

        ExtentTestManager.getTest().info(
                "<b>RESPONSE</b><pre>" +
                        response.getBody().asPrettyString() +
                        "</pre>"
        );
    }
}