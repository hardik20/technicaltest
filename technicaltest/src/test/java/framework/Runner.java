package framework;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import testData.DataDriven;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
		glue = { "src/test/java/stepDefinition","stepDefinition" }, 
		monochrome = true,
		plugin = { "pretty", "html:target/HtmlReports.html", "json:target/cucumber.json" },
		tags = ("@Smoke"),
		// Publish Test Reports
		publish = true, 
		stepNotifications = true)

public class Runner {
	
	@BeforeClass
	public static void testDataGenerator() throws JsonParseException, JsonMappingException, IOException {
		DataDriven.post();
	}
	
	@AfterClass
	public static void testDataClean() throws JsonParseException, JsonMappingException, IOException {
		DataDriven.delete();
	}
}
