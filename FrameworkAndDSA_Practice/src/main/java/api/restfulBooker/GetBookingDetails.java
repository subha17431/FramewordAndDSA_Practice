package api.restfulBooker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingDetails extends BaseClass {
	
	@Test(dependsOnMethods = {"mentorHomeWork.api.restfulBooker.CreateBooking.createBooking", "mentorHomeWork.api.restfulBooker.GetBookingIds.getBookingIds"})
	public void getBookingDetails() {
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.log()
		.everything(true)
		.basePath("/booking/"+bookingId)
		.get();
		
		response.jsonPath().prettyPrint();
		PojoCreateBookingBody responseObject = response.getBody().as(PojoCreateBookingBody.class);
		response.then().assertThat().statusCode(200);
		Assert.assertTrue(responseObject.getFirstname().equals("Subhadutta"), "First Name Doesn't Match");
		Assert.assertTrue(responseObject.getBookingdates().getCheckin().equals("2023-09-02"), "Check in Date Doesn't Match");		
	}
}
