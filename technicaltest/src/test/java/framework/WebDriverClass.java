package framework;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass {

	public static ChromeDriver driver = null;

	private WebDriverClass() {
	}

	public static void initialise() {
		// Singleton Pattern
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--start-maximised");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// Maximize the screen
			// driver.manage().window().maximize();
			// Delete all the cookies
			driver.manage().deleteAllCookies();
			// Implicit TimeOuts
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// PageLoad TimeOuts
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			// Launching the URL
			// driver.navigate().to("http://the-internet.herokuapp.com/");
		}
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
