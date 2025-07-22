package apiTests;

import org.testng.annotations.Test;
import utils.ApiUtils;

import static org.hamcrest.Matchers.equalTo;

public class CRUDApiTests {

    //Test to validate creation of user
    @Test
    public void createUser() {
        String body = "{ \"name\": \"Bhumika\", \"job\": \"QA\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().post("/api/users")
                .then().statusCode(201)
                .body("name", equalTo("Bhumika"));
    }

    //Test to validate updating all fields of a user
    @Test
    public void updateUserPut() {
        String body = "{ \"name\": \"Bhumika\", \"job\": \"Senior QA\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().put("/api/users/2")
                .then().statusCode(200)
                .body("job", equalTo("Senior QA"));
    }

    //Test to validate updating partial fields of a user
    @Test
    public void updateUserPatch() {
        String body = "{ \"job\": \"Lead QA\" }";

        ApiUtils.getRequestSpec()
                .body(body)
                .when().patch("/api/users/2")
                .then().statusCode(200)
                .body("job", equalTo("Lead QA"));
    }

    //Test to validate deletion of a user
    @Test
    public void deleteUser() {
        ApiUtils.getRequestSpec()
                .when().delete("/api/users/2")
                .then().statusCode(204);
    }
}
