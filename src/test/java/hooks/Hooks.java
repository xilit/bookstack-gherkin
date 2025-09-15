package hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;


import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void setUpAllure() {
        if (!SelenideLogger.hasListener("AllureSelenide")) {
            SelenideLogger.addListener("AllureSelenide",
                    new AllureSelenide()
                            .screenshots(true)
                            .savePageSource(false)
            );
        }
    }
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finished scenario: " + scenario.getName() +
                " Status: " + scenario.getStatus());

        // Закрываем браузер после каждого сценария
        Selenide.closeWebDriver();

    }
}