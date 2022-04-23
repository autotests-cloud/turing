package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage<MainPage> {

    public static final String URL = "/";

    @Step("Open main page")
    public MainPage openPage() {
        open(URL);

        return this;
    }
}
