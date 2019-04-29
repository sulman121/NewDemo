package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Lib {
	
	public static String ReadProperties(String key) throws Exception {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("/Users/selenium/eclipse-workspace/UnitedAriLine/EMICalculator/src/test/resource/Prop/Locator.properties");
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
		
	}
	
	
	
	
	

}
