package PackageB;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.DashboardPage;
import Pages.Login;
import Pages.LoginPage;
import Pages.SignUpPage;



public class TestClass {
	
	public static void main(String []args) {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://itera-qa.azurewebsites.net/");
			
		
		SignUpPage signup=new SignUpPage(driver);
		signup.TextonSignup();
		signup.ClickonSignup();
		signup.getTextMessage();
		
		Login login=new Login(driver);
//		login.SendFirstName();
//		login.SendSurname();
//		login.SendEPost();
//		login.SendMobile();
//		login.SendUserName();
//		login.SendPassword();
//		login.ConfirmPassword();
		login.clickonSubmit();
		login.getTextUsernameAlradyExit();
		login.clickonlogin();
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.VerifyLoginText();
//		loginpage.SendUserName1();
//		loginpage.SendPassword1();
		loginpage.ClickonLogin1();
		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.ClickonCREATENEW();
		dashboard.SendName();
		dashboard.SendCompanyName();
		dashboard.SendAddress();
		dashboard.SendCityName();
		dashboard.SendPhoneNo();
		dashboard.SendEmail();
		dashboard.ClickonSubmitButton();
		dashboard.Sendinsearch();
		dashboard.ClickOnsearch();
		
		
	}	
		
}


