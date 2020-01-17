package com.eBayApplication.FrameworkConfig;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class ConfigFile {
	
	public static Set<Entry<Object, Object>> obj ;
	public static Map<Object, Object> mapObject = new HashMap<>();

	static{

		File file = new File("C:\\Users\\SCINDIA\\eclipse-workspace\\eBayApplication\\ScriptProperties\\script.properties");	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(file));		
			obj = prop.entrySet();		
			System.out.println("In Config File - reading script.properties ");
			for(Entry<Object, Object> en: obj){
				System.out.println(en.getKey()+" ="+ " "+ en.getValue() );			
				mapObject.put(en.getKey(), en.getValue());					
			}			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static String getProperty(String str){
		return mapObject.get(str).toString();	
	}

}
