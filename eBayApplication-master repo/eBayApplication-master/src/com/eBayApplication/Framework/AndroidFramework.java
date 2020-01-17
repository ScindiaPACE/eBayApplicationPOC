package com.eBayApplication.Framework;

import java.io.File;


import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLEngineResult.Status;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.eBayApplication.FrameworkConfig.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.eBayApplication.Framework.AndroidFramework;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;


public class AndroidFramework {
	
	public AndroidFramework() throws Exception
	{
     super();
	}
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver;
	
	// =============================================================================================================================================================

		// OBJECT AND VARIABLE DECLARATION FOR DRIVER,WAIT,TOUCH-ACTION AND DESIRED
		// CAPABILITIES

		public DesiredCapabilities capabilities = new DesiredCapabilities();
		public static String strPlatformName, strPlatformVersion, strDeviceName, strUDID, strAppPath,strDeviceUdid,
		strAppPackage,strAppActivity;
		public WebDriverWait wait;
		public TouchAction action;
		
//		ExtentReports extent;
//		ExtentTest test;
//		
		String testMethodName;
		String descriptiveTestName;

		// variables for fetching data from ConfigFile
		public static String strHost, strPort;

		// ==============================================================================================================================================================

		// STATIC BLOCK TO FETCH DATA OUT OF CONFIGFILE AND ASSIGN TO LOCAL
		// VARIABLES [CONFIGFILE GETS DATA FROM PROPERTIES FILE]
		static {

			System.out.println("Reading Desired capabilities....");

			strHost = ConfigFile.getProperty("selenium.host");
			strPort = ConfigFile.getProperty("selenium.port");
		
			// Device Details

			if (ConfigFile.getProperty("platformName") == null | ConfigFile.getProperty("platformName") == "null") {
				strPlatformName = "";
			} else {
				strPlatformName = ConfigFile.getProperty("platformName");
			}

			if (ConfigFile.getProperty("platformVersion") == null | ConfigFile.getProperty("platformVersion") == "null") {
				strPlatformVersion = "";
			} else {
				strPlatformVersion = ConfigFile.getProperty("platformVersion");
			}

			if (ConfigFile.getProperty("deviceName") == null | ConfigFile.getProperty("deviceName") == "null") {
				strDeviceName = "";
			} else {
				strDeviceName = ConfigFile.getProperty("deviceName");
			}
			
			if (ConfigFile.getProperty("udid") == null | ConfigFile.getProperty("udid") == "null") {
				strDeviceUdid = "";
			} else {
				strDeviceUdid = ConfigFile.getProperty("udid");
			}
			
			if (ConfigFile.getProperty("appPackage") == null | ConfigFile.getProperty("appPackage") == "null") {
				strAppPackage = "";
			} else {
				strAppPackage = ConfigFile.getProperty("appPackage");
			}
			
			if (ConfigFile.getProperty("appActivity") == null | ConfigFile.getProperty("appActivity") == "null") {
				strAppActivity = "";
			} else {
				strAppActivity = ConfigFile.getProperty("appActivity");
			}
			
			if (ConfigFile.getProperty("app") == null | ConfigFile.getProperty("app") == "null") {
				strAppPath = "";
			} else {
				strAppPath = ConfigFile.getProperty("app");
			}
			
			System.out.println("Controls Exits out of Static Block");
		}
		
