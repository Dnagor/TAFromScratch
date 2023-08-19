package softserve;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import softserve.pages.ChatPage;
import softserve.pages.MainPage;
import softserve.pages.WeatherSearchResultsPage;
import softserve.utils.DriverManager;

import static org.testng.AssertJUnit.assertTrue;

public class BingTests {
    public WebDriver webDriver;
    public MainPage mainPage;
    @AfterMethod
    public void tearDown(){
        DriverManager.closeDriver();
    }
    @BeforeMethod
    public void driverSetup(){
        webDriver = DriverManager.getWebDriver();
        webDriver.get("https://www.bing.com/");
        mainPage = new MainPage(webDriver);
    }
    @Test
    public void test1(){
        mainPage.search("weather in Lviv");
        var weatherSearchResultsPage = new WeatherSearchResultsPage(webDriver);
        assertTrue(weatherSearchResultsPage.isWeatherResultsPageLoaded("Lviv, Ukraine"));
    }
    @Test
    public void test2(){
        mainPage.clickChatButton();
        var chatPage = new ChatPage(webDriver);
        assertTrue(chatPage.isChatPageLoaded());
    }
}
