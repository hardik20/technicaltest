package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.WebDriverClass2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormAuthenticationPage;
import pages.HerokuPage;

public class HerokuLoginTest {
	

	@Given("I navigate to Heroku website")
	public void i_navigate_to_herou_website() {
		WebDriverClass2.getdriver();
	}

	@And("I can click form authentication")
	public void i_can_click_form_authentication() {
		HerokuPage.formAuthenticationLink(WebDriverClass2.getdriver()).click();
		Assert.assertEquals(true, FormAuthenticationPage.loginId(WebDriverClass2.getdriver()).isDisplayed());
	}

	@When("I enter username and password")
	public void i_enter_username_and_password() {
		FormAuthenticationPage.Username(WebDriverClass2.getdriver()).sendKeys("tomsmith");
		FormAuthenticationPage.Password(WebDriverClass2.getdriver()).sendKeys("SuperSecretPassword!");
	}

	@Then("I can login")
	public void i_can_login() {
		FormAuthenticationPage.LoginBtn(WebDriverClass2.getdriver()).click();
	}

	@AfterAll
	public static void quit() {
		WebDriverClass2.quit();
	};

}
