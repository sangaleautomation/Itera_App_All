package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	@FindBy (xpath="//form[@action='/Login/Authorize']//tr//td[2]")
	private WebElement LOGINText;
	

	@FindBy (xpath="//input[@id='Username']")
	private WebElement UserName1;
	
	
	@FindBy (xpath="//input[@id='Password']")
	private WebElement Password1;
	
	
	@FindBy (xpath="//input[@value='Login']")
	private WebElement Login1;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	

	public String VerifyLoginText() {
		String text=LOGINText.getText();
		return text;
	}
		
		

		public void SendUserName1(String USERNAME1) {
			UserName1.sendKeys(USERNAME1);
		}
		

		public void SendPassword1(String PASSWORD1) {
			Password1.sendKeys(PASSWORD1);
		}
		

		public void ClickonLogin1() {
			Login1.click();
		}
		
		
	
		
	}
	


	
	
	


