package softserve;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import softserve.pages.MainPage;
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
        var weatherSearchResultsPage = mainPage.waitForPageToLoad().weahtherSearchByCity("weather in Lviv");
        assertTrue(weatherSearchResultsPage.isWeatherResultsPageLoaded("Lviv, Ukraine"));
    }
    @Test
    public void test2(){
        var chatPage = mainPage.waitForPageToLoad().clickChatButton();
        assertTrue(chatPage.isChatPageLoaded());
    }
    @Test
    public void test3(){
        var settingsPage = mainPage.waitForPageToLoad().clickSettingsAndQuickLinksButton()
                .clickSettingsLink()
                .clickMoreSettingsLink();
        assertTrue(settingsPage.isSettingsPageLoaded());
    }
}
