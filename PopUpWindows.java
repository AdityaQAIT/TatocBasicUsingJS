package com.qainfotech.automation.BasicTatocJS;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class PopUpWindows {
	
	JavascriptExecutor js;
	
	public PopUpWindows(JavascriptExecutor js) {
		this.js = js;
		
	}

	public CookieHandling ClickProceedAfterEnteringCorrectValuesInPopUpWindow(WebDriver driver) {
        js.executeScript("document.querySelector('body > div > div.page > a:nth-child(4)').click()");
	    String parentwindow = driver.getWindowHandle();
	    String subWindow = null;
	    Set<String> windows = driver.getWindowHandles();
	    Iterator itr = windows.iterator();
	    while(itr.hasNext()){
	    	subWindow = (String) itr.next();
	    }
	    driver.switchTo().window(subWindow);
	    js.executeScript("document.getElementById('name').value='abc'");
	    js.executeScript("document.getElementById('submit').click()");
	    driver.switchTo().window(parentwindow);
        js.executeScript("document.querySelector('body > div > div.page > a:nth-child(6)').click()");
	    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Cookie Handling");
       return new CookieHandling(js);
	}

}
