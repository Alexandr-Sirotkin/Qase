package tests;

import static utils.StringConstant.PROJECT_API_ENDPOINT;
import static utils.StringConstant.STATUS;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {

  @Test
  public void getProjectsTest() {
    new BaseAdapter().get(PROJECT_API_ENDPOINT);
  }

  @Test
  public void createProjectTest() {
    Project project = Project.builder()
                             .title("qa12onl17")
                             .code("qa12onl17")
                             .description("Test project")
                             .build();
    new ProjectsAdapter().create(project);
  }

  @Test
  public void createSuiteTest() {
    Suite suite = Suite.builder()
                       .title("Smoke tests")
                       .description("This is the smoke tests")
                       .preconditions("some preconditions")
                       .build();
    new SuiteAdapter().create("QA12ONL17", suite);
  }

  @Test
  public void createSuiteBaseTest() {
    Suite suite = Suite.builder()
        .title("Smoke tests2")
        .description("This is the smoke tests2")
        .preconditions("some preconditions")
        .build();
    boolean status = new SuiteAdapter().createBase("QA12ONL17", suite).path(STATUS);
    Assert.assertTrue(status);
  }

}
