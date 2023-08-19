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
    private final By chatButton = By.xpath("//a/div[contains(text(),'Chat')]");

    public WeatherSearchResultsPage search(String query){
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        //logs
        return new WeatherSearchResultsPage(driver);
    }
    public void clickChatButton(){
        driver.findElement(chatButton).click();
        //logs
    }
}
