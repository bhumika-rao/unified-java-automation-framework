package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            reporter.config().setReportName("Unified Automation Report");
            reporter.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Bhumika Rao");
        }
        return extent;
    }
}
