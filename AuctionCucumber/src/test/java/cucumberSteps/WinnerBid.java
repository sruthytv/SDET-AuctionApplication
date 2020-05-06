package cucumberSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import browserActions.WebdriverManager;

public class WinnerBid {
	public WebDriver driver;
	@Given("user navigates to app")
	public void user_navigates_to_app() {
		driver=WebdriverManager.setupBrowser();
	    driver.get("http://localhost:8080/AuctionApplication/Welcome.jsp");
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Seller radio button")
	public void user_clicks_on_Seller_radio_button() {
	    driver.findElement(By.xpath("//input[@value='Seller']")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("User clicks on Close Bid button")
	public void user_clicks_on_Close_Bid_button() {
	    driver.findElement(By.name("closebid")).click();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("Winner bid will displayed")
	public void winner_bid_will_displayed() {
	    String result=driver.findElement(By.xpath("//div[@id='bidDiv']//h2")).getText();
	   if(result.contains("Winner")) {
		   System.out.println("Cucumber Test 'View the Winner BId' is run successfully");
	   }else {
		   System.out.println("Cucumber Test 'View the Winner BId' is failed");
	   }
	   WebdriverManager.closeDriver();
	    		//throw new io.cucumber.java.PendingException();
	}



}
