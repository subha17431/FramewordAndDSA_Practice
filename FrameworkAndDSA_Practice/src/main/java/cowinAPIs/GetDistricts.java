package cowinAPIs;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetDistricts {
	
	
	@Test
	public void getDistricts() {
		
		RestAssured.baseURI = "https://cdn-api.co-vin.in";
		//api/v2/appointment/sessions/public/findByDistrict?district_id=140&date=06-05-2021
		Response response = RestAssured.given()
		.basePath("api/v2/admin/location/districts/9")
		.log()
		.everything(true)
		.get();
		response.prettyPrint();
	}

}
