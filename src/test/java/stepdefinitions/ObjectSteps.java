package stepdefinitions;

import base.BaseTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.Routes;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloads.ObjectPayload;
import utilities.ExtentTestManager;

import static io.restassured.RestAssured.given;

public class ObjectSteps {

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
        ExtentCucumberAdapter.addTestStepLog(
                "<b>HEADERS</b><pre>" +
                        response.getHeaders() +
                        "</pre>" +
                        "<b>RESPONSE</b><pre>" +
                        response.getBody().asPrettyString() +
                        "</pre>"

        );
    }

    @Then("User should get status code {int}")
    public void user_should_get_status_code(Integer statusCode) {

        response.then().statusCode(statusCode);
    }

    @Given("Create object payload")
    public void create_object_payload() throws JsonProcessingException {

        payload = new ObjectPayload();
        payloaddata = new ObjectPayload.Data();
        payloaddata.setCPUModel("CPU");
        payloaddata.setPrice(33.33);
        payloaddata.setYear(1993);
        payloaddata.setHardDiskSize("1 TB");
        payload.setName("John1");
        payload.setData(payloaddata);

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(payload);
        ExtentCucumberAdapter.addTestStepLog(
                "<b>Payload</b><pre>" +
                        jsonString +
                        "</pre>"

        );
    }

    @When("User sends POST request")
    public void user_sends_post_request() {

        response =
                given()
                        .header("Content-Type", "application/json")
                        .body(payload)
                        .when()
                        .post(Routes.CREATE_OBJECT);

        ExtentCucumberAdapter.addTestStepLog(
                "<b>HEADERS</b><pre>" +
                        response.getHeaders() +
                        "</pre>" +
                        "<b>RESPONSE</b><pre>" +
                        response.getBody().asPrettyString() +
                        "</pre>"

        );

        ExtentTestManager.getTest().info(
                "<b>RESPONSE</b><pre>" +
                        response.getBody().asPrettyString() +
                        "</pre>"
        );
    }

    @When("User sends GET request By Id {int}")
    public void userSendsGETRequestById(int arg0) {

        response =
                given()
                        .when()
                        .get(Routes.GET_OBJECTById + "/" + arg0);

        ExtentCucumberAdapter.addTestStepLog(
                "<b>HEADERS</b><pre>" +
                        response.getHeaders() +
                        "</pre>" +
                        "<b>RESPONSE</b><pre>" +
                        response.getBody().asPrettyString() +
                        "</pre>"

        );
    }


    @When("User sends PUT request by id {int}")
    public void userSendsPUTRequestById(int arg0) {
        response =
                given()
                        .header("Content-Type", "application/json")
                        .body(payload)
                        .when()
                        .put(Routes.PUT_Object + "/" + arg0);


    }
}