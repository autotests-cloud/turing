package cloud.autotests.tests;

import cloud.autotests.pages.PressPage;
import io.qameta.allure.AllureId;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Press tests")
public class PressTest extends BaseTest {

    private final PressPage pressPage = new PressPage();

    @Test
    @AllureId("9679")
    @DisplayName("Contact the PR team button has mail link")
    void contactButtonHasMailLinkTest() {
        pressPage.openPage()
                .checkContactButtonHasMailLink();
    }

    @Test
    @AllureId("9680")
    @DisplayName("News items: validate size and structure")
    void validateNewsTest() {
        int expectedSize = 6;

        pressPage.openPage()
                .checkNewsItemsShouldHaveSize(expectedSize)
                .checkNewsItemsShouldHaveValidStructure();
    }

}
