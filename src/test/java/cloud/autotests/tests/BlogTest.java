package cloud.autotests.tests;

import cloud.autotests.pages.BlogPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Blog tests")
public class BlogTest extends BaseTest {

    private final BlogPage blogPage = new BlogPage();

    @Test
    @DisplayName("Search content on blog page")
    void searchContentTest() {
        blogPage.openPage()
                .search("Metric")
                .checkSearchResultsGreaterThan(5);
    }

    @Test
    @DisplayName("Subscribe to newsletter")
    void subscribeToNewsletterTest() {
        blogPage.openPage()
                .subscribeToNewsletter("Alexander", "sashkir7@mail.ru", true)
                .checkSubscriptionIsActivated();
    }

}
