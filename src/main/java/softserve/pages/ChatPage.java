package softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage {
    private final WebDriver driver;
    private final By chatPageHeader = By.xpath("//h2[contains(text(),'Welcome to the new Bing')]");
    public ChatPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isChatPageLoaded(){
        //TODO shadow DOM?
        return driver.findElement(chatPageHeader).isDisplayed();
    }
}
