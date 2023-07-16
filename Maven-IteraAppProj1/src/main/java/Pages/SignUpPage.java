package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	

	@FindBy (xpath="//form//li[1]//a[1]")
	private WebElement TextMessage;
	
	@FindBy (xpath="//a[text()='Sign Up']")
	private WebElement SignUp;
	
	@FindBy (xpath="//div[@class='container body-content']//h2")
	private WebElement textMessage;
	
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String TextonSignup () {
		String text=TextMessage.getText();
		return text;
	}
	
	public void ClickonSignup () {
		SignUp.click();
	}
	
	public String getTextMessage () {
		String text=textMessage.getText();
	return text;
	
	
	
	}	
	

}