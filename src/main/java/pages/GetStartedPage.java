package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetStartedPage {
    public static By getStartedBtn = By.id("Get started");

    public static void GetStarted (WebDriver webDriver){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedBtn));
        webDriver.findElement(getStartedBtn).click();
    }
}
