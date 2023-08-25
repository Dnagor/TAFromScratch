package softserve.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WeatherSearchResultsPage {
    private final WebDriver driver;
    private final By weatherContainerCityTitle = By.cssSelector(".withPointerEvents");

    public WeatherSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Weather results page for {cityTitle} loaded")
    public boolean isWeatherResultsPageLoaded(String cityTitle) {
        var loaded = driver.findElement(weatherContainerCityTitle).getText().equals(cityTitle);
        log.info("Weather results page was%s loaded".formatted(loaded ? "" : " not"));
        return loaded;
    }
}
