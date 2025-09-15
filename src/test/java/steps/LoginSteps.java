package steps;

import config.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import config.ConfigReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginSteps {

    @Given("User on the login page")
    public void user_am_on_the_login_page() {
        TestConfig.setup();
        open("/login");
        $("#email").shouldBe(visible);
    }

    @When("User enter valid admin credentials")
    public void user_enter_valid_admin_credentials() {
        $("#email").setValue(ConfigReader.get("user.email"));
        $("#password").setValue(ConfigReader.get("user.password"));
    }

    @When("User click login button")
    public void user_click_login_button() {
        $(".button").click();
    }

    @When("User click on check-box")
    public void user_clock_on_checkbox() {
        $(".toggle-switch").click();
        $("span[role='checkbox']").shouldHave(attribute("area-checked", "true"));
    }

    @Then("User should be redirected to dashboard")
    public void user_should_be_redirected_to_dashboard() {
        $("#recently-viewed").shouldHave(text("Мои недавние просмотры"));
        $("#login-form").shouldNot(exist);
    }

    @When("User input email")
    public void user_input_email() {
        $("#email").setValue(ConfigReader.get("user.email"));
    }

    @Then("User see error about empty password")
    public void user_see_error_about_empty_password() {
        $("div.text-neg").shouldHave(text("pasdfsword обязательное поле"));
    }


}