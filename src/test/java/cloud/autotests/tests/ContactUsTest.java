package cloud.autotests.tests;

import cloud.autotests.pages.ContactUsPage;
import cloud.autotests.pages.MainPage;
import io.qameta.allure.AllureId;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Contact us tests")
public class ContactUsTest extends BaseTest {

    private final ContactUsPage contactUsPage = new ContactUsPage();

    @Test
    @AllureId("9681")
    @DisplayName("Send feedback")
    void sendFeedbackTest() {
        String fullName = "Alexander Pi";
        String email = "sashkir7@mail.ru";
        String inquiry = "Investors";
        String message = "Good day! Can I buy your car?";

        contactUsPage.openPage()
                .sendFeedback(fullName, email, inquiry, message)
                .checkMessageHasBeenSent()
                .clickGoToHomeButton()
                .checkUrl(MainPage.URL);
    }

}
