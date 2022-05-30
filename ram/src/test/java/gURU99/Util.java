package gURU99;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Util {
	RemoteWebDriver driver;
	
	
	
	public void invokebrowser(String url)
	{
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public WebElement locselector(String loc,String locvalue)
	{
		switch(loc){
		case "id" : return driver.findElement(By.id(locvalue));
		case "classname" : return driver.findElement(By.className(locvalue));
		case "linktext" : return driver.findElement(By.linkText(locvalue));
		case "xpath": return driver.findElement(By.xpath(locvalue));
		case "partial": return driver.findElement(By.partialLinkText(locvalue));
		case "name" : return driver.findElement(By.name(locvalue));
		}
		return null;
	}


	public void logincred(WebElement ele,String data) {
		ele.clear();
		ele.sendKeys(data);

		}

	public void button(WebElement ele)
	{
		ele.click();
	}

	@DataProvider(name="fetch data")
	public String[][] data() throws IOException
	{
		XSSFWorkbook wb= new XSSFWorkbook("./Data/testcase.xlsx");
		XSSFSheet sheet= wb.getSheet("Sheet2");
		int row=sheet.getLastRowNum();
		int column=sheet.getRow(0).getLastCellNum();
		
		
		
		String data[][]=new String[row][column];
		for(int i=1;i<=row;i++)
		{
			XSSFRow mainrow=sheet.getRow(i);
			for(int j=0;j<column;j++)
			{
				XSSFCell maincell=mainrow.getCell(j);
				String value=maincell.getStringCellValue();
				data[i-1][j]=value;
			}
		}
		
		
		return data;
	}
}
