package eBayApplication;

import com.eBayApplication.UiMap.UiMap;
import com.relevantcodes.extentreports.ExtentReports;

import org.testng.annotations.Listeners;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import com.eBayApplication.Framework.ExcelUtils;
import com.eBayApplication.Framework.TestNGFramework;
import com.eBayApplication.Pages.*;
import com.eBayApplication.Framework.Constant;
@Listeners(TestNGFramework.class)


public class AppTest extends UiMap {
	
	String sProductName;
	ExtentReports extent;
	ExtentTest test;
	String testMethodName;
	String descriptiveTestName;
	String sUserName;
	String sPassword;
	String sIncorrectPassword;
	
	Method method;
	
	Login loginObj = new Login();
	HomeScreen homeObj = new HomeScreen();
	SearchResultsScreen searchObj = new SearchResultsScreen();
	ProductDisplayPage pdpObj = new ProductDisplayPage();
	checkOutPage checkOutObj =new checkOutPage();
	
	public AppTest() throws Exception {
		
		ExcelUtils.setExcelFile(Constant.Path_TestDataFile,"ProductDetails");
		sProductName = ExcelUtils.getCellData(1, 0);
		ExcelUtils.setExcelFile(Constant.Path_TestDataFile,"Credentials");
		sUserName = ExcelUtils.getCellData(1, 1);
		sPassword = ExcelUtils.getCellData(1, 2);
		sIncorrectPassword =ExcelUtils.getCellData(2, 2);
	}
		
	
	@BeforeSuite
	public void beforeSuite() {
		extent = new ExtentReports("C:\\Users\\SCINDIA\\eclipse-workspace\\eBayApplication\\test-output\\EbayExtentReport.html",true);
		extent.loadConfig(new File("C:\\Users\\SCINDIA\\eclipse-workspace\\eBayApplication\\extent-config.xml"));
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		SetUp();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);		
		test = extent.startTest((this.getClass().getSimpleName() + "::" + method.getName()));
		test.assignAuthor("ScindiaP");
    	test.assignCategory("Test Report Ebay");
    	test.log(LogStatus.PASS, "App launched successfully");
	}
	
	@AfterMethod
	public void afterMethod() throws Exception {
		closeApp();
		test.log(LogStatus.PASS, "App closed successfully");
		extent.endTest(test);
		extent.flush();
	}

	@AfterSuite
	public void tearDown() throws Exception {
    	extent.close();
	}

		
	/*@Test(priority =3)
	public void loginTest() {
		try {
		//loginObj.verifyloginButton();
		//loginObj.tapLoginButton();
		//loginObj.enterCredentials(sUserName,sPassword);
		test.log(LogStatus.PASS, "Login successful");
		test.log(LogStatus.PASS, "TEST PASSED");
		}catch(Exception e ) {
			test.log(LogStatus.FAIL, "SORRY! TEST FAILED");
			System.out.println("Error in Main flow Test Page");
		}	
	}*/
	
	@Test(priority =2)
	public void checkOutTest() throws Exception {
		try {
		//loginObj.verifyloginButton();
		//loginObj.tapLoginButton();
		//loginObj.enterCredentials(sUserName,sPassword);
		test.log(LogStatus.PASS, "Login successfuls");
		searchObj.searchProduct(sProductName);
		test.log(LogStatus.PASS, "Search result obtained");
		//searchObj.selectItem(Select_Third_Result_BOUNDS);
		searchObj.selectItem(Select_Firts_Result);
		androidRotate();
		pdpObj.tapBuyItNowButton();
		test.log(LogStatus.PASS, "Item added and Naviating to review order page\n");
		checkOutObj.validateCheckOutPage();
		test.log(LogStatus.PASS, "Checkout validation successful");
		test.log(LogStatus.PASS, "TEST PASSED");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "SORRY! TEST FAILED");
			System.out.println("Error in Main flow Test Page");
			e.printStackTrace();
		}		
	}
	
	/*@Test(priority =1)
	public void signOutTest() {
		try {
		loginObj.tapLoginButton();
		loginObj.enterCredentials(sUserName,sPassword);
		test.log(LogStatus.PASS, "Login successful");
		loginObj.signOut();
		test.log(LogStatus.PASS, "SignOut successful");
		test.log(LogStatus.PASS, "TEST PASSED");
		}catch(Exception e ) {
			test.log(LogStatus.FAIL, "SORRY! TEST FAILED");
			System.out.println("Error in Main flow Test Page");
		}	
	}
	
	@Test(priority =4)
	public void failTest() {
		try {
		loginObj.tapLoginButton();
		loginObj.enterCredentials(sUserName,sIncorrectPassword);
		searchObj.searchProduct(sProductName);
		test.log(LogStatus.PASS, "Login successful");
		test.log(LogStatus.PASS, "TEST PASSED", testMethodName);
		}catch(Exception e ) {
			test.log(LogStatus.FAIL, "SORRY! TEST FAILED",testMethodName);
			System.out.println("Error in Main flow Test Page");
		}	
	}*/
}
