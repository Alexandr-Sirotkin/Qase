package adapters;

import static utils.StringConstant.SUITE_API_ENDPOINT;

import io.restassured.response.ResponseBody;
import models.Suite;

public class SuiteAdapter extends BaseAdapter {

  public int create(String projectCode, Suite suite) {
    return post(String.format(SUITE_API_ENDPOINT, projectCode), converter.toJson(suite)).body().path("result.id");
  }

  public ResponseBody createBase(String projectCode, Suite suite) {
    return post(String.format(SUITE_API_ENDPOINT, projectCode), converter.toJson(suite)).body();
  }

}
