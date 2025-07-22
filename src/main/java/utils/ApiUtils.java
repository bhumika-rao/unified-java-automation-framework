package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    public static RequestSpecification getRequestSpec() {
        return RestAssured
                .given()
                .baseUri(ConfigReader.get("api.baseURI"))
                .header("Content-Type", "application/json")
                .header("x-api-key", ConfigReader.get("api.key"));
    }
}