package com.eBayApplication.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBayApplication.Framework.ExcelUtils;
import com.eBayApplication.UiMap.UiMap;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class HomeScreen extends UiMap{
	
   String sProductName;
   public HomeScreen() throws Exception {
		ExcelUtils.setExcelFile("C:\\Users\\SCINDIA\\eclipse-workspace\\eBayApplication\\src\\com\\eBayApplication\\TestData\\testData.xlsx","ProductDetails");
		sProductName = ExcelUtils.getCellData(1, 0);
	}

   //Method to search product 
   public void searchProduct() throws Exception {
	   System.out.print("Search product");
	   driver.findElement(By.id(Search_FLD)).sendKeys(sProductName);
	   System.out.print("Product name entered");
	   driver.findElement(By.xpath (Search_Result_TXT)).click();
	   System.out.print("Search Results obtained");
   }
}
