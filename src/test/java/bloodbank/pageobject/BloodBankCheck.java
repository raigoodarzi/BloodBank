package bloodbank.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BloodBankCheck {
	
	////these variables is related to search in bloodbank////
	@FindBy(xpath = "//select[@name = 'UrgencyRequest']")
	WebElement foriyat;

	@FindBy(xpath = "//select[@id= 'Status']")
	WebElement status;

	@FindBy(xpath = "//button[@id= 'simpleSearch']")
	WebElement search;
	/////// the end of variales for searching in bloodbank //////
	
	
	///// these variables is related to CanselDelivery/////
	@FindBy(xpath = "//tbody//td[@data-field = 'BloodGroup']")
	WebElement bloodgroup;
	
	@FindBy(xpath = "//button[@id = 'btnProductReturn']")
	WebElement productreturn;
	
	@FindBy(xpath = "//tbody//td[@data-field= 'Status']")
	WebElement Status;
	
	
	@FindBy(xpath = "//button[text() ='بله']")
	WebElement confirm;
	
	/////////////////these variables is related to sending product /////////////
	
	@FindBy(xpath = "//tbody//td[@data-field = 'BloodGroup'][1]")
	WebElement BloodGroup;
	
	@FindBy(xpath = "//tbody//tr/td[@data-field = 'Status'][1]")
	WebElement status1;
	
	@FindBy(xpath = "//tbody//tr/td[@data-field = 'DTUse'][1]")
	WebElement DtUse;
	
	@FindBy(xpath = "//button[@id = 'btnProductDelivery']")
	WebElement SendProduct;
	
	@FindBy(xpath ="//button[@id ='ConfirmDelivery']" )
	WebElement ConfirmDelivery;
	
	
	@FindBy(xpath = "//button [text() = 'خیر']")
	WebElement cancel;
	
	
	@FindBy(xpath = "//button[@type=  'button' and @data-dismiss='modal']")
	WebElement Close;
	
	
	@FindBy(xpath = "//*[@class = 'alert-text-epd']")
	WebElement Alert;
	
	@FindBy(xpath = "//button[text() = 'بله']")
	WebElement Confirm;
	
	@FindBy(xpath = "//div[text()= 'ثبت اطلاعات ذوب فرآورده']")
	WebElement panelheading;
	
	WebDriver driver ;
	/////// the end of variables for sending product   ////// 
	
	////// these variables is related to Tahvil khoon ////
	@FindBy(xpath = "//tbody//td[@class ='text-center' ][4]")
	WebElement bloodtype;
	
	@FindBy(xpath = "//tbody//td[@data-field='Status' ][1]")
	WebElement status2;
	
	@FindBy(xpath = "//button[@id = 'RegisterBloodBankInfo']")
	WebElement SabtEtelat;
	
	////////  the end of variales for tahvil ////////////
	
	///// these variables is related to history///////
	
	@FindBy(xpath = "//button[@id = 'btnRecordsPatient']")
	WebElement savabegh;
	
	@FindBy(xpath = "//span[@class = 'advanced-search']//i") 
	WebElement AdvancedSearch;
	
	@FindBy(xpath = "//input[@id = 'BookNo']")
	WebElement BatariNo;
	
	
	
	
	
	
	
	public BloodBankCheck(WebDriver driver) {     //constructor method
		
		this.driver = driver;
	}
	//////////////  this method written for searching in bloodbank //////
	public void search(String value , String value1) throws InterruptedException {
		
		Select select = new Select(foriyat);
		select.selectByValue(value);
		
		Thread.sleep(1000);
		
		Select select1 = new Select(status);
		select1.selectByValue(value1);
		
		search.click();
		
		
	}
	////////////   ***************************////////////////////////
	
	/////// this methode is canceling delivery //////////////
public void  canceling() throws InterruptedException {
	
		Thread.sleep(2000);
	JavascriptExecutor jse = (JavascriptExecutor) driver;     
	jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");	
	
		String status = Status.getText();
		Thread.sleep(3000);
		BloodGroup.click();
		
		if (status.matches("ارسال شده")) {
			productreturn.click();
			Thread.sleep(1000);
			confirm.click();
		}
		else {
						System.out.println("Nooooo");
					
		}
	}
	/////////////////**************************////////////


public void tahvil() {                        // for tahvil khoon 
	bloodtype.click();
	if (status2.getText().matches("درخواست شده") ) {
		
		SabtEtelat.click();
	}
	else 
		System.out.println("Unavailble");
}

///////////////////******************////////////////////
public void ersal () throws InterruptedException {   /// this method  is for sending product
	
	
	
	BloodGroup.click();
	
	Thread.sleep(1000);
	
	if (status1.getText().matches("رزرو شده")) {

		SendProduct.click();

			Thread.sleep(2000);
		ConfirmDelivery.click();
		Thread.sleep(1000);
		Confirm.click();
		
}
	else {
		System.out.println("222");
		BloodBankCheck BC = PageFactory.initElements(driver, BloodBankCheck.class);
		BC.tahvil();
	}
}

/////////////////////***********************////////////////

public void History(String bastari) throws InterruptedException {
	
	AdvancedSearch.click();
	Thread.sleep(1000);
	BatariNo.sendKeys(bastari);
	Thread.sleep(1000);
	
	search.click();
	
	Thread.sleep(6000);
	
	bloodgroup.click();

	Thread.sleep(1000);
	savabegh.click();
	
	Thread.sleep(8000);
	
	Close.click();
}

}
