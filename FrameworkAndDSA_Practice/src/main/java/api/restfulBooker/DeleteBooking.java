package api.restfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBooking extends BaseClass {
	
	@Test(dependsOnMethods = "mentorHomeWork.api.restfulBooker.PartialUpdate.partialUpdate")
	public void deleteBooking() {
		
		Response response = RestAssured.given()
		.headers("Cookie","token="+token)
		.contentType("application/json")
		.log()
		.everything(true)
		.delete("booking/"+bookingId);
		
		
		response.then().assertThat().statusCode(201);
		System.out.println(response.getStatusCode());
		
		//Verify booking id is deleted with get booking id call with status code 404 Not Found
		
		Response response2 = RestAssured.given()
				.contentType("application/json")
				.accept("application/json")
				.log()
				.everything(true)
				.basePath("/booking/"+bookingId)
				.get();
				
				response2.then().assertThat().statusCode(404);
		
	}

}
