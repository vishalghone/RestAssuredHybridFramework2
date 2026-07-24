package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/APIReport.html");

            extent = new ExtentReports();      // ⭐ हे Missing होतं

            extent.attachReporter(spark);

        }

        return extent;
    }
}