package Pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy (xpath="//input[@name='FirstName']")
	private WebElement FirstName;
	
	@FindBy (xpath="//input[@id='Surname']")
	private WebElement Surname;
	
	@FindBy (xpath="//input[@id='E_post']")
	private WebElement EPost;
	
	@FindBy (xpath="//input[@id='Mobile']")
	private WebElement Mobile;
	
	@FindBy (xpath="//input[@id='Username']")
	private WebElement UserName;
	
	@FindBy (xpath="//input[@id='Password']")
	private WebElement Password;
	
	@FindBy (xpath="//input[@id='ConfirmPassword']")
	private WebElement ConfirmPassword;
	
	@FindBy (xpath="//input[@id='submit']")
	private WebElement Submit;
	
	@FindBy (xpath="//div[10]//label")
	private WebElement RegistrationAlreadyExitText;
	
	@FindBy (xpath="//a[text()='Login']")
	private WebElement LOGIN;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void SendFirstName (String FIRSTNAME) {
		FirstName.sendKeys(FIRSTNAME);
	}
	
//	public void SendFirstName () {
//		FirstName.sendKeys("SANJAY");
//	}
//	
	
	public void SendSurname (String SURNAME) {
		Surname.sendKeys(SURNAME);	
	}
	
	public void SendEPost (String EPOST) {
		EPost.sendKeys(EPOST);
	}
	
	public void SendMobile (String MOBNO) {
		Mobile.sendKeys(MOBNO);
	}
	
	public void SendUserName (String USERNAME) {
		UserName.sendKeys(USERNAME);
	}
	
	
	public void SendPassword (String PASSWORD) {
		Password.sendKeys(PASSWORD);
	}
		
	public void ConfirmPassword (String CONFIRM_PASSWORD) {
		ConfirmPassword.sendKeys(CONFIRM_PASSWORD);
	}
		
	public void clickonSubmit () {
		Submit.click();
	}
	
	public String getTextUsernameAlradyExit () {
		String text=RegistrationAlreadyExitText.getText();
		return text;
	}

	
	public void clickonlogin () {
		LOGIN.click();
	}

	
	
	
	
	
	
}
