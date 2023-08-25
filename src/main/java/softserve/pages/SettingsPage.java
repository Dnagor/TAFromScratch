package softserve.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SettingsPage {
    private final WebDriver driver;
    private final By searchSection = By.id("search-section-content");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Settings page loaded")
    public boolean isSettingsPageLoaded() {
        var loaded = driver.findElement(searchSection).isDisplayed();
        log.info("Settings page was%s loaded".formatted(loaded ? "" : " not"));
        return loaded;
    }
}
