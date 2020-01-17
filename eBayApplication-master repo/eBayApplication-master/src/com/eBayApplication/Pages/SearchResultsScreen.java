package com.eBayApplication.Pages;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

///import com.androidtest.pages.SearchScreen;
import com.eBayApplication.Framework.ExcelUtils;
import com.eBayApplication.UiMap.UiMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import io.appium.java_client.android.AndroidDriver;

public class SearchResultsScreen extends UiMap {

	public SearchResultsScreen() throws Exception {
		super();
	}

	String sProductName;
	
	@SuppressWarnings("deprecation")
	public SearchResultsScreen searchProduct(String text) throws Exception
	{	
	   System.out.println("\nStarting SearchScreen Procedure...");
		try {
			driver.findElement(By.xpath(SearchBox_TBX)).click();
			waitTillPageload(Search_FLD);
			driver.findElement(By.xpath(Search_FLD)).sendKeys(text);
			System.out.println("The item is entered");
			driver.findElement(By.xpath (Search_Result_TXT)).click();
			System.out.print("Search Results obtained");
			waitTillPageload(SuggestedResult_TITLE);
			System.out.println("\nSearch successful, the results are now displayed.");
		} catch (Exception e) {
			System.out.println("##### Search operation failed #####");
			e.printStackTrace();
			Assert.assertTrue(false);
		}

		return this;
	}
	
	public SearchResultsScreen selectItem(String path) throws Exception {
		try {
			if (checkElementPresent(path) == false) {
				throw new Exception();

			}
			System.out.println(" Search complete, Item found");
			driver.findElement(By.xpath(path)).click();
			System.out.println("The app is now navigating to product detail page.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("##### Search Select action failed #####");
			Assert.assertTrue(false);
		}
		return this;
	}
}
