package bloodbank.testcase;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import bloodbank.pageobject.StockPage;

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

public class TC_InsertToStock {
	WebDriver driver;
	
	@DataProvider(name = "Insert")
	public Iterator<Object[]> Provider() throws IOException{
		CSVReader Reader = new CSVReader
				(new FileReader("./src/test/resources/data/inserttostock.csv"),',','\'',1);
		List<Object[]> MyData = new ArrayList<Object[]>();
		String [] NextLine;
		while((NextLine =Reader.readNext())!=null) {
			MyData.add(NextLine);
			
		}
		
		Reader.close();
		return MyData .iterator();
	}
  @Test(dataProvider = "Insert")
  public void f(String BloodGroup,String Bloodtype ,String Type, 
		  String volum,String Barcode, String expireDate) throws InterruptedException {
	  
	  Thread.sleep(2000);
	 
	  
	  StockPage insert  = PageFactory.initElements(driver, StockPage.class);
	  insert.add(BloodGroup, Bloodtype, Type, volum, Barcode, expireDate);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://192.168.5.19:8020/stock");
	  driver.manage().window().maximize();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
