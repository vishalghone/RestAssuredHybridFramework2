package Utility;

import com.aventstack.extentreports.ExtentTest;

public class ReportManager {
	
	
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public static void set(ExtentTest extentTest) {
		test.set(extentTest);
		
	}
    public static ExtentTest get()
	
	{
		return test.get();
		
	}
    public static void info(String message) {

	    if (test.get() == null) {
	        throw new RuntimeException("ExtentTest is NULL");
	    }

	    test.get().info(message);
	}

    public static void pass(String message) {
        test.get().pass(message);
    }

    public static void fail(Throwable throwable) {
        test.get().fail(throwable);
    }

    public static void skip(String message) {
        test.get().skip(message);
    }
    public static void info(String title, String value) {

        get().info("<b>" + title + "</b><br><pre>" + value + "</pre>");
    }


}
