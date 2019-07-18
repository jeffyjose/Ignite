package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage{

	private WebDriver driver;
	private WebDriverWait wait;
	
	public homePage(WebDriver driver) {
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='Accounts']")
	private WebElement titleAccounts;
	
	@FindBy(xpath = "//p[@class='navbar-text navbar-right']//child::a")
	private WebElement lnkLogout;
	
	@FindBy(xpath = "//th[text()='Account number']")
	private WebElement lblAccountNumber;
	
	@FindBy(xpath = "//th[text()='Balance']")
	private WebElement lblBalance;

	public void Logout() {
		  wait.until(ExpectedConditions.visibilityOf(lblAccountNumber));
		  wait.until(ExpectedConditions.visibilityOf(lblBalance));
		  System.out.println("User Balance is displayed");
		  wait.until(ExpectedConditions.visibilityOf(lnkLogout));	
		  lnkLogout.click();		
	      System.out.println("User is successfully logged out"); 
	}

}