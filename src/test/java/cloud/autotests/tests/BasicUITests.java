package cloud.autotests.tests;

import cloud.autotests.pages.JobsPage;
import cloud.autotests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Basic UI elements tests")
public class BasicUITests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final JobsPage jobsPage = new JobsPage();

    @Test
    @Description("Check that main page has login button")
    @DisplayName("Main page has login button")
    void mainPageHasLoginButtonTest() {
        mainPage.openPage()
                .checkHeaderHasButton("Login");
    }

    @Test
    @DisplayName("Apply for jobs on main page")
    void checkApplyForJobsBtnOnMainPageTest() {
        mainPage.openPage()
                .headerClickButton("Apply for jobs");
        jobsPage.checkUrl(JobsPage.URL);
    }

}