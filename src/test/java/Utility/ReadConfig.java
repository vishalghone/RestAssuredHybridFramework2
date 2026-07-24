package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro= new Properties();

	
	
	public ReadConfig()
	{
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\config.properties");
			 pro= new Properties();
			   try {
				pro.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	

}
	
	public String getUrl()
	{
		return pro.getProperty("BaseUrl");
	}
	
	public String getToken()
	{
		return pro.getProperty("token");
	}
}