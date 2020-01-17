package com.eBayApplication.Pages;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBayApplication.Framework.ExcelUtils;
import com.eBayApplication.UiMap.UiMap;

import io.appium.java_client.android.AndroidDriver;


public class Login extends UiMap { 
	
	public Login() throws Exception {
		super();
	}

	//Method to verify login button
	public void verifyloginButton() throws Exception {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("wait over for login over");
		Boolean checkSignInIsEnabled = checkElementPresent(SignIn_BTN);
		if (checkSignInIsEnabled == true) {
			System.out.println("Login Button is visible");
		} else {
			System.out.println("Unable to find login button ");
			signOut();
		}
	}
	
	//Method to tap login button
	public void tapLoginButton() {
		System.out.println("\nchecking sign in button");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("wait over");
		driver.findElement(By.xpath(SignIn_BTN)).click();
	}
	
	//Method to sign in with credentials and tap sign in button
	public void enterCredentials(String sUserName,String sPassword) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(UserName_FLD)).sendKeys(sUserName);
		driver.findElement(By.id(Password_FLD)).click();
		driver.findElement(By.id(Password_FLD)).sendKeys(sPassword);
		driver.findElement(By.xpath(SignIn_BTN)).click();
		if(driver.findElement(By.xpath(Ebay_Logo_TXT)).isDisplayed()==true){
			System.out.print("HomePae loaded successfully");
		}else
		{
			System.out.print("Unable to login");
		}
	}
	
	//Method to signOut
	public void signOut() {
		driver.findElement(By.xpath(Main_Nav_BTN)).click();
		driver.findElement(By.xpath(Signed_User_BTN)).click();
		driver.findElement(By.xpath(Sign_Out_BTN)).click();
		driver.findElement(By.xpath(signOut_alert_OK_BTN)).click();
		System.out.println("\nUser signed out successfully");
	}
}
