package cloud.autotests.tests;

import cloud.autotests.pages.DevelopersPage;
import cloud.autotests.pages.JobsPage;
import cloud.autotests.pages.MainPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Basic UI elements tests")
public class BasicUITests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final JobsPage jobsPage = new JobsPage();
    private final DevelopersPage developersPage = new DevelopersPage();

    @Test
    @DisplayName("Apply for jobs on main page")
    void checkApplyForJobsBtnOnMainPageTest() {
        mainPage.openPage()
                .headerClickButton("Apply for jobs");
        jobsPage.checkUrl(JobsPage.URL);
    }

    @Test
    @DisplayName("Apply hire developers on main page")
    void checkApplyHireDevelopersOnMainPageTest() {
        mainPage.openPage()
                .headerClickButton("Hire Developers");
        developersPage.checkUrl(DevelopersPage.URL);
    }

}