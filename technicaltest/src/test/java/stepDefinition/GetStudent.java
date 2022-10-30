package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetStudent {

	private final String BSURL = "http://localhost:9080/studentmgmt/";
	private Response resp;
	private Response response;

	@Given("I can hit the url with {string} for class")
	public void i_can_hit_the_url_with_for_class(String string) throws URISyntaxException {
		RestAssured.baseURI = BSURL;
		RequestSpecification requestspecification = RestAssured.given();
		resp = requestspecification.when().get(new URI("fetchStudents?studentClass=" + string));
	}

	@When("I can verify the {int} for it")
	public void i_can_verify_the_for_it(Integer int1) {
		int actualResponseCode = resp.then().extract().statusCode();
		Assert.assertEquals(200, actualResponseCode);
	}

	@Then("message contains {string} in record")
	public void message_contains_in_record(String string) {
		System.out.println("------THE BODY IS------ " + "\n" + resp.getBody().asString());
		JsonPath jsonPathEvaluator = resp.jsonPath();
		List<String> nationality = jsonPathEvaluator.get("nationality");
		System.out.println("Nationality received from Response " + nationality.contains(string));
		Assert.assertEquals(true, nationality.contains(string));
	}
	
	@Given("I can retrive record {int} of the student")
	public void i_can_retrive_record_of_the_student(Integer int1) throws URISyntaxException {
		RestAssured.baseURI = BSURL;
		RequestSpecification request = RestAssured.given();
		response = request.when().get(new URI("fetchStudents?id=" + int1));
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> jsonpath = jsonPathEvaluator.get("id");
		System.out.println("Json path received from Response " + jsonpath);
		Assert.assertEquals(true, jsonpath.contains(int1));
	}

}

