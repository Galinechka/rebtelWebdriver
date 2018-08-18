package tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.DialMenu;
import pages.GetStartedPage;
import pages.LivingRoom;
import pages.VerifyNumber;

public class test {
    public WebDriver driver = null;
    public String number = "+380673104445";
    public String activationCode = "1234";

    @BeforeMethod
    public void setUp() throws Exception {
// set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability("udid", "6ceae22240cad9993a42bcf34178f67325e49fdd");
        capabilities.setCapability("orientation","PORTRAIT");
        capabilities.setCapability("bundleId","com.rebtel.Rebtel");
        driver = new RemoteWebDriver(new URL("http://172.20.10.3:8100"), capabilities);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority=1)
    public void login() throws InterruptedException {

        GetStartedPage.GetStarted(driver);
        VerifyNumber.EnterNumber(driver, number);
        VerifyNumber.TapContinue(driver);
        VerifyNumber.EnterCode(driver, activationCode);
        Assert.assertTrue(LivingRoom.verifyLivingRoomPage(driver));
    }

    @Test(priority=2)
    public void dialNumber() throws InterruptedException {
        LivingRoom.OpenDialMenu(driver);
        DialMenu.DialNumber(driver, number);
        DialMenu.EndCall(driver);
        Assert.assertTrue(LivingRoom.VerifyCallEntry(driver, number));
    }
}
