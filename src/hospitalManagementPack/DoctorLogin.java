package hospitalManagementPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DoctorLogin {
	public WebDriver driver;
	 @BeforeTest
	  public void beforeClass() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost/hospital/");
	  }
  @Test(priority = 0)
  public void doctorslogin() throws InterruptedException {
	  driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div[2]/div/span/a")).click();
	  Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("doctor@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("P@ssc0de");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
  }
  @Test(priority = 1)
  public void dashBoardVerification() throws InterruptedException  {
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Update Profile")).click();
	  //driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div/div/p/a")).click();
	  System.out.println("My profile page is shown and editable");
	  Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.linkText("View Appointment History")).click();
		//driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div/div/p/a")).click();
		System.out.println("My appointment history page is shown");
		 Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
  }
  @Test(priority = 2)
  public void AppointmentHistoryValidation () throws InterruptedException {
	  
		Thread.sleep(1000);
		
		List<WebElement> AppointmentHistory = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		AppointmentHistory.get(1).click(); // Level 1 click - AppointmentHistory
		System.out.println("Appointment History page is shown");
		Thread.sleep(1000);
  }
  @Test(priority = 3)
  public void PatientValidation () throws InterruptedException {
	  
		Thread.sleep(1000);
		
		List<WebElement> patients = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		patients.get(2).click(); // Level 1 click - Patient
		Thread.sleep(1000);
		
		List<WebElement> addpatients = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		addpatients.get(0).click(); // Level 2 click - Patients Sub Menu - Add patients	
		System.out.println("New patients details addable in this page");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div/div/div/div[2]/form/div[1]/input")).sendKeys("Devu");
	    driver.findElement(By.name("patcontact")).sendKeys("9656751583");
	    Thread.sleep(2000);
	    driver.findElement(By.id("patemail")).sendKeys("devu1@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div/div/div/div[2]/form/div[4]/div/label[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.name("pataddress")).sendKeys("chandanasadanam");
	    Thread.sleep(2000);
	    driver.findElement(By.name("patage")).sendKeys("10");
	    Thread.sleep(2000);
	    driver.findElement(By.name("medhis")).sendKeys("Consistent head ache");
	    Thread.sleep(2000);
	    driver.findElement(By.id("submit")).click();
	    Thread.sleep(3000);
	    
	    
		List<WebElement> patients1 = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		patients1.get(2).click(); // Level 1 click - Patient	
		Thread.sleep(2000);
		
		List<WebElement> managepatient = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		managepatient.get(1).click(); // Level 2 click - Patients Sub Menu - Manage patients
		System.out.println("Patients details are shown in this page");
		Thread.sleep(1000);
		driver.findElement(By.id("searchdata")).sendKeys("devu");
		Thread.sleep(2000);
  }
  

  @Test(priority = 4)
  public void searchValidation() throws InterruptedException {
	  Thread.sleep(2000);
	 //driver.findElement(By.xpath("///*[@id=\"sidebar\"]/div/nav/ul/li[4]/a/div/div[2]/span")).click();
	  List<WebElement> search = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
	  search.get(3).click(); // Level 1 click - Search
	  System.out.println("Patients detais are searcheble in this page");
		Thread.sleep(1000);
  }
  @Test(priority = 5)
  public void DoctorLogout() throws InterruptedException {
	  Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/header/div[2]/ul/li[2]/a/span/i")).click();
	 driver.findElement(By.linkText("Log Out")).click();
  }


}
