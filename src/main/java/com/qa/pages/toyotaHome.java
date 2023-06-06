package com.qa.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.toyotaBase;

public class toyotaHome extends toyotaBase {

	
	//Page Factory
		@FindBy(xpath ="//a[contains(text(), 'Products')]")
		WebElement products;
		
		@FindBy(xpath="//div[@class='col-md-3 col-lg-2 col-sm-3 col-xs-6 flipInX animated filter-suv filter-all']//h3[contains(text(), 'Fortuner')]")
		WebElement fortuner;
		
		@FindBy(xpath="//div[@class='col-lg-2 col-md-3 col-sm-3 col-xs-6']//h3[contains(text(), 'Innova Crysta')]")
		WebElement crysta;
		
		@FindBy(xpath="//a[contains(text(), 'Test drive')]")
		WebElement testdrive;
		
		@FindBy(xpath="//div[@class='form-group']//input[@type='tel']")
		WebElement mobile;
		
		@FindBy(xpath="//div[@class='modal-content']//button[@class='close']")
		WebElement close;
		
		@FindBy(xpath="//button[@id='btnNewFortunerSubmit']")
		WebElement submit;
		
		
	
	public toyotaHome() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public void select_car()
	{
	   Actions act = new Actions(driver);
	  act.moveToElement(products).build().perform();
	
	String cared = pr.getProperty("car");
	
	if(cared.equals("fortuner"))
	{
		fortuner.click();
	}
	
	else if(cared.equals("crysta"))
	{
		crysta.click();
    }
	
	close.click();
   } 
	
	public void bookTestdrive()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		testdrive.click();
		Select sl = new Select(driver.findElement(By.xpath("//select[@id='cboNewFortunerSalutation']")));
		sl.selectByVisibleText("Ms.");
		
		driver.findElement(By.id("txtNewFortunerName")).sendKeys(pr.getProperty("tdriver"));
		mobile.sendKeys(pr.getProperty("cnumber"));
		driver.findElement(By.id("txtNewFortunerEmail")).sendKeys(pr.getProperty("mail"));
		
		Select se = new Select(driver.findElement(By.xpath("//select[@id='cboNewFortunerCity']")));
		se.selectByVisibleText(pr.getProperty("city"));
		
		Select st = new Select(driver.findElement(By.xpath("//select[@id='cboNewFortunerDealer']")));
		st.selectByVisibleText(pr.getProperty("dealer"));
		
		//driver.findElement(By.xpath("//button[@id='btnNewFortunerSubmit']")).click();
		
		JavascriptExecutor jw = (JavascriptExecutor) driver;
		jw.executeScript("arguments[0].click();", submit);
	
	}
	
}
