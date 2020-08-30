package hospitalManagementPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminLogin {
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost/hospital/");

	}

	@Test(priority = 0)
	public void login() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div[2]/div/span/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		
	}

	@Test(priority = 1)
	public void dashboardValidation() throws AWTException, InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div/div/p/a")).click();//
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div/div/p/a")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[3]/div/div/p/a[2]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[4]/div/div/p/a")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[5]/div/div/p/a[2]")).click();
		Thread.sleep(1000);
		driver.navigate().back();

	}

	@Test(priority = 2)
	public void DoctorsValidation() throws InterruptedException  {
		// Method #1 using cssSelector & findElements

		Thread.sleep(2000);
		
		List<WebElement> doc = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		doc.get(1).click(); // Level 1 click - Doctors
		Thread.sleep(1000);
		
		List<WebElement> docspe = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		docspe.get(0).click(); // Level 2 click - Doctors Sub Menu - Doctor Specialization				
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div/div/div/div[2]/form/div/input")).sendKeys("Dentist");
		  driver.findElement(By.name("submit")).click();
	
	
		
		List<WebElement> doc1 = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		doc1.get(1).click(); // Level 1 click - Doctors	
		Thread.sleep(1000);
		
		List<WebElement> add_doc = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		add_doc.get(1).click(); // Level 2 click - Doctors Sub Menu - Add doctor
		Thread.sleep(1000);
		Select  doctor=new Select(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div/div/div/div[2]/form/div[1]/select")));
	    doctor.selectByIndex(6);
	    Thread.sleep(1000);
	    driver.findElement(By.name("docname")).sendKeys("Sree");
	    Thread.sleep(1000);
	    driver.findElement(By.name("clinicaddress")).sendKeys("Malavila");
	    Thread.sleep(1000);
	    driver.findElement(By.name("docfees")).sendKeys("100");
	    Thread.sleep(1000);
	    driver.findElement(By.name("doccontact")).sendKeys("9854454524");
	    Thread.sleep(1000);
	    driver.findElement(By.id("docemail")).sendKeys("sree53@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.name("npass")).sendKeys("sree53");
	    Thread.sleep(1000);
	    driver.findElement(By.name("cfpass")).sendKeys("sree53");
	    Thread.sleep(1000);
	    driver.findElement(By.id("submit")).click();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
		
	    List<WebElement> doc2 = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		doc2.get(1).click(); // Level 1 click - Doctors
		Thread.sleep(1000);
		
		List<WebElement> man_doc = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		man_doc.get(2).click(); // Level 2 click - Doctors Sub Menu - Manage Doctor
		Thread.sleep(1000);	
	}
	@Test(priority = 3)
	public void usersVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> users = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		users.get(2).click(); // Level 1 click - Users
		Thread.sleep(1000);
		
		List<WebElement> man_use = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		man_use.get(0).click(); // Level 2 click - users Sub Menu - Manage Users
		Thread.sleep(1000);
	}
	@Test(priority = 4)
	public void patientsVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> patients = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		patients.get(3).click(); // Level 1 click - patients
		Thread.sleep(1000);
		
		List<WebElement> patientsmenu = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		patientsmenu.get(0).click(); // Level 2 click - patients Sub Menu - Manage patients
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/nav/ul/li[5]/a/div/div[2]/span")).click();
	}
	@Test(priority = 5)
	public void appointmentVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> appointment_his = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		appointment_his.get(4).click(); // Level 1 click - Appointment History
		Thread.sleep(1000);
	}
	@Test(priority = 6)
	public void contactsVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		List<WebElement> queries = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		queries.get(5).click(); // Level 1 click - contact us queries
		Thread.sleep(1000);
		
		List<WebElement> unread_queries = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		unread_queries.get(0).click(); // Level 2 click - queries Sub Menu - Unread queries
		Thread.sleep(1000);
		
		List<WebElement> queries1 = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		queries1.get(5).click(); // Level 1 click - contact us queries
		Thread.sleep(1000);
		
		List<WebElement> readquary = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		readquary.get(1).click(); // Level 2 click - queries Sub Menu - read queries
		Thread.sleep(1000);
	}
	@Test(priority = 7)
	public void doctorSectionVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> docsession_log = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		docsession_log.get(6).click(); // Level 1 click - Doctor session log
		Thread.sleep(1000);
	}
	@Test(priority = 8)
	public void userSectionVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> usesession_log = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		usesession_log.get(7).click(); // Level 1 click - User session log
		Thread.sleep(1000);
	}
	@Test(priority = 9)
	public void reportsVlidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> report = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		report.get(8).click(); // Level 1 click - Reports
		Thread.sleep(1000);
		
		List<WebElement> bwdatareport = driver.findElements(By.cssSelector("ul.main-navigation-menu>li.open>ul.sub-menu>li"));
		bwdatareport.get(0).click(); // Level 2 click - Reports Sub Menu - B/W dates report
		Thread.sleep(1000);
		driver.findElement(By.id("fromdate")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("todate")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
	}
	@Test(priority = 10)
	public void patientSearchValidation() throws AWTException, InterruptedException {
		// Method #1 using cssSelector & findElements
		
		List<WebElement> Patient_search = driver.findElements(By.cssSelector("ul.main-navigation-menu>li"));
		Patient_search.get(9).click(); // Level 1 click - Patient search
		Thread.sleep(1000);
	}
	@Test(priority = 11)
	public void logoutValidation() throws AWTException, InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/header/div[2]/ul/li[2]/a/span/i")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/header/div[2]/ul/li[2]/ul/li[2]/a")).click();
	Thread.sleep(1000);
	}

		
		
	

	

}
