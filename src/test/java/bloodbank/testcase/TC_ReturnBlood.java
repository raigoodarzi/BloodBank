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

public class TC_ReturnBlood {
	WebDriver driver;
	
	@DataProvider(name = "return")
	public Iterator<Object[]> Provider() throws IOException{
		
		CSVReader Reader = new CSVReader
				(new FileReader("./src/test/resources/data/returnblood.csv"),',','\'',1) ;
		
		List<Object[]> MyData = new ArrayList<Object[]>();
		String [] nextline;
		while((nextline = Reader.readNext())!=null) {
			
			MyData.add(nextline);
		}
	
	
		Reader.close();
		return MyData.iterator();
		
	}
  @Test(dataProvider = "return")
  public void f(String Barcode1 , String index,String index2) throws InterruptedException {
	  Thread.sleep(1000);
	  
	  
	  StockPage Sp = PageFactory.initElements(driver, StockPage.class);
	  Sp.returning(Barcode1, index, index2);
	  
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
