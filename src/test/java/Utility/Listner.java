package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class Listner implements ITestListener{

	private static ExtentReports extent=ExtentManager.getInstance();


	//ExtentTest test;
	

	@Override
	public void onTestStart(ITestResult result) {

	    System.out.println("######## onTestStart ########");

	    ExtentTest extentTest = extent.createTest(result.getName());

	    ReportManager.set(extentTest);

	    System.out.println("Extent Test : " + ReportManager.get());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ReportManager.get().pass("pased");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		ReportManager.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ReportManager.get().skip("Skip");
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution stat");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		System.out.println("Execution end");
		extent.flush();
		
	}

}