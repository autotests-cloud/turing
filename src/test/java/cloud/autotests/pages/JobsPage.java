package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class JobsPage extends BasePage<JobsPage> {

    public static final String URL = "/jobs";

    @Step("Open jobs page")
    public JobsPage openPage() {
        open(URL);

        return this;
    }

}
