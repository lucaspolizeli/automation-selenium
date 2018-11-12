package br.com.atomicsolutions.proton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProtonConfig {
	
	
	public static String getProperty(String property) throws IOException {
	
		InputStream inputStream;
		String returnValue;
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String propFileName = "config.properties";
	
		inputStream = loader.getResourceAsStream(propFileName);
		
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		returnValue = prop.getProperty(property);
		return returnValue;
	
	}
	
}
