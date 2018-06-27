package com.qainfotech.automation.BasicTatocJS;

import java.beans.Transient;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.session.ChromeFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestClass {
	
	WebDriver driver;
	JavascriptExecutor js;
	BasicCourse basicCourse;
	GridGAte gridgate;
	FrameDungeon frameDungeon;
	DragAround dragArround;
	PopUpWindows popUpWindows;
	CookieHandling cookieHandling;
	
	
	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","//home//qainfotech//Downloads//chromedriver");
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;
		driver.get("http://10.0.1.86/tatoc/");
		basicCourse = new BasicCourse(js);
	}
	
	@Test
	public void ClickOnBasicCourseLink() {
		gridgate=basicCourse.ClickOnBasicCourse();
	}
	
	@Test(dependsOnMethods= {"ClickOnBasicCourseLink"}) 
	public void ClickOnGreenBoxElement()
	{
		frameDungeon=gridgate.ClickOnGreenBox();
	}
	
	@Test(dependsOnMethods= {"ClickOnGreenBoxElement"}) 
	public void MatchColorInBoxes() {
		dragArround=frameDungeon.MatchColor();
	}
	
	@Test(dependsOnMethods= {"MatchColorInBoxes"})
	public void DragAndDropBoxToCorrectDropBox() {
		popUpWindows=dragArround.DragAndDrop();
		
	}
	
	@Test(dependsOnMethods= {"DragAndDropBoxToCorrectDropBox"})
	public void PopupWindows() {
		cookieHandling=popUpWindows.ClickProceedAfterEnteringCorrectValuesInPopUpWindow(driver);
	}
	
	@Test(dependsOnMethods= {"PopupWindows"})
	public void GemerateTokenAndAddItInTheFormOfCookie() {
		cookieHandling.AddCookie();
	}

}
