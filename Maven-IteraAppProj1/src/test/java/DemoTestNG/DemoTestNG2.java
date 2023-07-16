 package DemoTestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class DemoTestNG2 extends Base {

	WebDriver driver;
	SignUpPage signup;
	Login login;
	SoftAssert soft;
	String TESTID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browser")
		
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		
		System.out.println("Before Test-1");
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
		System.out.println("Before Class-1");
		signup=new SignUpPage(driver);
		login=new Login(driver);
				
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before Method-1");
		driver.get("https://itera-qa.azurewebsites.net/");
		
		soft=new SoftAssert();

	}
	@Test(priority=0)
	public void VerifysignupButtononSignupPage() throws InterruptedException {
		System.out.println("Test1");
		signup.ClickonSignup();
	
		String expectedURL="https://itera-qa.azurewebsites.net/UserRegister/NewUser";
		String expectedTitle="Register new user - Testautomation practice page";
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
		
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualTitle, expectedTitle,"Title is Wrong");
		
	
		soft.assertAll();
	
	}
	@Test(priority=1)
	public void VerifyMessageonSignUppage() {
		TESTID="TEST-1027";
		System.out.println("Test2");
		 String Actualmsg=signup.getTextMessage();
		 String Expectsmg="Add new user";
		
		 soft.assertEquals(Actualmsg, Expectsmg,"Text is wrong");
		 soft.assertAll();
	}
		
	@Test(priority=3)
	public void VerifyMessageonSignUpPageisSignup() {
		System.out.println("Test3");
		 String Actualmsg=signup.TextonSignup();
		 String Expectsmg="Sign Up";
		soft.assertEquals(Actualmsg, Expectsmg,"sign up text is wrong");
		soft.assertAll();
	}
	@Test(priority=2)
	public void VerifytheaccountisalreadyExit() throws IOException, InterruptedException {
		TESTID="TEST-1028";
		System.out.println("Test4");
		signup.ClickonSignup();
		
		String data=Utility.getExcelData("Sheet1", 1, 2);
		login.SendFirstName(data);
		Thread.sleep(2000);
		
		 data=Utility.getExcelData("Sheet1", 1, 3);
		login.SendSurname(data);
		Thread.sleep(2000);
		
		 data=Utility.getExcelData("Sheet1", 1, 4);
		login.SendEPost(data);
		Thread.sleep(2000);
		
		 data=Utility.getExcelData("Sheet1", 1, 5);
			login.SendMobile(data);
			Thread.sleep(2000);
		
			 data=Utility.getExcelData("Sheet1", 1, 6);
				login.SendUserName(data);
				Thread.sleep(2000);
			
				data=Utility.getExcelData("Sheet1", 1, 7);
				login.SendPassword(data);
				Thread.sleep(2000);
			
				data=Utility.getExcelData("Sheet1", 1, 8);
				login.ConfirmPassword(data);
				Thread.sleep(2000);
				
		
		
//		login.SendFirstName("SANJAY");
//		login.SendSurname("SANGALE");
//        login.SendEPost("KALYAN");
//        login.SendMobile("9988754891");
//	    login.SendUserName("sanjay@2025");
//	    login.SendPassword("Pass@1996");
//	    login.ConfirmPassword("Pass@1996");
				
	    login.clickonSubmit();
			 String Actualmsg=login.getTextUsernameAlradyExit();
			 String Expectsmg="Username already exist";
		
			 soft.assertEquals(Actualmsg, Expectsmg,"username alreagy exit text is wrong");
			 
			 soft.assertAll();
			 
		}	
			
	 

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-1");
	}
	
	@AfterClass
	public void clearObject() {
		signup=null;
		login=null;
		

	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-1");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("After Suite-1");
//	}
	
	
	
	}

