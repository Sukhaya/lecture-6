package stepDefinitionJira;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static PageElements.ProjectPageElements.taskLink;
import static PageElements.TaskPageElements.closeNotificationButton;
import static PageElements.TaskPageElements.inProgressButton;
import static PageElements.TaskPageElements.notificationPopup;
import static PageElements.TaskPageElements.resolvedButton;
import static PageElements.TaskPageElements.statusField;
import static PageElements.TaskPageElements.toDoButton;
import static PageElements.TaskPageElements.workFlowButton;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class TaskSteps {
    @When("^Открываем страницу текущей задачи$")
    public void openTaskPage() {
        taskLink.shouldBe(visible).click();
    }

    @When("Меняем статус задачи - Нужно сделать")
    public void changeStatusTodo() {
        toDoButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @When("Меняем статус задачи - В работе")
    public void changeStatusInProgress() {
        inProgressButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @When("Меняем статус задачи - Выполнено")
    public void changeStatusResolved() {
        workFlowButton.shouldBe(visible).click();
        resolvedButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @Then("Проверяем смену статуса (.*)")
    public void checkTaskStatus(String taskStatus) {
        statusField.shouldHave(text(taskStatus));
    }

}
