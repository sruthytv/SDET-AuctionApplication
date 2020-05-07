package com.Auction.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import browserActions.WebdriverManager;

public class WinnerBid {
	public WebDriver driver;

	@Before
	public void beforeTest() {
		driver = WebdriverManager.setupBrowser();
		driver.get("http://localhost:8080/AuctionApplication/Welcome.jsp");
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//input[@value='Seller']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.name("closebid")).click();
		String result = driver.findElement(By.xpath("//div[@id='bidDiv']//h2")).getText();
		if (result.contains("Winner")) {
			System.out.println("Junit Test 'View the Winner BId' is run successfully");
		} else {
			System.out.println("Junit Test 'View the Winner BId' is failed");
		}
	}

	@After
	public void afterTest() {
		WebdriverManager.closeDriver();
	}
}
