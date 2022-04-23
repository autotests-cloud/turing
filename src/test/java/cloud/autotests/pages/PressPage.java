package cloud.autotests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PressPage extends BasePage<PressPage> {

    public static final String URL = "/press";

    private final ElementsCollection newsItems = $$("[class^='NewsCard_root']");

    @Step("Open press page")
    public PressPage openPage() {
        open(URL);

        return this;
    }

    @Step("Check contact the PR team button has mail link")
    public PressPage checkContactButtonHasMailLink() {
        $(byText("Contact the PR team"))
                .shouldHave(href("mailto:press@turing.com"));

        return this;
    }

    @Step("Check news items should have size {expectedSize}")
    public PressPage checkNewsItemsShouldHaveSize(int expectedSize) {
        newsItems.shouldHave(size(expectedSize));

        return this;
    }

    @Step("Check news items should have valid structure")
    public PressPage checkNewsItemsShouldHaveValidStructure() {
        for (SelenideElement item : newsItems) {
            // Image
            item.find("img[alt='news']").shouldHave(attribute("src"));
            // Title
            item.find("h3").shouldBe(visible);
            // Description
            item.find("p").shouldBe(visible);
            // Read article button
            item.find(byText("Read article")).shouldBe(visible);
        }

        return this;
    }

}
