package adapters;

import static utils.StringConstant.PROJECT_API_ENDPOINT;

import models.Project;

public class ProjectsAdapter extends BaseAdapter {

  public String create(Project project) {
    return post(PROJECT_API_ENDPOINT, converter.toJson(project)).body().path("result.code");
  }

}
