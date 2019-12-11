package testbase;

import junit.spring.main.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class TestBase {
    @Autowired
    public Environment environment;
    public WebDriver driver;


    public void setWebDriver() {
        //System.setProperty(environment.getProperty("webdriver"), environment.getProperty("webdriverlocation"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+environment.getProperty("webdriverlocation"));
    }

    public void openBrowserWindow() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void launchApplication(){
        driver.get(environment.getProperty("homePage"));
    }
}
