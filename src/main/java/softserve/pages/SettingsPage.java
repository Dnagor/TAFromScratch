package softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
    private final WebDriver driver;
    private final By searchSection = By.id("search-section-content");
    public SettingsPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isSettingsPageLoaded(){
        return driver.findElement(searchSection).isDisplayed();
    }
}
