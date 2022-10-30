/*package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import org.junit.Assert;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import framework.ApiEndpoint;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class GetStudent2 {

	ResponseOptions<Response> response = ApiEndpoint.fetchStudents();

	@Given("I am an authorised user")
	public void i_am_an_authorised_user() {
		Assert.assertEquals(200, response.statusCode());
	}

	@Then("I reach the endpoint with {string} for class")
	public void i_reach_the_endpoint_with_for_class(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}*/