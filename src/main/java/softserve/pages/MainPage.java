package softserve.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class MainPage {
    protected final WebDriverWait wait;
    private final WebDriver driver;
    private final By searchInput = By.id("sb_form_q");
    private final By settingsAndQuickLinksButton = By.id("id_sc");
    private final By settingsLink = By.id("hbsettings");
    private final By moreSettingsLink = By.xpath("//a/div/div[contains(text(),'More')]");
    private final By chatButton = By.xpath("//a/div[contains(text(),'Chat')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Main page loaded")
    public MainPage waitForPageToLoad() {
        driver.findElement(By.cssSelector(("circle.hp")));
        log.info("Main page loaded.");
        return this;
    }

    @Step("Search for {city}")
    public WeatherSearchResultsPage weahtherSearchByCity(String city) {
        Actions actions = new Actions(driver);
        var element = driver.findElement(searchInput);
        actions.sendKeys(element, city).sendKeys(element, Keys.ENTER).perform();
        log.info("Searching for: " + city);
        return new WeatherSearchResultsPage(driver);
    }

    @Step("Click chat button")
    public ChatPage clickChatButton() {
        driver.findElement(chatButton).click();
        log.info("Clicked Chat button");
        return new ChatPage(driver);
    }

    @Step("Click settings and quick links button")
    public MainPage clickSettingsAndQuickLinksButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsAndQuickLinksButton)).click();
        log.info("Clicked Settings and Quick links button");
        try {
            driver.findElement(settingsLink);
            return this;
        } catch (NoSuchElementException e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(settingsAndQuickLinksButton)).click();
            log.info("Clicked Settings and Quick links button one more time");
        }
        return this;
    }

    @Step("Click settings link")
    public MainPage clickSettingsLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsLink)).click();
        log.info("Clicked Settings link");
        return this;
    }

    @Step("Click more settings link")

    public SettingsPage clickMoreSettingsLink() {
        driver.findElement(moreSettingsLink).click();
        log.info("Clicked More settings link");
        return new SettingsPage(driver);
    }
}
