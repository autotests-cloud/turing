package cloud.autotests.tests;

import cloud.autotests.pages.BlogPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Blog")
@Story("Blog tests")
public class BlogTest extends BaseTest {

    private final BlogPage blogPage = new BlogPage();

    @Test
    @DisplayName("Search content on blog page")
    void searchContentTest() {
        String searchContent = "Metric";
        int expectedSize = 5;

        blogPage.openPage()
                .search(searchContent)
                .checkSearchResultsGreaterThan(expectedSize);
    }

    @Test
    @DisplayName("Subscribe to newsletter")
    void subscribeToNewsletterTest() {
        String name = "Alexander";
        String email = "sashkir7@mail.ru";

        blogPage.openPage()
                .subscribeToNewsletter(name, email)
                .checkSubscriptionIsActivated();
    }

}
