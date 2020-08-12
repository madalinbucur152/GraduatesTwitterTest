package com.endava.Twitter;

import com.endava.Twitter.util.EnvReader;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTweetById extends TestBaseClass{

    @Test
    public void shouldReturnATweetGivenAnId(){
        String tweet  = faker.animal().name();

        ValidatableResponse response = given()
                .baseUri(EnvReader.getBaseuri())
                .basePath(EnvReader.getBasePath())
                .auth().oauth(EnvReader.getApiKey(), EnvReader.getApiSecret(),
                EnvReader.getAccessToken(), EnvReader.getAccessSecret())
                .contentType(ContentType.JSON)
                .queryParam("status", tweet)
                .log().all()
                .post("/statuses/update.json")
                .prettyPeek().then().statusCode(HttpStatus.SC_OK);

        Long id = response.extract().jsonPath().getLong("id");

        given()
                .baseUri(EnvReader.getBaseuri())
                .basePath(EnvReader.getBasePath())
                .auth().oauth(EnvReader.getApiKey(), EnvReader.getApiSecret(),
                EnvReader.getAccessToken(), EnvReader.getAccessSecret())
                .queryParam("id", id)
                .log().all()
                .get("/statuses/show.json")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);


    }
}
