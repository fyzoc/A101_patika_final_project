package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class Driver {
    public static WebDriver driver;
    public Driver(){
    }
    public static WebDriver getDriver(){
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    ChromeOptions chrome_options = new ChromeOptions();
                    chrome_options.addArguments("--start-maximized");
                    chrome_options.addArguments("--disable-blink-features=AutomationControlled");
                    chrome_options.addArguments("--disable-extensions");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chrome_options);
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}