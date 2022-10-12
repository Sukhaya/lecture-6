package stepDefinitionJira;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static PageElements.CreateTaskPageElements.createIssueSubmitButton;
import static PageElements.CreateTaskPageElements.issueDescriptionInput;
import static PageElements.CreateTaskPageElements.issueDescriptionTogglerToText;
import static PageElements.CreateTaskPageElements.issueSummaryInput;
import static PageElements.CreateTaskPageElements.issueTypeDropdown;
import static PageElements.MainPageElements.createTaskButton;
import static PageElements.MainPageElements.messageSuccess;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class CreateTaskSteps {
    @When("^Переходим к созданию задачи$")
    public void openCreateTask() {
        createTaskButton.shouldBe(visible).click();
    }

    @When("^Установим для задачи тип (.*)$")
    public void setType(String type) {
        issueTypeDropdown.shouldBe(visible).setValue(type).pressEnter();
    }

    @When("^Установим для задачи тему (.*)$")
    public void setSummary(String theme) {
        issueSummaryInput.shouldBe(visible).setValue(theme);
    }

    @When("^Установим для задачи описание(.*)$")
    public void setDescription(String description) {
        issueDescriptionTogglerToText.shouldBe(exist).click();
        issueDescriptionInput.shouldBe(exist).sendKeys(description);
    }

    @When("^Подтверждаем создание задачи$")
    public void clickAccept() {
        createIssueSubmitButton.shouldBe(visible).click();
    }

    @Then("^Получаем текст сообщения об успешном создании таски$")
    public  String getSuccessMessageText() {
        return messageSuccess.shouldBe(appear).getText();
    }
}

