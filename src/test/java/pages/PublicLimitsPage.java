package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PublicLimitsPage extends BasePage {

    private static final By LIMITS_HEADER_LOC = By.xpath("//h1[text()='Simple limits for every workspace, presented like a pricing plan.']");

    private static final By STORAGE_LIMIT_LOC = By.xpath("//section[@class='mt-6']//article[1]/div[3]/div/div[2][text()='100 MB']");
    private static final By ACTIVE_RUNS_LIMIT_LOC = By.xpath("//section[@class='mt-6']//article[2]/div[3]/div/div[2][text()='5']");
    private static final By PROJECTS_PER_USER_LIMIT_LOC = By.xpath("//section[@class='mt-6']//article[3]/div[3]/div/div[2][text()='2']");
    private static final By MEMBERS_PER_PROJ_LIMIT_LOC = By.xpath("//section[@class='mt-6']//article[4]/div[3]/div/div[2][text()='3']");

    public PublicLimitsPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LIMITS_HEADER_LOC));
    }

    public boolean limitsAreDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(STORAGE_LIMIT_LOC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACTIVE_RUNS_LIMIT_LOC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PROJECTS_PER_USER_LIMIT_LOC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MEMBERS_PER_PROJ_LIMIT_LOC));
        return true;
    }
}
