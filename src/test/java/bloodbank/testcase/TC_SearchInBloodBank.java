package bloodbank.testcase;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import bloodbank.pageobject.BloodBankCheck;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class TC_SearchInBloodBank {
	WebDriver driver;
	@DataProvider(name = "SearchInBloodbank")
	public Iterator<Object[]> Provider() throws IOException{
		
		CSVReader Reader = new CSVReader(new FileReader("./src/test/resources/data/SearchInBlood.csv"),',','\'',1);
		List<Object[]> MyData = new ArrayList<Object[]>();
		String nextline[];
		while((nextline = Reader.readNext())!=null) {
			MyData.add(nextline);
			
		}
		
		Reader.close();
		return MyData.iterator();
		
	}
  @Test(dataProvider = "SearchInBloodbank")
  public void f(String value , String value1) throws InterruptedException {
	  Thread.sleep(1000);
	  
	 
	  BloodBankCheck SB = PageFactory.initElements(driver, BloodBankCheck.class);
	  SB.search(value, value1); 
	  
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
