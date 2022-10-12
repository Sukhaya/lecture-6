package Hook;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class Hooks extends Configuration {
    @Before
    public void openUrl() {
        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
    }
    @After
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}
