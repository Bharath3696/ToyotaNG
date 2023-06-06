package com.qa.base;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.io.File;

public class toyotaBase {
	
	public static WebDriver driver;
    public static Properties pr;
    
    //public JavascriptExecutor js;
    
    //public static toyotaBase bk;
    
    public toyotaBase() 
    {
    	//File file = new File("A:\\eclipse prgrams\\toyota\\src\\main\\java\\com\\qa\\config\\configuration.properties");
    	try 
    	{
    	pr = new Properties();
    	FileInputStream ip = new FileInputStream("A:\\eclipse prgrams\\toyota\\src\\main\\java\\com\\qa\\config\\configuration.properties");
    	pr.load(ip);
    	
    	System.out.println(pr.getProperty("browser")+" default constructor implemented");
    	}
    	
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    public static void initialize() throws IOException 
	{
	
	String browserName = pr.getProperty("browser");
	System.out.println(browserName);
	
	if(browserName.equals("chrome"))
	{ 
	System.setProperty("webdriver.chrome.driver", "A:\\crm\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	
	else if(browserName=="edge")
	{
		System.setProperty("webdriver.edge.driver", "A:\\crm\\chromedriver_win32\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(pr.getProperty("url"));
	
	}   

}
