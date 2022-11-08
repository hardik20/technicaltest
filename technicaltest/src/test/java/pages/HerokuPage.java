package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.WebDriverClass2;

//public class HerokuPage extends WebDriverClass2 {
public class HerokuPage  {

	private static WebElement element = null;

	public static WebElement formAuthenticationLink(WebDriver driver) {
		element = driver.findElement(By.partialLinkText("Form Authentication"));
		return element;
	}

}