		public void SetUp() {
			File app = new File(strAppPath);
			//Set the Desired Capabilities
    		System.out.println("Setting Desired capabilities....");
            DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", strDeviceName);
			caps.setCapability("platformName", strPlatformName);
			caps.setCapability("platformVersion", strPlatformVersion);
			caps.setCapability("appPackage",strAppPackage);
			caps.setCapability("appActivity", strAppActivity);
			caps.setCapability("noReset", "true");
			caps.setCapability("app", app.getAbsolutePath());
			System.out.println("Desired capabilities setup done");
		
			//Instantiate Appium Driver
			try {                                  
				driver = new AndroidDriver(new URL("http://" + strHost + ":" + strPort + "/wd/hub"), caps);
				System.out.print("App Launched successfully");
					
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
		}
	
		//======================================================================================================================================
		// CLOSE APP FUNCTION

		public AndroidFramework closeApp() {
			System.out.println("Test Executio is done.");
			System.out.println("The application is about to quit...");
			System.out.println("All the best");
			driver.closeApp();		
			return this;
		}
	    //=======================================================================================================================================
		
	    public AndroidFramework waitTillPageload(String elementpath) throws Exception {
	    	System.out.println("Initiating wait sequence");
	    	wait = new WebDriverWait(driver, 90);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementpath)));
	    	return this;
	    }
		// FUNCTION FOR SCREENSHOT

		public AndroidFramework takeScreenshot(String screenshotPathAddress) throws InterruptedException, IOException {
			System.out.println("The control is inside ScreenShot block");
			// Reporter.log("<br><a href="+Screenshot.screenshotPath+"> click to
			// open screenshot </a>");
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(screenshotPathAddress));
			return this;

		}

		// END OF SCREENSHOT FUNCTION
	
		// FUNCTION FOR SCREEN ROTATION

		public AndroidFramework androidRotate() throws Exception {

			driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
			System.out.println(" Now screen orientation Is : "+ driver.getOrientation());
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
			System.out.println(" Now screen orientation Is : "+ driver.getOrientation());
			return this;

		}
		
		// =====================================================================================================================================================================
		// FUNCTION FOR WAIT SEQUENCE

		public AndroidFramework waitForLaunch() throws Exception {
			System.out.println("Initiating wait sequence");
			wait = new WebDriverWait(driver, 30);
			System.out.println("The EBay application is about to launch");
			return this;
		}
	    public AndroidFramework androidSwipe(String startpath, String stoppath) throws Exception {
	    	action = new TouchAction(driver);
	    	action.longPress((LongPressOptions) driver.findElement(By.xpath(startpath))).moveTo((PointOption) driver.findElement(By.xpath(stoppath)))
				.release().perform();
	    	return this;
	    }
	
	    public AndroidFramework androidScroll() throws Exception {
	    	org.openqa.selenium.Dimension scrnSize = driver.manage().window().getSize();
	    	int startx = scrnSize.width / 2;
	    	int starty = (int) (scrnSize.height * 0.75);
	    	int endy = (int) (scrnSize.height * 0.25);
	    	TouchAction action = new TouchAction(driver);
	    	//driver.swipe(startx, starty, startx, endy, 5000);
	    	//action.press(startx, starty).waitAction(2000).moveTo(startx, endy).release().perform();
	    	
	    	return this;
	    }
	    
	    public AndroidFramework scrollToElement(String element) throws Exception{
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	//This will scroll the page till the element is found
	    	//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    	WebElement Element = driver.findElement(By.xpath(element));
	        js.executeScript("arguments[0].scrollIntoView(true);", Element);
			return null;
	    }
	  
	    //===========================================================================================================================================
		//Function to check 
	    
	    public boolean checkElementPresent(String elementXpath) throws Exception {
			boolean check;
			check = driver.findElement(By.xpath(elementXpath)).isDisplayed();
			return check;
		}
	    
	    public boolean checkElementPresentById(String id) throws Exception {
			boolean check;
			check = driver.findElement(By.id(id)).isDisplayed();
			return check;
		}

		public boolean checkElementPresentMobileById(String id) throws Exception {
			boolean check;
			check = driver.findElement(MobileBy.AccessibilityId(id)).isDisplayed();
			return check;
		}

		public boolean checkElementPresentByName(String name) throws Exception {
			boolean check;
			check = driver.findElement(By.name(name)).isDisplayed();
			return check;
		}

		public boolean checkElementPresentByLinktext(String text) throws Exception {
			boolean check;
			check = driver.findElement(By.name(text)).isDisplayed();
			return check;
		}
}