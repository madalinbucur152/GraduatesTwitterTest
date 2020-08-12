package com.endava.Twitter;

import com.endava.Twitter.util.EnvReader;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTweetByUrl extends TestBaseClass{

    @Test
    public void shouldReturnATweetGivenAnUrl(){

        String url = "https://twitter.com/j3r3my84/status/1293482536899883010";

        given()
                .baseUri(EnvReader.getPublishUri())
                .basePath(EnvReader.getPublishPath())
                .auth().oauth(EnvReader.getApiKey(), EnvReader.getApiSecret(),
                EnvReader.getAccessToken(), EnvReader.getAccessSecret())
                .queryParam("url",url)
                .log().all()
                .get()
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);
    }
}
