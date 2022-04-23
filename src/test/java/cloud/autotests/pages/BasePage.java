package cloud.autotests.pages;

import cloud.autotests.config.App;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@SuppressWarnings("unchecked")
public abstract class BasePage<T extends BasePage<?>> {

    private final SelenideElement header = $("header");

    @Step("Check header has button with text [{btnText}]")
    public T checkHeaderHasButton(String btnText) {
        header.$$("[class^='button_btn']").findBy(text(btnText)).shouldBe(visible);

        return (T) this;
    }

    @Step("In header click button with text [{btnText}]")
    public T headerClickButton(String btnText) {
        header.$$("[class^='button_btn']").findBy(text(btnText)).click();

        return (T) this;
    }

    @Step("Check url is [{url}]")
    public T checkUrl(String url) {
        webdriver().shouldHave(url(App.config.webUrl() + url));

        return (T) this;
    }

}
