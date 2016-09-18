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
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, System.getProperty("PlatformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, System.getProperty("PlatformVersion"));
		cap.setCapability(MobileCapabilityType.APP, new File("./UI-Catalog-App.zip").getAbsolutePath());
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4730/wd/hub"), cap);
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
