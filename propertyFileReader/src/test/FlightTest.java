package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import propertyFileReader.ConfigReader;

public class FlightTest {

	public static void main(String[] args) throws Exception 
	{
		ConfigReader config=new ConfigReader();
		System.setProperty("webdriver.chrome.driver",config.getbrowserpath());
		WebDriver driver=new ChromeDriver();
		driver.get(config.geturl());
		driver.findElement(By.name("userName")).sendKeys(config.getusername());
		driver.findElement(By.name("password")).sendKeys(config.getpassword());
        driver.findElement(By.name("submit")).click();
        //screenshot 
        TakesScreenshot src=(TakesScreenshot)driver;
        File source=src.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(config.getscreenshot()));
        
        //html reports
        ExtentHtmlReporter h1=new ExtentHtmlReporter(config.gethtmlreport());
        ExtentReports h2=new ExtentReports();
        h2.attachReporter(h1);
        ExtentTest h3=h2.createTest("login of flight demo");
        h3.log(Status.PASS,"test case is passed");
        h2.flush();
        System.out.println("done");
        
        
	}

}
