package apiTests;

import org.testng.annotations.Test;
import utils.ApiUtils;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthApiTests {

    //Test to check if we are able to register a user successfully and validate the ID and token
    @Test
    public void registerSuccessful() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().post("/api/register")
                .then().statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    //Test to check if we are unable to register a user due to an error - Missing password
    @Test
    public void registerUnsuccessful() {
        String body = "{ \"email\": \"sydney@fife\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().post("/api/register")
                .then().statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    //Test to check if we are able to login successfully with valid credentials
    @Test
    public void loginSuccessful() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().post("/api/login")
                .then().statusCode(200)
                .body("token", notNullValue());
    }

    //Test to check if we are unable to login successfully due to missing password
    @Test
    public void loginUnsuccessful() {
        String body = "{ \"email\": \"peter@klaven\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().post("/api/login")
                .then().statusCode(400)
                .body("error", equalTo("Missing password"));
    }
}

