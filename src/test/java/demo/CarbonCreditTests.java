package demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CarbonCreditTests {

	@Test (priority = 1)
	public void validateCarbonCredits() {
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1";
		RequestSpecification request = given();

		// Send a GET request to the API endpoint
		Response response = request.get("/Categories/6327/Details.json?catalogue=false");

		// Validate the response code
		response.then().statusCode(200);

		// Validate the "Name" field is equal to "Carbon credits"
		response.then().assertThat().body("Name", equalTo("Carbon credits"));

		// Validate the "CanRelist" field is true
		response.then().assertThat().body("CanRelist", is(true));

		// Validate the "Promotions" element with "Name" equal to "Gallery" has a "Description" containing the text "Good position in category"
		response.then().assertThat().body("Promotions.find { it.Name == 'Gallery' }.Description", containsString("Good position in category"));

		// Additional tests for error handling
		response.then()
				.assertThat().contentType("application/json")
				.and().header("Content-Length", "1398")
				.and().time(lessThan(5000L)); // Ensure the response time is less than 5 seconds
	}

	@Test (priority = 2)
	public void validateInvalidEndpoint() {
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1";
		RequestSpecification request = given();

		// Send a GET request to an invalid API endpoint
		Response response = request.get("/invalid-endpoint");

		// Validate the response code is a 404 Not Found
		response.then().statusCode(404);

		// Validate the error message in the response body
		response.then().assertThat().body(containsString("File or directory not found."));
	}

	@Test (priority = 3)
	public void validateInvalidMethod() {
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1";
		RequestSpecification request = given();

		// Send a POST request to the API endpoint
		Response response = request.post("/Categories/6327/Details.json?catalogue=false");

		// Validate the response code is a 405 Method Not Allowed
		response.then().statusCode(405);

		// Validate the error message in the response body
		response.then().assertThat().body(containsString("Method not allowed"));
	}
}
