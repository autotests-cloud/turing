package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class JobsPage extends BasePage<JobsPage> {
    public static final String url = "/jobs";

    @Step("Open jobs page")
    public JobsPage openPage() {
        open(url);

        return this;
    }

}
