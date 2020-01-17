package com.eBayApplication.Pages;
import org.openqa.selenium.By;

import com.eBayApplication.UiMap.UiMap;

public class ProductDisplayPage extends UiMap {

	public ProductDisplayPage() throws Exception {
		super();
	}
	
	public void validateCriticalElements() throws Exception {
		waitTillPageload(ItemName_TXT_VIEW);
		waitTillPageload(BuyItNow_BTN);
		waitTillPageload(Watch_BTN);
	}
	
	public void tapBuyItNowButton() throws Exception {
		try {
		validateCriticalElements();
		androidRotate();
		System.out.print("PDP critical elements validated");
		driver.findElement(By.xpath(BuyItNow_BTN)).click();
		System.out.print("Buy It Now button tapped");
		}catch(Exception e) {
			System.out.print(e);
		}
	}

}
