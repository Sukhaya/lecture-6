package stepDefinitionJira;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.codeborne.selenide.WebDriverRunner;


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
}
