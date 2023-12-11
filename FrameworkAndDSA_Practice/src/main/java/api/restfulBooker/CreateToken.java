package api.restfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateToken extends BaseClass{

	@Test
	public void createToken() {

		PojoLoginCredentials object = new PojoLoginCredentials("admin", "password123");
		Response response = RestAssured.given()
				.contentType("application/json")
				.when()
				.body(object)
				/*
				 * "{\r\n" + 
			"    \"username\" : \"admin\",\r\n" + 
			"    \"password\" : \"password123\"\r\n" + 
			"}"
				 */
				.log()
				.everything(true)
				.post("/auth");

		response.jsonPath().prettyPrint();
		PojoCreateTokenResponse responseObject = response.getBody().as(PojoCreateTokenResponse.class);
		token = responseObject.getToken();
		response.then().assertThat().statusCode(200);
		System.out.println(token);
	}

}
