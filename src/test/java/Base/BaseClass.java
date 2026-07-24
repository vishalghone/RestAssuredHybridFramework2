package Base;

import org.testng.annotations.BeforeClass;

import Utility.ReadConfig;
import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void getUrl()
	{
		ReadConfig readConfig=new ReadConfig();
		RestAssured.baseURI=readConfig.getUrl();
		
	}

}
