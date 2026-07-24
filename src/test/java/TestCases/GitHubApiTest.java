package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Endpoint.EndPoints;
import Payloads.UserRepo;
import Specifications.RequestSpecificationClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GitHubApiTest extends BaseClass{
	
	@Test
	public void CreateRepo()
	{    UserRepo user=new UserRepo();
	user.setName("Vishal_api3");
		Response res=RestAssured.given().spec(RequestSpecificationClass.post_Request(user)).when().post(EndPoints.baseRepo);
		int responsecode=res.getStatusCode();
		Assert.assertEquals(responsecode, 201);
		System.out.println(responsecode);
		
	}
	

}
