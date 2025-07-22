package apiTests;

import org.testng.annotations.Test;
import utils.ApiUtils;

import static org.hamcrest.Matchers.*;

public class UserApiTests {

    //Test to validate retrieving a list of users
    @Test
    public void listUsers() {
        ApiUtils.getRequestSpec()
                .when().get("/api/users?page=2")
                .then().statusCode(200)
                .body("data", not(empty()));
    }

    //Test to validate the ID of a particular user is equal to given value
    @Test
    public void getSingleUser() {
        ApiUtils.getRequestSpec()
                .when().get("/api/users/2")
                .then().statusCode(200)
                .body("data.id", equalTo(2));
    }

    //Test to validate that a non-existent user returns 404 Not Found
    @Test
    public void getUserNotFound() {
        ApiUtils.getRequestSpec()
                .when().get("/api/users/23")
                .then().statusCode(404);
    }

    //Test to validate delayed response still returns valid user data
    @Test
    public void delayedResponseTest() {
        ApiUtils.getRequestSpec()
                .when().get("/api/users?delay=3")
                .then().statusCode(200)
                .body("data", not(empty()));
    }
}
