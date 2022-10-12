package stepDefinitionJira;

import cucumber.api.java.en.When;



import static PageElements.ProjectPageElements.menuButton;
import static PageElements.ProjectPageElements.softwareVersion;
import static PageElements.ProjectPageElements.taskStatus;
import static PageElements.ProjectPageElements.tasks;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ProjectSteps {
    private void openMenu(String menuTitle) {
        menuButton(menuTitle).shouldBe(visible).click();
    }

    @When("^Открываем страницу списка задач$")
    public void openIssuesPage() {
        openMenu("Список задач");
    }

    @When("^Переходим в задачу (.*)$")
    public static void openTask(String taskName) {
        tasks.filter(text(taskName)).shouldHave(sizeGreaterThan(0)).first().click();
    }

    @When("^Проверяем статус задачи и выводим привязку к версии$")
    public void checkStatusAndVersion() {
        String svText = softwareVersion.shouldBe(visible).getText();
        String taskStatusText = taskStatus.shouldBe(visible).getText();
        System.out.println("Software version: " + svText + "\nTask status: " + taskStatusText);
    }
}
