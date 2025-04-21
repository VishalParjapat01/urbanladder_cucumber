package Defination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {
	
	WebDriver driver;
	@Given("Visit the homepage  of urban leader")
	public void Visit_the_homepage_of_urban_leader() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@And("user should be on home page")
	public void user_should_be_on_home_page() {
		
		boolean HomeView = driver.findElement(By.id("home")).isDisplayed();;
		
		Assert.assertTrue(HomeView, "Home page not visit");
		
	}
	@Then("User successfully on home page")
	public void User_successfully_on_home_page() {
		driver.quit();
	}
	

}
