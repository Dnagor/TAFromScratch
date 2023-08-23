package softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage {
    private final WebDriver driver;
    private final By mainShadowRoot = By.cssSelector("div .cib-serp-main");
    private final By actionBarShadowRoot = By.cssSelector("#cib-action-bar-main");
    private final By textInputShadowRoot = By.cssSelector("cib-text-input");
    private final By searchTextArea = By.cssSelector("[placeholder='Ask me anything...']");
    public ChatPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isChatPageLoaded(){
        return driver.findElement(mainShadowRoot).getShadowRoot()
                .findElement(actionBarShadowRoot).getShadowRoot()
                .findElement(textInputShadowRoot).getShadowRoot()
                .findElement(searchTextArea).isDisplayed();
    }
}
