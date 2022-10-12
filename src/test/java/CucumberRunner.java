
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "html:target/cucumber-html-reports",
        "json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"Hook","Jira.stepDefinitionJira","RickAndMorty"}
)
public class CucumberRunner {
//
//    @BeforeAll
//    public static void before () {
//        SelenideLogger.addListener("AllureSelenide",
//                new AllureSelenide().screenshots(true)
//                        .savePageSource(false));
//        RestAssured.filters(new AllureRestAssured());
    }

