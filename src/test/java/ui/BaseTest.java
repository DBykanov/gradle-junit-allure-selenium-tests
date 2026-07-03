package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions opt = new ChromeOptions();
        //opt.addArguments("--headless=new");
        opt.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Selenium будет каждые 500 мс опрашивать DOM-дерево в течение X секунд, пока элемент не появится.
    }


    @AfterEach
    public void tearDown() {
        driver.close();
    }

}
