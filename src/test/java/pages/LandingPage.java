package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    private static final String URL = "https://testedy.com";
    By getStartedBtn = By.xpath("//a[text()='Get started']");
    By pageHeader = By.xpath("//h1[text()='A workspace for QA teams, test cases, and test runs in one place.']");

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


}
