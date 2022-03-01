package cloud.autotests.tests.api;

import cloud.autotests.config.App;
import cloud.autotests.helpers.AllureRestAssuredFilter;
import cloud.autotests.models.Credentials;
import cloud.autotests.tests.BaseTest;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Story("API login tests")
public class LoginTests extends BaseTest {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = App.config.selfServeApiUrl();
    }

    @Test
    @Tag("api")
    @DisplayName("Authorization with not existing account to self-serve")
    void notExistingAccountLoginTest() {
        Credentials credentials = new Credentials();
        credentials.setEmail("notExistingEmail@qa.guru");
        credentials.setPassword("r@ndomP@$$w0rd");

        given()
                .filter(AllureRestAssuredFilter.withCustomTemplates())
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post("/self-serve-user/login")
                .then()
                .assertThat()
                .statusCode(401)
                .body("message", equalTo("This account doesn’t exist. Please contact your Turing Account Executive for assistance"))
                .body("method", equalTo("POST"))
                .body("path", equalTo("/api/self-serve-user/login"))
                .body("statusCode", equalTo(401));
    }
}
