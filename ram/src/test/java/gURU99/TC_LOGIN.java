package gURU99;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//User ID :	mngr385458
//Password :	uhajytu
//Manger Id : mngr385458

public class TC_LOGIN extends Util {
	
	
	//@Parameters({"uid","password"})
	@Test(dataProvider="fetch data")
	public void logintestcase(String uid,String password)
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		invokebrowser("https://www.demo.guru99.com/v4/");
		logincred(locselector("name","uid"),uid);
		logincred(locselector("name","password"),password);
		button(locselector("name","btnLogin"));
		
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		Alert alert=driver.switchTo().alert();
		if(wait.until(ExpectedConditions.alertIsPresent()==null))
		}
		
		    	WebElement id= driver.findElement(By.xpath("//tr[@class='heading3']/td"));
				System.out.println(id.getText());
		     
		    
		
		//tr[@class='heading3']
		
		
	}

}
