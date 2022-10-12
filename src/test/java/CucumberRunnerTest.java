
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "html:target/cucumber-html-reports",
        "json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"Hook",
                "Jira.StepDefinition_Jira",
                "StepDefinition_RickAndMorty",
                "StepDefinition_reqRes"}
)
public class CucumberRunnerTest {
}

