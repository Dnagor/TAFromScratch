package softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private final By searchInput = By.id("sb_form_q");
    private final By settingsAndQuickLinksButton = By.id("id_sc");
    private final By settingsLink = By.id("hbsettings");
    private final By moreSettingsLink = By.xpath("//a/div/div[contains(text(),'More')]");
    private final By chatButton = By.xpath("//a/div[contains(text(),'Chat')]");

    public WeatherSearchResultsPage weahtherSearchByCity(String city){
        driver.findElement(searchInput).sendKeys(city);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        //logs
        return new WeatherSearchResultsPage(driver);
    }
    public ChatPage clickChatButton(){
        driver.findElement(chatButton).click();
        //logs
        return new ChatPage(driver);
    }
    public MainPage clickSettingsAndQuickLinksButton(){
        driver.findElement(settingsAndQuickLinksButton).click();
        //logs
        return this;
    }
    public MainPage clickSettingsLink(){
        driver.findElement(settingsLink).click();
        //logs
        return this;
    }
    public SettingsPage clickMoreSettingsLink(){
        driver.findElement(moreSettingsLink).click();
        //logs
        return new SettingsPage(driver);
    }
}
