package testData;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DataDriven {

	private static Response response;
	private static final String POST_URI = "http://localhost:9080/studentmgmt/addStudent";
	private static final String DELETE_URI = "http://localhost:9080/studentmgmt/deleteStudent";
	static String currentDirectory = System.getProperty("user.dir");
	private static String excelPath = currentDirectory + "\\src\\test\\resources\\data\\TestDataGen.xlsx";
	private static String sheetName = "Sheet1";
	private static ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
	private static int rows = excel.getRowCount(sheetName);
	private static int actRows = rows - 1;

	public static void post() throws JsonParseException, JsonMappingException, IOException {
		// POST
		JSONObject request = new JSONObject();

		for (int i = 1; i <= actRows; i++) {
			request.put("id", excel.getCellData(i, 0));
			request.put("firstName", excel.getCellData(i, 1));
			request.put("lastName", excel.getCellData(i, 2));
			request.put("studentClass", excel.getCellData(i, 3));
			request.put("nationality", excel.getCellData(i, 4));

			RestAssured.given().header("content-type", "application/json").and().body(request.toJSONString()).when()
					.post(POST_URI)/* .then().extract().response() */;
		}
		System.out.println("-----------Setting up Test Data------------");
	}

	public static void delete() throws JsonParseException, JsonMappingException, IOException {
		// Delete
		JSONObject delrequest = new JSONObject();
		for (int i = 1; i <= actRows; i++) {
			delrequest.put("id", excel.getCellData(i, 0));
			RestAssured.given().header("content-type", "application/json").and().body(delrequest.toJSONString()).when()
					.delete(DELETE_URI);
		}
		System.out.println("\n" +"-----------Deleting Test Data------------");
	}

}
