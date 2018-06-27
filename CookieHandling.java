package com.qainfotech.automation.BasicTatocJS;

import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class CookieHandling {
	
	JavascriptExecutor js;
	
	public CookieHandling(JavascriptExecutor js) {
		this.js = js;
	}

	public void AddCookie() {
		String token=generateToken();
		token = token.substring(token.indexOf(":")+2);
		String JScommand="document.cookie = 'Token="+token+"';";
		js.executeScript(JScommand);
		js.executeScript("document.querySelector('.page > a:nth-child(10)').click()");
	    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "End");

	}

	private String generateToken() {
        js.executeScript("document.querySelector('body > div > div.page > a:nth-child(8)').click();");	
        return (String)js.executeScript("return document.getElementById('token').innerHTML");
	}

}
