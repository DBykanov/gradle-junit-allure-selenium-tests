package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private static final By PAGE_HEADER_LOC = By.xpath("//h1[text()='Create account']");
    private static final By REPEAT_PASSWORD_LOC = By.xpath("//input[@type='password' and @placeholder='Repeat password']");
    private static final By SUBMIT_BUTTON_LOC = By.xpath("//button[@type='submit']");
    private static final By EMAIL_INPUT_LOC = By.xpath("//input[@type='email']");
    private static final By PASSWORD_INPUT_LOC = By.xpath("//input[@type='password' and @placeholder='Enter password']");

    private static final By SUCCESS_REG_HEADER_LOC = By.xpath("//h1[text()='Check your email']");
    private static final String SUCCESS_REG_EMAIL_LOC = "//p[text()='%s']";

    public RegisterPage(WebDriver driver) {
        super(driver);
        //check the register page is opened (by header text)
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_HEADER_LOC));
    }

    public RegisterPage register(String email, String password) {
        type(EMAIL_INPUT_LOC, email);
        type(PASSWORD_INPUT_LOC, password);
        type(REPEAT_PASSWORD_LOC, password);
        click(SUBMIT_BUTTON_LOC);
        return this;
    }

    public boolean isRegistered(String emailEntered) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_REG_HEADER_LOC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(SUCCESS_REG_EMAIL_LOC, emailEntered))));
        return true;
    }
}
