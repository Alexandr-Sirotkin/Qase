package adapters;

import static io.restassured.RestAssured.given;
import static utils.StringConstant.TOKEN_NAME;

import com.google.gson.Gson;
import io.restassured.response.Response;

public class BaseAdapter {

  private static final String TOKEN_VALUE = "";
  private static final String BASE_URL = "https://api.qase.io/v1";
  Gson converter = new Gson();

  public String get(String url) {
    return
         given()
                .header(TOKEN_NAME, TOKEN_VALUE)
        .when()
                .get(BASE_URL + url)
        .then()
                .log().all()
                .extract().body().asString();
  }

  public Response post(String url, String body) {
    return
        given()
               .header(TOKEN_NAME, TOKEN_VALUE)
               .header("Content-Type", "application/json")
               .body(body)
       .when()
               .post(BASE_URL + url)
       .then()
               .log().all()
               .extract().response();
  }



}
