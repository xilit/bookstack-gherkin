package steps;

import com.github.javafaker.Faker;
import config.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import config.ConfigReader;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BooksSteps {
    Faker faker = new Faker();
    String title = faker.book().title();
    String description = faker.lorem().characters();

    @Given("User on a main page")
    public void user_on_a_main_page() {
        TestConfig.setup();
        open("/login");
        $("#email").shouldBe(visible);
        $("#email").setValue(ConfigReader.get("user.email"));
        $("#password").setValue(ConfigReader.get("user.password"));
        $(".button").click();
        $("#recently-viewed").shouldHave(text("Мои недавние просмотры"));
        $("#login-form").shouldNot(exist);
    }

    @When("User click on \"Books\"")
    public void user_click_on_books() {
        $("[data-shortcut='books_view']").click();
        $(".list-heading").shouldHave(text("Книги"));
    }

    @When("User clicks on \"Create book\" button")
    public void user_click_on_create_book_button() {
        $("a[href*='create-book']").click();
        $(".list-heading").shouldHave(text("Создать новую книгу"));
    }

    @When("User creates valid book without image")
    public void user_create_valid_book_without_image() {
        $("#name").setValue(title);
        $(".editor-content-area ").setValue(description).submit();
    }

    @When("User create valid book with image")
    public void user_create_valid_book_with_image() {
        $("#name").setValue(title);
        $(".editor-content-area ").setValue(description);
        $(byText("Обложка")).click();
        $(byText("Выбрать изображение")).click();
    }

    @When("User remove book")
    public void remove_book() {
        $("a[href*='delete']").click();
    }

    @Then("Book should be successfully created")
    public void verifyBookCreated() {
        $(".notification").shouldHave(text("Книга успешно создана"));
    }

}
