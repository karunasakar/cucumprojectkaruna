package com.filpkart.stepdefinition;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobliePruchaseSteps {
	
	
	static WebDriver driver; 
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		 
		   WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		   driver.get("https://www.flipkart.com/");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
	}

	@Given("user login by entering valid crendentials")
	public void user_login_by_entering_valid_crendentials() {
		
		try {
			WebElement button =driver.findElement(By.xpath("//button[text()='✕']"));
			button.isDisplayed();
			button.click();
			
		} catch (Exception e) {
			
			 System.out.println("login not needed");
			
		}
	}

	@When("user search mobile")
	public void user_search_mobile() throws InterruptedException {
		
		   WebElement search = driver.findElement(By.name("q"));
			  search .sendKeys("realme",Keys.ENTER);
			  Thread.sleep(3000);
	   	}
 
	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
	 
		 WebElement mobliename = driver.findElement(By.xpath("//div[contains(text(),'realme Narzo 50i (Mint Green, 32 GB)')]"));
		  
		   mobliename.click();

	}

	@Then("user click on add to cart")
	public void user_click_on_add_to_cart() {
	    
		String parent =driver.getWindowHandle();
		
	       Set<String> childurl   =driver.getWindowHandles();
	       for (String child : childurl) {
			
	    	   if (!parent.equals(child)) {
	    		  driver.switchTo().window(child);
	    		 
	    			
	  			WebElement moblinme2 =driver.findElement(By.xpath("(//span[contains(text(),'realme')])"));
	  			
	  			String name =moblinme2.getText();
	  			 System.out.println(name);
	  		
	  
			}
	       }
 
		
	}

@When("user search mobile by one dim list")
public void user_search_mobile_by_one_dim_list( DataTable dataTable) {
	                
	List<String> datas= dataTable.asList(String.class); 
	                  
	   WebElement search = driver.findElement(By.name("q"));
		  search .sendKeys( datas.get(2),Keys.ENTER);
}
}