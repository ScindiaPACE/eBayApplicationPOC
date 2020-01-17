package com.eBayApplication.UiMap;

import com.eBayApplication.Framework.AndroidFramework;
import io.appium.java_client.android.AndroidDriver;


public class UiMap extends AndroidFramework{
    
	public UiMap() throws Exception {
		super();
	}

	public static String SignIn_BTN = "//android.widget.Button[contains(@resource-id,'com.ebay.mobile:id/button_sign_in')]";
	
	//SignInScreen
	public static String UserName_FLD = "com.ebay.mobile:id/edit_text_username";
	public static String Password_FLD ="com.ebay.mobile:id/edit_text_password";
	public static String signOut_alert_OK_BTN ="//android.widget.Button[contains(@resource-id,'android:id/button1')]";
	
	//SignOut
	public static String Signed_User_BTN = "//android.widget.CheckedTextView[@content-desc='scivin0,double tap to activate']";
	public static String Sign_Out_BTN = "//android.widget.CheckedTextView[@text='Sign out']";
	
	//HomeScreen
	public static String Search_Result_TXT = "//android.widget.TextView[@bounds='[0,576][912,720]']";
	public static String Main_Nav_BTN = "//android.widget.ImageButton[@content-desc='Main navigation, open']";
	public static String Ebay_Logo_TXT ="//android.widget.ImageView[contains(@resource-id,'com.ebay.mobile:id/logo')]";
	// Search Result
	public static String SuggestedResult_TITLE = "//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/title')]";
	public static String SearchBox_TBX = "//android.widget.TextView[@text='Search for anything']";
	public static String Search_FLD = "//android.widget.EditText[@text='Search for anything']";
	public static String Select_Third_Result_BOUNDS = "//android.widget.TextView[@bounds='[0,576][912,720]']";
	public static String Select_Firts_Result = "//android.widget.TextView[@bounds='[477,637][912,803]']";
	
	//ProductDisplayPage
	public static String ItemName_TXT_VIEW = "//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/textview_item_name')]";
	public static String BuyItNow_BTN = "//android.widget.Button[@text='BUY IT NOW']";
	public static String Watch_BTN = "//android.widget.Button[@text='WATCH']";
		   	
	//CheckOutPage
	public static String ShipTo_TXT = "//android.widget.TextView[@text='Ship to']";
	public static String Item_TXT = "//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/item_title')]";
	public static String OrderTotal_TXT = "//android.widget.TextView[@text='Order total']";
}
