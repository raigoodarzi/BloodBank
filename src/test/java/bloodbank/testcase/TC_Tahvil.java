package bloodbank.testcase;

import org.testng.annotations.Test;

import bloodbank.pageobject.BloodBankCheck;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class TC_Tahvil {
 WebDriver driver;
  @Test
  
  public void f() throws InterruptedException {
	  Thread.sleep(3000);
	  BloodBankCheck BC = PageFactory.initElements(driver, BloodBankCheck.class);
	  BC.tahvil();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://192.168.5.19:8020/bloodbankcheck");
	  driver.manage().window().maximize();
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
