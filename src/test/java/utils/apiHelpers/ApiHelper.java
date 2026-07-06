package utils.apiHelpers;

import models.PublicLimits;

import static io.restassured.RestAssured.when;

public class ApiHelper {

    public PublicLimits getPublicLimits() {
        return when()
                .get("https://api.testedy.com/api/limits/public")
                .then()
                .statusCode(200)
                .extract().body().as(PublicLimits.class);
    }
}
