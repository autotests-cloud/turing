package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContactUsPage extends BasePage<ContactUsPage> {

    public static final String URL = "/contact-us";

    @Step("Open contact us page")
    public ContactUsPage openPage() {
        open(URL);

        return this;
    }

    @Step("Send feedback")
    public ContactUsPage sendFeedback(String fullName, String email, String inquiry, String message) {
        $(byName("fullname")).setValue(fullName);
        $(byName("email")).setValue(email);
        $(byText("Select...")).click();
        $(byText(inquiry)).click();
        $(byName("message")).setValue(message);

        $("[type='submit']").click();

        return this;
    }

    @Step("Check message has been sent")
    public ContactUsPage checkMessageHasBeenSent() {
        $("[class^='Result_title']").shouldHave(text("We'll be in touch soon!"));
        $("[class^='Result_content']").shouldHave(
                text("Our team has received your message and we'll be reaching you out soon."));

        return this;
    }

    @Step("Click go to home button")
    public MainPage clickGoToHomeButton() {
        $(byText("Go to home")).click();

        return new MainPage();
    }

}
