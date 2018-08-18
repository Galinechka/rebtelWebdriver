package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LivingRoom {

    public static By searchDialBtn = By.id("search dialpad icon");

    public static void OpenDialMenu (WebDriver webDriver){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchDialBtn));
        webDriver.findElement(searchDialBtn).click();
    }

    public static Boolean verifyLivingRoomPage (WebDriver webDriver){
        return webDriver.findElement(By.id("RebtelSettingsView")).isDisplayed();
    }

    public static boolean VerifyCallEntry(WebDriver webDriver, String number) {
        //phormat phone umber as +NNN NN NNN NNNN
        String phoneNumber = number.substring(0,4) + " " + number.substring(4,6) + " " +
                number.substring(6,9) + " " + number.substring(9, 13);
        return webDriver.findElement(By.id(phoneNumber)).isDisplayed();
    }
}
