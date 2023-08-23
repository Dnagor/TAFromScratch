package softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherSearchResultsPage {
    private final WebDriver driver;
    private final By weatherContainerCityTitle = By.cssSelector(".withPointerEvents");
    public WeatherSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isWeatherResultsPageLoaded(String cityTitle){
        return driver.findElement(weatherContainerCityTitle).getText().equals(cityTitle);
    }
}
