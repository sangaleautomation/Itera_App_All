package DemoTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.SignUpPage;

public class DemoClassNg {
//	WebDriver driver;
//	SignUpPage signup;
//	Login login;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
//		driver.get("https://itera-qa.azurewebsites.net/");
//		signup=new SignUpPage(driver);
//		login=new Login(driver);
		
//		signup.ClickonSignup();
	}
	@Test(priority=-2)
	public void VerifysignupButtononSignupPage() {
		System.out.println("Test1");
//		signup.ClickonSignup();
//		String expectedURL="https://itera-qa.azurewebsites.net/UserRegister/NewUser";
//		String expectedTitle="Register new user - Testautomation practice page";
//		String actualURL=driver.getCurrentUrl();
//		String actualTitle=driver.getTitle();
//		if(expectedURL.equals(actualURL)&&expectedTitle.equals(actualTitle))
//		{
//			System.out.println("Passed"); 
//		}
//		else
//		{
//			System.out.println("Failed"); 
//		}
		
	}
	@Test(priority=0)
	public void VerifyMessageonSignUppage() {
		System.out.println("Test2");
		 String Actualmsg="add th";
		 String Expectsmg="Add new user";
	
	 
	 Assert.assertEquals(Actualmsg, Expectsmg);
	}
		
	@Test(priority=3)
	public void VerifyMessageonSignUpPageisSignup() {
//		System.out.println("Test3");
//		 String Actualmsg=signup.TextonSignup();
//		 String Expectsmg="Sign Up";
//		 if(Actualmsg.equals(Expectsmg))
//		{
//			System.out.println("Passed"); 
//	    }
//		 else
//		 {
//			 System.out.println("Failed");  
//		 }
		System.out.println("Test3");
		 String Actualmsg="add th";
		 String Expectsmg="Add new user";
	
	 
	 Assert.assertEquals(Actualmsg, Expectsmg);
	}
	
	@Test(priority=4)
	public void VerifyEnterDataInFirstName() {
		System.out.println("Test4");
		
		
		}	
			
			
		
	
	 

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("After Class");
//		driver.close();
	}
	
	}


