package cloud.autotests.tests;

import cloud.autotests.pages.PressPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Press")
@Story("Press tests")
public class PressTest extends BaseTest {

    private final PressPage pressPage = new PressPage();

    @Test
    @DisplayName("Contact the PR team button has mail link")
    void contactButtonHasMailLinkTest() {
        pressPage.openPage()
                .checkContactButtonHasMailLink();
    }

    @Test
    @DisplayName("News items: validate size and structure")
    void validateNewsTest() {
        int expectedSize = 6;

        pressPage.openPage()
                .checkNewsItemsShouldHaveSize(expectedSize)
                .checkNewsItemsShouldHaveValidStructure();
    }

}
