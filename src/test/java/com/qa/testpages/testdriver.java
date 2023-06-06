package com.qa.testpages;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.toyotaBase;
import com.qa.pages.toyotaHome;

public class testdriver extends toyotaBase {
	
	public toyotaHome yo;
	
	public testdriver()
	{
		super();
	}
	
	

	@BeforeMethod
	public void Launch() throws IOException
	{
		System.out.println(pr.getProperty("car"));
		initialize();
	}
	
	@Test(priority=1)
	public void testone() throws IOException 
	{
	    yo = new toyotaHome();
	    yo.select_car();
	    yo.bookTestdrive();
    }
	

}

