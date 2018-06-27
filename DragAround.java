package com.qainfotech.automation.BasicTatocJS;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class DragAround {
	
	JavascriptExecutor js;
	
	public DragAround(JavascriptExecutor js) {
		this.js = js;
	}

	public PopUpWindows DragAndDrop() {
			js.executeScript("document.getElementById(\"dragbox\").setAttribute('style','position:relative; left:32px; top:-76px;');");
			js.executeScript("document.querySelector(\".page > a:nth-child(10)\").click();");
		    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Popup Windows");
		    return new PopUpWindows(js);

	}

}
