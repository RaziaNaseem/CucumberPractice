package Home.PracticeProject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	 
	public static ExtentReports getReportObject()
	{

		String path=System.getProperty("user.dir")+"\\reports\\index.html";
	    ExtentSparkReporter extentReporter = new ExtentSparkReporter(path);
	    extentReporter.config().setDocumentTitle("Test Results");
	    extentReporter.config().setReportName("Web Automation Results");
	    ExtentReports extent =new ExtentReports();
	    extent.attachReporter(extentReporter);
	    extent.setSystemInfo("Tester", "Razia");
	    return extent;
	}
	

}
