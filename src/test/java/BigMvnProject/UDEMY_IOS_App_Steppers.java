package BigMvnProject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UDEMY_IOS_App_Steppers {
	WebDriver driver;
	@BeforeTest
	public void launchAppium() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "iPhone Simulator");
		cap.setCapability("platformName", System.getProperty("PlatformName"));
		cap.setCapability("platformVersion", System.getProperty("PlatformVersion"));
		cap.setCapability("app", new File("./UI-Catalog-App.zip").getAbsolutePath());
		cap.setCapability("appiumVersion", "1.5.3");
		cap.setCapability("browserName", "");
		
		driver = new IOSDriver(new URL("http://wibmo333:3b73f163-740f-476d-8887-71d0269b59a8@ondemand.saucelabs.com:80/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}
	
	@Test
	public void segmentedControl(){
		System.out.println("Navigated to Segments");
		((IOSDriver) driver).scrollTo("Segments").click();
		driver.findElements(By.className("UIASegmentedControl")).get(1).findElement(By.name("Tools")).click();
		driver.findElements(By.className("UIASegmentedControl")).get(1).findElement(By.name("Search")).click();
		driver.findElements(By.className("UIASegmentedControl")).get(1).findElement(By.name("Check")).click();
		driver.quit();
	}
	
	@AfterTest
	public void stopAppium() throws IOException{
		String[] commands = {"/usr/bin/killall", "9", "node"};
		Runtime.getRuntime().exec(commands);
	}
}
