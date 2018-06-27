package com.qainfotech.automation.BasicTatocJS;

import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class GridGAte {
	
	JavascriptExecutor js;
	
	public GridGAte(JavascriptExecutor js) {
		this.js = js;
	}

	public FrameDungeon ClickOnGreenBox() {
		js.executeScript("document.getElementsByClassName(\"greenbox\")[0].click();");	
		Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Frame Dungeon");
		return new FrameDungeon(js);
	}
	
	

}
