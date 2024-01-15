package cowinAPIs;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSessionsByDistrict {
	
	@Test
	public void getSessionsByDistrict() {
		
		RestAssured.baseURI = "https://cdn-api.co-vin.in";
		//api/v2/appointment/sessions/public/findByDistrict?district_id=140&date=06-05-2021
		Response response = RestAssured.given()
		.basePath("api/v2/appointment/sessions/public/findByDistrict")
		.queryParam("district_id", "571")
		.queryParam("date", "16-12-2023")
		.log()
		.everything(true)
		.get();
		response.prettyPrint();
	}

}
