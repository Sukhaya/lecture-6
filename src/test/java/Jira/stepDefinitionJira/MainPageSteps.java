package stepDefinitionJira;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static PageElements.MainPageElements.projectsMenu;
import static PageElements.MainPageElements.testTESTProject;
import static PageElements.ProjectPageElements.projectSidebar;
import static PageElements.ProjectPageElements.projectTitle;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageSteps {
    private static final String PROJECT = "Test";

    @When("^Открываем список проектов$")
    public void openMenuOfProjects() {
        projectsMenu.shouldBe(visible).click();
    }

    @When("^Переходим в проект TestProject$")
    public void openTestProject() {
        testTESTProject.should(appear).click();
    }

    @When("^Получаем название текущего открытого проекта$")
    public  String getProjectTitle() {
        return projectTitle.shouldBe(exist).innerText();
    }

    @When("^Проверяем появилась ли боковая панель проекта$")
    public  boolean isProjectSidebarAppears() {
        return projectSidebar.is(appear);
    }

    @Then("^Проверяем, что находимся в нужном проекте$")
            public void checkCurrentProject() {
        assertTrue(isProjectSidebarAppears());
        assertEquals(PROJECT, getProjectTitle());
    }
}
