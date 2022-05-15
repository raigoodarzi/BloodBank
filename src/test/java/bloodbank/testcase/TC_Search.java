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

public class TC_Search {
	WebDriver driver;
	
	@DataProvider(name = "search")
	public Iterator<Object[]> Provider() throws IOException{
		
	CSVReader Reader = new 	CSVReader
			(new FileReader("./src/test/resources/data/Search.csv"),',','\'',1);
	List<Object[]> MyData = new ArrayList<Object[]>();
	String nextline[];
	while((nextline = Reader.readNext())!=null) {
		MyData.add(nextline);
		
	}
	Reader.close();
	return MyData.iterator();
	
	

		
	}
  @Test(dataProvider = "search")
  public void f(String Status ,String bgroup , String value ) throws InterruptedException {
	  Thread.sleep(1000);
	  StockPage Sp = PageFactory.initElements(driver, StockPage.class);
	  Sp.search(Status, bgroup, value);
	  
	  
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
