package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class BlogPage extends BasePage<BlogPage> {

    public static final String URL = "/blog";

    private final SelenideElement subscribeNewsletterElement = $("#newsletter-container");

    @Step("Open blog page")
    public BlogPage openPage() {
        open(URL);

        return this;
    }

    @Step("Search in blog by value {content}")
    public BlogPage search(String content) {
        $("[type='search']").setValue(content)
                .pressEnter();

        return this;
    }

    @Step("Check search result items greater than size {expectedSize}")
    public BlogPage checkSearchResultsGreaterThan(int expectedSize) {
        $("div.search-results").shouldHave(text("Search results"));
        $$("article.post").shouldBe(sizeGreaterThan(expectedSize));

        return this;
    }

    @Step("Subscribe to the Turing Newsletter")
    public BlogPage subscribeToNewsletter(String name, String email) {
        subscribeNewsletterElement.find(byName("name")).setValue(name);
        subscribeNewsletterElement.find(byName("email")).setValue(email);
        subscribeNewsletterElement.find("[value='looking-to-hire']").click();
        subscribeNewsletterElement.find("[value='Subscribe']").click();

        return this;
    }

    @Step("Check subscription is activated")
    public BlogPage checkSubscriptionIsActivated() {
        subscribeNewsletterElement.shouldHave(text("Your form has been successfully submitted."));

        return this;
    }

}
