package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class HireDevelopersPage extends BasePage<HireDevelopersPage> {
    public static final String url = "/hire-developers";

    @Step("Open jobs page")
    public HireDevelopersPage openPage() {
        open(url);

        return this;
    }
}
