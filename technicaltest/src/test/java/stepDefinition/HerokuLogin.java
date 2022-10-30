package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.WebDriverClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HerokuLogin {

	//Initialize the webdriver 
	@BeforeAll
	public static void setUp() {
		WebDriverClass.initialise();
	};

	@Given("I navigate to Heroku website")
	public void i_navigate_to_herou_website() {
		WebDriverClass.driver.get("http://the-internet.herokuapp.com/");
	}

	@And("I can click form authentication")
	public void i_can_click_form_authentication() {
		WebElement LinkText = WebDriverClass.driver.findElement(By.partialLinkText("Form Authentication"));
		LinkText.click();
		WebElement loginId = WebDriverClass.driver.findElement(By.id("login"));
		Assert.assertEquals(true, loginId.isDisplayed());
	}

	@When("I enter username and password")
	public void i_enter_username_and_password() {
		WebElement Username = WebDriverClass.driver.findElement(By.id("username"));
		Username.sendKeys("tomsmith");
		WebElement Password = WebDriverClass.driver.findElement(By.id("password"));
		Password.sendKeys("SuperSecretPassword!");
	}

	@Then("I can login")
	public void i_can_login() {
		WebElement LoginBtn = WebDriverClass.driver.findElement(By.xpath("//*[@id='login']/button"));
		LoginBtn.click();
	}

	@AfterAll
	public static void quit() {
		WebDriverClass.quit();
	};

}
