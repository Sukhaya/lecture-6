package Jira.stepDefinitionJira;

import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {
    @Before
    public void openUrl() {
        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
    }
    @After
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

    @AfterStep
    public void endStep(Scenario scenario) {
        if(scenario.isFailed()) {
            scenario.attach("Я УПАЛ", "text", "text");
        }
    }

}
