package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@DisplayName("Wikipedia android app tests")
public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Wikipedia search test")
    void searchTest() {

        step("Skip onboarding", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("BrowserStack");
        });

        step("Verify search content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }


    @Test
    @DisplayName("Open article test")
    void openArticleTest() {

        step("Skip onboarding", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("JUnit");
        });

        step("Verify search content found", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/search_results_list")).shouldHave(
                    CollectionCondition.sizeGreaterThan(0));
        });

        step("Open article", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });
    }

    @Test
    @DisplayName("Wikipedia onboarding screen test")
    void onboardingScreenTest() {

        step("Check texts on first screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia " +
                    "…in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("We’ve found the " +
                    "following on your device:"));
        });

        step("Click on 'continue' button", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Check texts on second screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Dive down the " +
                    "Wikipedia rabbit hole"));
        });

        step("Click on 'continue' button", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Check texts on third screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists " +
                    "with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Join Wikipedia"));
        });

        step("Click on 'continue' button", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Check texts on fourth screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Help make " +
                    "the app better"));
        });
    }
}
