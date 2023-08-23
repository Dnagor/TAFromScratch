package softserve.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.awaitility.Awaitility.await;

public class MainPage {
    private final WebDriver driver;
    protected final WebDriverWait wait;
    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private final By searchInput = By.id("sb_form_q");
    private final By settingsAndQuickLinksButton = By.id("id_sc");
    private final By settingsLink = By.id("hbsettings");
    private final By moreSettingsLink = By.xpath("//a/div/div[contains(text(),'More')]");
    private final By chatButton = By.xpath("//a/div[contains(text(),'Chat')]");

    public MainPage waitForPageToLoad(){
        var js = (JavascriptExecutor) driver;
        await().atMost(Duration.ofSeconds(5))
                .until(() -> js.executeScript("return document.readyState;").equals("complete"));
        return this;
    }
    public WeatherSearchResultsPage weahtherSearchByCity(String city){
        Actions actions = new Actions(driver);
        var element = driver.findElement(searchInput);
        actions.sendKeys(element, city).sendKeys(element, Keys.ENTER).perform();
        //logs
        return new WeatherSearchResultsPage(driver);
    }
    public ChatPage clickChatButton(){
        driver.findElement(chatButton).click();
        //logs
        return new ChatPage(driver);
    }
    public MainPage clickSettingsAndQuickLinksButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsAndQuickLinksButton)).click();
        //logs
        return this;
    }
    public MainPage clickSettingsLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsLink)).click();
        //logs
        return this;
    }
    public SettingsPage clickMoreSettingsLink(){
        driver.findElement(moreSettingsLink).click();
        //logs
        return new SettingsPage(driver);
    }
}
