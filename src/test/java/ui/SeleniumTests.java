package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LandingPage;
import pages.RegisterPage;

import java.util.Random;

public class SeleniumTests extends BaseTest {

    @Test
    public void firstSeleniumTest() {

        String expectedTitle = "Testedy";

        driver.get("https://testedy.com");
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
        //*[@href='/register' and text()='Get started']
    }


    @Test
    @DisplayName("Успешная регистрация и отображение email на экране подтверждения")
    public void dirtyRegisterTest() {

        //open lp
        driver.get("https://testedy.com");
        //click on register btn
        WebElement e = driver.findElement(By.xpath("//a[text()='Get started']"));
        e.click();
        //check the register page is opened (by header text)
        WebElement b = driver.findElement(By.xpath("//h1[text()='Create account']"));
        Assertions.assertTrue(b.isDisplayed());

        //enter data
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password' and @placeholder='Enter password']"));
        WebElement repeatPassword = driver.findElement(By.xpath("//input[@type='password' and @placeholder='Repeat password']"));
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Random random = new Random();
        String emailText = "testemail-" + random.nextInt() + "@example.org";
        String passwordText = "test-pass-" + random.nextInt(1000);

        email.sendKeys(emailText);
        password.sendKeys(passwordText);
        repeatPassword.sendKeys(passwordText);
        submit.click();


        By successHeader = By.xpath("//h1[text()='Check your email']");
        By successedEmail = By.xpath(String.format("//p[text()='%s']", emailText));

        wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successedEmail));

        //Assertions.assertTrue(successHeader.isDisplayed());
        //Assertions.assertTrue(successedEmail.isDisplayed());

    }

    @Test
    @DisplayName("Успешная регистрация и отображение email на экране подтверждения")
    public void niceRegisterTest() {

        Random random = new Random();
        String emailText = "testemail-" + random.nextInt() + "@example.org";
        String passwordText = "test-pass-" + random.nextInt(1000);

        LandingPage lp = new LandingPage(driver)
                .openLP();

        RegisterPage registerPage = lp
                .clickOnRegister()
                .register(emailText, passwordText);

        Assertions.assertTrue(registerPage.isRegistered(emailText),
                "The success header or registered email " + emailText + " isn't displayed");
    }
}