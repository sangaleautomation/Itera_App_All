package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	

	@FindBy (xpath="//a[text()='Create New']")
	private WebElement CREATENEW;
	
	@FindBy (xpath="//input[@id='Name']")
	private WebElement Name;
	
	@FindBy (xpath="//input[@id='Company']")
	private WebElement CompanyName;
	
	@FindBy (xpath="//input[@id='Address']")
	private WebElement Address;
	
	@FindBy (xpath="//input[@id='City']")
	private WebElement CityName;
	
	@FindBy (xpath="//input[@name='Phone']")
	private WebElement PhoneNo;
	
	@FindBy (xpath="//input[@name='Email']")
	private WebElement Email;
	
	@FindBy (xpath="//input[@value='Create']")
	private WebElement Createbutton;
	
	@FindBy (xpath="//input[@name='searching']")
	private WebElement Searching;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement SEARCH;
	
	
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
		
		

		public void ClickonCREATENEW() {
			CREATENEW.click();
		}
		
		public void SendName() {
			Name.sendKeys("sanjay and sangale");
		}
		
		public void SendCompanyName() {
			CompanyName.sendKeys("Electro pvt ltd");
		}
		
		public void SendAddress() {
			Address.sendKeys("Bombavali chawal,Mumbai");
		}
		
		public void SendCityName() {
			CityName.sendKeys("Kalyan");
		}
		
		public void SendPhoneNo() {
			PhoneNo.sendKeys("02551556");
		}
		
		public void SendEmail() {
			Email.sendKeys("suryabhai@1234gmail.com");
		}

		public void ClickonSubmitButton() {
			Createbutton.click();
		}

		public void Sendinsearch() {
			Searching.sendKeys("sanjay");
		}

		public void ClickOnsearch() {
			SEARCH.click();
		}

		
		
		}





