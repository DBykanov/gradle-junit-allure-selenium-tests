package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    private static final String URL = "https://testedy.com";
    private static final By getStartedBtn = By.xpath("//a[text()='Get started']");
    private static final By pageHeader = By.xpath("//h1[text()='A workspace for QA teams, test cases, and test runs in one place.']");
    private static final By LIMITS_LINK_LOC = By.xpath("//a[@href='/limits']");


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage openLP() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return this;
    }

    public RegisterPage clickOnRegister() {
        click(getStartedBtn);
        return new RegisterPage(driver);
    }


    public PublicLimitsPage clickOnLimits(){
        click(LIMITS_LINK_LOC);
        return new PublicLimitsPage(driver);
    }


}
