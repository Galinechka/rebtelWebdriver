package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DialMenu {

    public static By phoneNumberField = By.xpath("//XCUIElementTypeButton[@name='Cancel']/following-sibling::XCUIElementTypeTextField");
    public static By cancelBtn = By.id("Cancel");
    public static By dialBtn = By.id("phoneIcon call");

    public static void DialNumber (WebDriver webDriver, String phoneNumber){
        webDriver.findElement(phoneNumberField).clear();
        webDriver.findElement(phoneNumberField).sendKeys(phoneNumber);
        webDriver.findElement(dialBtn).click();
    }

    public static void EndCall(WebDriver webDriver){
        webDriver.findElement(cancelBtn).click();
    }
}
