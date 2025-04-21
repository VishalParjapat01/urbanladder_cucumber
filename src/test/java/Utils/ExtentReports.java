package Utils;



import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void inititial() {
		ExtentSparkReporter reporter =  new ExtentSparkReporter("Extent_Report.html");
		extent = new ExtentReports();
		
	}
	
}
