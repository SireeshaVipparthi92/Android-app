package Androidapp;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FarmRise_Testcase2 {
	
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
    driver.findElement(By.name("Home")).click();
    Thread.sleep(5000);
    //click on More tab
    driver.findElement(By.linkText("More")).click();
    Thread.sleep(1000);
    //Tap on government schemes
    driver.findElement(By.name("Government Schemes")).click();
    Thread.sleep(8000);
    WebElement ele= driver.findElement(By.name("Load More schemes")).click();
    Assert.assertEquals(ele,"Load More schemes");
    //scroll 3times to untill load more schemes
    driver.findElement(By.id("Search")).click().sendKeys("scheme");
	driver.quit();
    
}
}
