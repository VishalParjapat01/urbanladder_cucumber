package Defination;

import static org.testng.Assert.expectThrows;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.text.TabableView;

import org.apache.hc.core5.reactor.ssl.SSLBufferMode;
import org.joda.time.tz.UTCProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.model.Category;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Search {
	
	WebDriver driver;
	@Given("Visit the homepage  of Urban Leader")
	public void Visit_the_homepage_of_Urban_Leader() {
		driver = new ChromeDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
			
	}

	@And("User click on search type sofa and enter search")
	public void User_click_on_search_type_sofa_and_enter_search() {
		
		WebElement Search = driver.findElement(By.id("search"));
		Search.sendKeys("sofa");
		Search.sendKeys(Keys.ENTER);
		
		
	}
	@And("user apply filter price")
	public void user_apply_filter_price() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-gaaction='popup.auth.close']")));
		
		if (popup.isDisplayed()) {
			popup.click();
		}
		
		WebElement Click = driver.findElement(By.xpath("(//div[@class='gname'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Click).perform();
		Thread.sleep(2000);
		
		List<WebElement> Category = driver.findElements(By.xpath("//*[@class='option '] "));
		
		for (WebElement cat : Category) {
			String str = cat.getText(); 
			if (str.equals("Sofa cum Bed")) {
				cat.click();
			}
		}
		
		
	}
	@And("user Add to cart item")
	public void user_Add_to_cart_item() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-id='70501'])[1]")).click();
		
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> tabStrings = new ArrayList<>(windowhandles);
		driver.switchTo().window(tabStrings.get(1));
		
		driver.findElement(By.xpath("(//button[@name='button'])[1]")).click();
		
		
		String actualassrt = driver.getTitle();
		Assert.assertEquals(actualassrt, "Shopping Cart - Urban Ladder");
		
		
	}
	@And("user proceed to checkout")
	public void user_proceed_to_checkout() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@name='checkout'])[1]"))).click();
		
		
		/// dummy data
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_email"))).sendKeys("admin@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_ship_address_attributes_zipcode"))).sendKeys("560034");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_ship_address_attributes_address1"))).sendKeys("Banglore");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_ship_address_attributes_firstname"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_ship_address_attributes_lastname"))).sendKeys("user");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_ship_address_attributes_phone"))).sendKeys("9876547816");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-form-submit"))).click();
		
	}
	@Then("Verify that the checkout process proceeds successfully up to the payment page")
	public void Verify_that_the_checkout_process_proceeds_successfully_up_to_the_payment_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		boolean asr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout"))).isDisplayed();
		Assert.assertTrue(asr);
	
	
	}
	@And("Close browser")
	public void Close_browser() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
