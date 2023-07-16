package DemoTestNG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetup.Base;
import Pages.Login;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.Utility;

public class LoginTestNG extends Base  {
	
	WebDriver driver;
	
	Login login;
	LoginPage loginpage;
	SoftAssert soft;
	String TESTID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
		
	@Parameters("browser")
	
//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("Before Suite-2");
//	}
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		
		System.out.println("Before Test-2");
		if(BrowserName.equals("Chrome"))
		{
			driver=OpenChromeBrowser();
		}
		if(BrowserName.equals("Firefox"))
	    {
			driver=OpenFirefoxBrowser();
		}
		if(BrowserName.equals("Edge"))
	    {
			driver=OpenEgdeBrowser();
		}
	
			
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class-2");
		login=new Login(driver);
		loginpage=new LoginPage(driver);
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method-2");
		driver.get("https://itera-qa.azurewebsites.net/");
		login.clickonlogin();
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyLoginPageisOpen() {
		System.out.println("Test A");
	
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://itera-qa.azurewebsites.net/Login";
		
		String actualTitle=driver.getTitle();
		String expectedTitle="- Testautomation practice page";
		
	
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualTitle, expectedTitle,"Title is Wrong");
		soft.assertAll();
	
	}
	@Test(priority=2)
	public void VerifyLoginTextprsentinPage() {
		TESTID="TEST-1025";
		System.out.println("Test B");
		 String Actualmsg=loginpage.VerifyLoginText();
		 String Expectsmg="LOGIN";
//		 String Expectsmg="LOGIN INTO TEST";
		
		 soft.assertEquals(Actualmsg, Expectsmg,"Text is wrong");
		 soft.assertAll();
	}
	
	@Test(priority=3)
	public void VerifyLoginFunctionality() throws EncryptedDocumentException, IOException, InterruptedException {
		TESTID="TEST-1026";
		System.out.println("Test C");
		
		Thread.sleep(3000);
		
		String data=Utility.getExcelData("Sheet1", 7, 0);
		loginpage.SendUserName1(data);
		Thread.sleep(3000);
		
		
		data=Utility.getExcelData("Sheet1", 7, 1);
		loginpage.SendPassword1(data);
		Thread.sleep(3000);

//		loginpage.SendUserName1("Sanjay@2025");
//		loginpage.SendPassword1("Pass@1996");
	
		loginpage.ClickonLogin1();
		Thread.sleep(5000);
		
		
		
		
		
		
		
//		String ActualURL=driver.getCurrentUrl();
//		String ExpectedURL="https://itera-qa.azurewebsites.net/Dashboard";
//		
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="- Testautomation practice page";
//	
//		
//		
//		 soft.assertEquals(ActualURL, ExpectedURL,"After Login URL is wrong");
		 soft.assertEquals(ActualTitle,ExpectedTitle,"After Login page Title is wrong");
		 soft.assertAll();
	}
				
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-2");
	}
	
	
	@AfterClass
	public void clearObject() {
		login=null;
		loginpage=null;

	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-2");
		driver.quit();
		driver=null;
		System.gc();  //Garbage Collection
	}
	

	
	
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("After Suite-2");
//	}
	
	}



