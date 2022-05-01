package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class DevelopersPage extends BasePage<DevelopersPage> {

    public static final String URL = "/hire-developers";

    @Step("Open developers page")
    public DevelopersPage openPage() {
        open(URL);

        return this;
    }

}
