package keyword.driven.framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excel.Excel_Class;
import jxl.read.biff.BiffException;


public class Driven {

	WebDriver driver;
	@Test
	public void f() throws BiffException, IOException
	{
		
		Excel_Class.excelconnection("keyword.xls", "Sheet1");
		for(int i=1;i<Excel_Class.rcount();i++)
		{
			
			String loctype=Excel_Class.readdata(2, i);
			String values=Excel_Class.readdata(3, i);
			String keywords=Excel_Class.readdata(4, i);
			String input=Excel_Class.readdata(5, i);
			
			switch(keywords)
			{
			case "textbox":
				driver.findElement(LocatorReprository.values(loctype, values)).sendKeys(input);
				break;
			case "Btn":
				driver.findElement(LocatorReprository.values(loctype, values)).click();
				break;
			case "wait":
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
			default:
				break;
			}
		}
	}
	
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\fireFox\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://srssprojects.in/home.aspx");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
}
