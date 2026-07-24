package Specifications;

import Filters.ExtentReportFilter;
import Payloads.UserRepo;
import Utility.ReadConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationClass {
	

	
	
	public static RequestSpecification post_Request(Object body)
	{
		ReadConfig readConfig=new ReadConfig();
		RequestSpecification requestSpecification =new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Accept","application/vnd.github+json")
				.addHeader("Authorization", "Bearer  "+readConfig.getToken())
				.addHeader("X-GitHub-Api-Version", "2026-03-10")
				.addFilter(new ExtentReportFilter())
				.setBody(body).build();
		return requestSpecification;
		
	}

}
