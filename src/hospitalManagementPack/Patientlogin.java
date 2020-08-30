package hospitalManagementPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Patientlogin {
  
	  public WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost/hospital/");
  }
  @Test(priority=0)
  public void patientlogin() throws InterruptedException {
	  driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div/span/a")).click();
	  Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("dileep@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("dileep123");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
  }
  @Test(priority=1)
  public void dashBoardValidation() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Update Profile")).click();
	  Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.linkText("View Appointment History")).click();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Book Appointment")).click();
		driver.navigate().back();
		Thread.sleep(2000);
  }
  @Test(priority=2)
  public void bookAppointmentValidation() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/nav/ul/li[2]/a/div/div[2]/span")).click();
	  Thread.sleep(1000);
	  Select doc=new Select(driver.findElement(By.name("Doctorspecialization")));
	  doc.selectByIndex(1);
	  Thread.sleep(1000);
	  driver.findElement(By.id("doctor")).sendKeys("Tharun");
	  Thread.sleep(1000);
	  driver.findElement(By.id("fees")).sendKeys("100");
	  Thread.sleep(1000);
	  driver.findElement(By.name("appdate")).sendKeys("2020-08-29");
	  Thread.sleep(1000);
	  driver.findElement(By.id("timepicker1")).sendKeys("4:30 PM");
	  Thread.sleep(1000);
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  
  }
  @Test(priority=3)
  public void appointmentHistoryValidation() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/nav/ul/li[3]/a/div/div[2]/span")).click();
  }
  @Test(priority=4)
  public void MedicalHistoryValidation() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/nav/ul/li[4]/a/div/div[2]/span")).click();
  }

  

}
