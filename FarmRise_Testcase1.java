package Androidapp;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FarmRise_Testcase1 {
	
public void setUp() throws MalformedURLException
{
	WebDriver driver;
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "5.1.1"); 
	capabilities.setCapability("deviceName","Emulator");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("Androiapp", "com.android.FarmRise");
	// This package name of your app (you can get it from apk info app)
    capabilities.setCapability("appActivity","com.android.FarmRise"); // This is Launcher activity of your app (you can get it from apk info app)
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    //Click on Home Tab
    driver.findElement(By.name("Home")).click();
    Thread.sleep(5000);//Navigate to Home Screen
    // Tap on "Access weather Details" in Weather details section > Verify the timings in the Horizontal scroll from now to 23hrs
    driver.findElement(By.linkText("Access Weather Details")).click();
    TouchActions action = new TouchActions(driver);
    action.scroll(element, 23,23);
    action.perform();
	driver.quit();
}
}
