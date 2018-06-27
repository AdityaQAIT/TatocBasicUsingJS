package com.qainfotech.automation.BasicTatocJS;

import java.awt.dnd.DragSourceAdapter;

import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class FrameDungeon {
	JavascriptExecutor js;
	
	public FrameDungeon(JavascriptExecutor js) {
		this.js=js;
	}

	public DragAround MatchColor() {
		
		String Box_1 = (String)js.executeScript("return document.getElementById(\"main\").contentWindow.document.getElementById(\"answer\").className")	;	
	    System.out.println(Box_1);
	    String Box_2 = "";
	    while(!Box_1.equals(Box_2)) {
	    	js.executeScript("document.getElementById(\"main\").contentWindow.document.querySelector(\"body > center:nth-child(1) > a:nth-child(7)\").click();");
	        Box_2=(String) js.executeScript("return document.getElementById(\"main\").contentWindow.document.getElementById(\"child\").contentWindow.document.getElementById(\"answer\").className");
	    }
	    js.executeScript("document.getElementById(\"main\").contentWindow.document.querySelector(\"body > center:nth-child(1) > a:nth-child(9)\").click();");
	    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Drag Around");
	    return new DragAround(js);
	    
	}

}
