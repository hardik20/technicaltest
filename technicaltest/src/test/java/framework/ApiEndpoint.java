/*package framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiEndpoint {

	public static String BASE_URI = "http://localhost:9080/studentmgmt";
	public static String Endpoint_Fetchstudents = "/fetchStudents";


	public static Response fetchStudents() {
		// base URI with Rest Assured class
		RestAssured.baseURI = String.format("%s%s", BASE_URI, Endpoint_Fetchstudents);
		// input details
		RequestSpecification request = RestAssured.given();
		// GET request
		Response response = request.get();
		// obtain Response as string
		String j = response.asString();
		// get response time
		long c = response.getTime();
		System.out.println("Response time in milliseconds: " + c);
		System.out.println("------Response Body------ 1  " + "\n" + response.jsonPath().get());
		return response;
	}

}*/
