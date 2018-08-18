package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyNumber {

    public static By phoneNumberField = By.xpath("//XCUIElementTypeButton[@name='+380']/following-sibling::XCUIElementTypeTextField");
    public static By continueBtn = By.id("Continue");

    public static void EnterNumber (WebDriver webDriver, String number){
        //cut off the country code of phone number
        String phoneNumber = number.substring(4);

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField));
        webDriver.findElement(phoneNumberField).sendKeys(number);
    }

    public static void TapContinue (WebDriver webDriver){
        webDriver.findElement(continueBtn).click();
    }

    public static void EnterCode (WebDriver webDriver, String code){
        String xpath;
        for (int i= 1; i<5; i++){
            xpath = "(//XCUIElementTypeImage[@name='Passcode Red Icon'])[" + i + "]/preceding-sibling::XCUIElementTypeTextField";
            webDriver.findElement(By.xpath(xpath)).sendKeys(code.substring(i-1,i));
        }
    }
}
