package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext){

        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //Time stamp
        repName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName); //Specify location of the report

        sparkReporter.config().setDocumentTitle("RestAssured Automation Report"); //Title of the report
        sparkReporter.config().setReportName("Pet Store User API"); //Name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","Pet Store User API");
        extent.setSystemInfo("User name",System.getProperty("user.name"));
        extent.setSystemInfo("Environment","QA");

    }

    public void onTestSuccess(ITestResult result){
        test= extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); //To display groups in report
        test.createNode(result.getName());
        test.log(Status.PASS,result.getName()+" got successfully executed");
    }

    public void onTestFailure(ITestResult result){
        test= extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups()); //To display groups in report
        test.createNode(result.getName());
        test.log(Status.FAIL,result.getName()+" got failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());

    }
    public void onTestSkipped(ITestResult result){
        test= extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups()); //To display groups in report
        test.createNode(result.getName());
        test.log(Status.SKIP,result.getName()+" got skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());

    }
    public void onFinish(ITestContext testContext){
        extent.flush();
    }
}