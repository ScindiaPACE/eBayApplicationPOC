package com.eBayApplication.Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.eBayApplication.UiMap.UiMap;

public class checkOutPage extends UiMap {

	public checkOutPage() throws Exception {
		super();
	}
    
	public void validateCheckOutPage() throws Exception {
		System.out.print("Validating CheckOutPage");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		waitTillPageload(ShipTo_TXT); 
		waitTillPageload(Item_TXT);
		//scrollToElement(OrderTotal_TXT);
        System.out.print("CheckOut page validation done");
        System.out.print("Payment is needed to proceed further");
	}
	
}
