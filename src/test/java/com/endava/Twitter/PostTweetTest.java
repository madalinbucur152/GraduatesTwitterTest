package com.endava.Twitter;
import com.endava.Twitter.util.EnvReader;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class PostTweetTest extends TestBaseClass {

    @Test
    public void shouldUpdateStatus() {

        String tweet  = faker.animal().name();

        given()
                .baseUri(EnvReader.getBaseuri())
                .basePath(EnvReader.getBasePath())
                .auth().oauth(EnvReader.getApiKey(), EnvReader.getApiSecret(),
                EnvReader.getAccessToken(), EnvReader.getAccessSecret())
                .contentType(ContentType.JSON)
                .queryParam("status", tweet)
                .log().all()
                .post("/statuses/update.json")
                .prettyPeek().then().statusCode(HttpStatus.SC_OK);

    }
}
