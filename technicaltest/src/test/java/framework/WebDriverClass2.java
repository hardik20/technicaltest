package framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass2 {

	private static ChromeDriver driver = null;

	private WebDriverClass2() {
		// driver = new ChromeDriver();
	}

	public static WebDriver getdriver() {
		// Singleton Pattern
		if (driver == null) {
			// ChromeOptions option = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// option.addArguments("--start-maximised");
			// Maximize the screen
			driver.manage().window().maximize();
			// Delete all the cookies
			driver.manage().deleteAllCookies();
			// Implicit TimeOuts
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// PageLoad TimeOuts
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			// Launching the URL
			driver.navigate().to("http://the-internet.herokuapp.com/");
			System.out.println("Webdriver class initialised");

		}
		return driver;
	}

	public static void quit() {
		System.out.println("Quitting Browser");
		driver.quit();
		driver = null;
	}

	public static void close() {
		System.out.println("Closing Browser");
		driver.close();
		driver = null;
	}

}
