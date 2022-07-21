package Assignmentss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsingDP {
	WebDriver d ;
	String baseURL=("https://opensource-demo.orangehrmlive.com/");
	
	@BeforeTest
 public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\selenium-java-4.3.0\\chromedrivers\\chromedriver.exe");
	    d= new ChromeDriver();
		d.get(baseURL);
		d.manage().window().maximize();
		
	}
	@AfterTest
	 public void Shutdown() {
		 d.close();
	 } 
 
	@Test
	@Parameters({"usrname" ,"Password"})
	public void accountCreation(String usrName, String PassWord) throws InterruptedException {
		
			    WebElement UserName = d.findElement(By.id("txtUsername"));
				UserName.sendKeys(usrName);
				WebElement password = d.findElement(By.name("txtPassword"));
			    password.sendKeys(PassWord);
			    WebElement login = d.findElement(By.name("Submit"));
	            login.click();

	        String actualurl=d.getCurrentUrl();
	   		System.out.println(actualurl);
	   		String expectedurl="https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
	   		if(actualurl.equalsIgnoreCase(expectedurl)) {
	   			  System.out.println("The login is Failed");
	   		}
	   		else {
	   			System.out.println("The Login is Successfull");
	   		}
	   		
	   	     d.findElement(By.partialLinkText("Admin")).click();
	   	     d.findElement(By.name("searchSystemUser[userName]")).sendKeys("2525093");
	   	     d.findElement(By.name("searchSystemUser[userType]")).sendKeys("Admin");
	   	     d.findElement(By.name("searchSystemUser[employeeName][empName]")).sendKeys("Yadati Shankar");
	   	     d.findElement(By.name("searchSystemUser[status]")).sendKeys("Enabled");
	   	     Thread.sleep(3000);
	   	     d.navigate().back();
	   	     
	   		Thread.sleep(3000);
	   		
	   		d.findElement(By.partialLinkText("Leave")).click();
	   		Thread.sleep(1000);

	   		
	   		d.findElement(By.partialLinkText("PIM")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("Time")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("Recruitment")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("My Info")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("Directory")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("Dashboard")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("Maintenance")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.partialLinkText("Buzz")).click();
	   		Thread.sleep(1000);
	   		
	   		d.findElement(By.id("MP_link")).click();
	   		Thread.sleep(1000);
	   		d.navigate().back();
	   		
	   		
	   		
	   		d.findElement(By.partialLinkText("Welcome")).click();
	   		Thread.sleep(3000);
			d.findElement(By.linkText("Logout")).click();
	   		}  
	@DataProvider(name="DP")
	public Object[][] dataObject(){
		
		return new Object[][] {
			{"Shankar","Shankar123"},{"admin","admin"},{"Admin","admin123"},{"Admin","admin123"}
		};
			
	}
}