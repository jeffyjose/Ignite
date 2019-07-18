package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login{

	private WebDriver driver;
	private WebDriverWait wait;
	
	public login(WebDriver driver) {
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//h1[text()='Accounts']")
	private WebElement titleAccounts;
	
	public void compareStrings(String actual, String expected, String Value) {
		if(actual.equals(expected)){
			System.out.println("Verification Pass- "+Value);
		}
		else {
			System.out.println("Verification Fail- "+Value);
		}				
	}
	
	/*
	 * Verify Login page
	 */
	
	public void SignIn(String username, String password) {
		  wait.until(ExpectedConditions.visibilityOf(btnLogin));	
		  txtUserName.sendKeys(username);
		  txtPassword.sendKeys(password);
		  btnLogin.click();		
		  wait.until(ExpectedConditions.visibilityOf(titleAccounts));
	      System.out.println("User is successfully logged in"); 
	}		
}
