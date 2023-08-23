package softserve.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private DriverManager(){}
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    private static ChromeDriver driver;

    public static WebDriver getWebDriver(){
        if (threadLocal.get() == null){
            driverSetup();
        }
        return threadLocal.get();
    }
    private static void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        threadLocal.set(driver);
    }
    public static void closeDriver(){
        getWebDriver().quit();
        driver = null;
        threadLocal.remove();
    }
}
