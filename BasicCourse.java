package com.qainfotech.automation.BasicTatocJS;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class BasicCourse {
	
	JavascriptExecutor js ;
	
	public BasicCourse(JavascriptExecutor js) {
		this.js=js;
	}

	public GridGAte ClickOnBasicCourse() {
		js.executeScript("document.querySelector(\".page>a\").click()");
		Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"),"Grid Gate");
		return new GridGAte(js);
	}
	
	

}
