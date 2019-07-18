package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.login;
import pages.homePage;


public class us1 {
	public WebDriver driver= new ChromeDriver();
	
	String driverPath = "C:\\chromedriver.exe"; //Chrome driver path
	String webUrl = "http://localhost:8989/BankWebApp/login";
	
    @BeforeTest
    public void setup(){        	
	      System.out.println("Launching Chrome Browser."); 
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get(webUrl);
	      driver.manage().window().maximize();
    }
 
    
    @Test(priority = 0)
    public void signIn() {
    	String username = "Jake";
    	String password = "Jake";
    	login objLogin= new login(driver);
        objLogin.SignIn(username, password);  

    }
    
    @Test(priority = 1)
    public void logout() {
    	homePage objHome= new homePage(driver);
        objHome.Logout();

    }
    
    @AfterTest
    public void quit(){        	
  	      driver.close();
  }
    
}
