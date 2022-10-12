package Jira;

import Jira.PageElements.AuthorizationPageElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        AuthorizationPageElements.loginField.setValue("suhinina");
        AuthorizationPageElements.passwordField.setValue("Qwerty123");
        AuthorizationPageElements.loginButton.click();
        AuthorizationPageElements.loginField.shouldBe(Condition.disappear);
    }
}
