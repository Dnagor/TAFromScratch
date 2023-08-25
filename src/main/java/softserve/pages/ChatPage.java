package softserve.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ChatPage {
    private final WebDriver driver;
    private final By mainShadowRoot = By.cssSelector("div .cib-serp-main");
    private final By actionBarShadowRoot = By.cssSelector("#cib-action-bar-main");
    private final By textInputShadowRoot = By.cssSelector("cib-text-input");
    private final By searchTextArea = By.cssSelector("[placeholder='Ask me anything...']");

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Chat page loaded")
    public boolean isChatPageLoaded() {
        var loaded = driver.findElement(mainShadowRoot).getShadowRoot().findElement(actionBarShadowRoot).getShadowRoot().findElement(textInputShadowRoot).getShadowRoot().findElement(searchTextArea).isDisplayed();
        log.info("Chat page was%s loaded".formatted(loaded ? "" : " not"));
        return loaded;
    }
}
