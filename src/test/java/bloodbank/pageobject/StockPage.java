package bloodbank.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class StockPage {

	public StockPage(WebDriver driver ) {
		
}
	//these variables are related to add's method
	
	@FindBy(xpath = "//select[@id = 'BloodGroup']")
	WebElement Bloodgroup;

	@FindBy(xpath = "//select[@id = 'BloodType']")
	WebElement bloodtype;
	
	@FindBy(xpath = "//select[@id = 'BloodFeature']")
	WebElement  vizegi;
	
	@FindBy(xpath = "//input[@name = 'Volume']")
	WebElement hajm;

	
	@FindBy(xpath = "//input[@name= 'BarCode']")
	WebElement barcode;
	
	@FindBy(xpath = "//input[@name= 'ExpireDT']")
	WebElement ExpireDate;
	
	@FindBy(xpath  = "//button[@id= 'AddStock']")
	WebElement save;
	// the end of variables for add 
	//****************************************************************
	
	//these variavle are related to return blood 
	
@FindBy(xpath = "//button[@id = 'blood-return']")
WebElement returnbutton;     //return button

@FindBy(xpath = "//tbody//td[@data-field = 'StatusString']")
WebElement status;    //vaziyat kise

@FindBy(xpath= "//input[@id = 'txtBarCode']")
WebElement barcode1;     //barcodi ke search mishe

@FindBy(xpath = "//button[@id = 'searchItems']")
WebElement search;    //search button

@FindBy(xpath= "//select[@id = 'Duoto']")
WebElement reason;     //reason for return

@FindBy(xpath = "//select[@name = 'Destination']")
WebElement destination;       //maghsad bargasht

@FindBy(xpath = "//button[text()= 'ثبت']")
WebElement save1;       


@FindBy(xpath = "//tbody//td[@data-field = 'Volume']")
WebElement record;        //record khone search shode

@FindBy(xpath = "//button[text() = 'بله']")
WebElement confirm;      //taid bargasht
// the end of variables for return blood

//these variables is are related to searchmethod
@FindBy(xpath = "//select[@id = 'drpBloodStatus']")
WebElement status1;

@FindBy(xpath = "//select[@id = 'drpBloodGroup']")
WebElement BloodGroup;

@FindBy(xpath = "//select[@id = 'drpBloodType']")
WebElement BloodType;

@FindBy(xpath = "//button[@id = 'searchItems']")
WebElement search1;
	//WebDriver driver;
	
		
		public void add(String BloodGroup,String Bloodtype,String Type,
				String volum ,
				String Barcode , String expireDate) throws InterruptedException {
			
			
			Select bloodgroup = new Select(Bloodgroup);
			bloodgroup.selectByVisibleText(BloodGroup);
			
			
			Thread.sleep(1000);
			
			
			Select BloodType =new Select(bloodtype);
			BloodType.selectByValue(Bloodtype);

			
			
			Select type =  new Select(vizegi);
			type.selectByVisibleText(Type);
			

			
			hajm.sendKeys(volum);	
			
			barcode.sendKeys(Barcode);
			
			
			ExpireDate.sendKeys(expireDate);
			
		
			save.click();
			
		}
		
		////////////////////////////////////////////////////////////////////////////////
		
		
		//this method is returning blood
		public void returning(String Barcode1 , String index , String index2) throws InterruptedException {
			
			barcode1.sendKeys(Barcode1);  
			
			search.click();
			search.sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			
			
			record.click();     //click ruye radif khun
			
			if (status.getText().matches("استفاده نشده")) {
			
				
				returnbutton.click();    
				Thread.sleep(500);
				
				Thread.sleep(1000);
				
				Select dalil = new Select(reason);
				dalil.selectByValue(index);   
				
				
				Select maghsad  = new Select(destination);
				maghsad.selectByValue(index2);
				
				save1.click();
			
				confirm.click();
			}
			else 
				returnbutton.click();
			
				//Assert.assertEquals("'برگشت خون امکان پذیر نیست", "'برگشت خون امکان پذیر نیست");
				System.out.println("'برگشت خون امکان پذیر نیست");
			
			
		}
		
		
		/////////////this methode is searching in stock////////////////
		public void search(String Status,String bgroup, String value) {
			
			Select  Se = new Select(status1);
			Se.selectByVisibleText(Status);
			
			Select BG = new Select(BloodGroup);
			BG.selectByVisibleText(bgroup);
			
			Select Btype = new Select(BloodType);
			Btype.selectByValue(value);
			
			search1.click();
			
			search1.sendKeys(Keys.PAGE_DOWN);
		}
		
		}

	



