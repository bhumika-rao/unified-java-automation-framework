package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String reportsDir = System.getProperty("user.dir") + "/reports/";

        String timestampedReportPath = reportsDir + "ExtentReport_" + timestamp + ".html";
        String latestReportPath = reportsDir + "ExtentReport_LATEST.html";

        // Create timestamped report
        ExtentSparkReporter spark = new ExtentSparkReporter(timestampedReportPath);
        spark.config().setReportName("Automation Test Report");
        spark.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("QA Engineer", "Bhumika Rao");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
