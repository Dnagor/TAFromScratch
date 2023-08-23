package softserve.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private DriverManager(){}
    private static ChromeDriver driver;

    public static ChromeDriver getWebDriver(){
        if (driver == null){
            driverSetup();
        }
        return driver;
    }
    private static void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
