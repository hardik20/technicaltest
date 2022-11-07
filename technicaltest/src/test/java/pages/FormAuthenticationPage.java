package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationPage {

	private static WebElement element = null;

	public static WebElement Username(WebDriver driver) {
		element = driver.findElement(By.id("username"));
		return element;
	}

	public static WebElement loginId(WebDriver driver) {
		element = driver.findElement(By.id("login"));
		return element;
	}

	public static WebElement Password(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}
	
	public static WebElement LoginBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='login']/button"));
		return element;
	}

}
