package api.utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter; // UI of the report.
	public ExtentReports extent; // Common information of the report.
	public ExtentTest test; // Test case information of the report.
	
	String reportName;
	
	public void onStart (ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat ("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time Stamp
		reportName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName); 		// Specify the location of the report

		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); 	// Title of the report
		sparkReporter.config().setReportName("Pet Store Users API"); 				// Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet Store Users API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Serdar");
	}
	
	public void onTestSuccess (ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());   																			
	    test.info("<li><b>Start Time:</b> " + new Date(result.getStartMillis()) + "</li>");	// Create timeline
	    test.info("<li><b>End Time:</b> " + new Date(result.getEndMillis()) + "</li>");
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure (ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped (ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish (ITestContext testContext)
	{
		extent.flush();
	}
}
