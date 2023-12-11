package api.restfulBooker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PartialUpdate extends BaseClass {
	
	@Test(dependsOnMethods = {"mentorHomeWork.api.restfulBooker.CreateBooking.createBooking" , "mentorHomeWork.api.restfulBooker.UpdateBooking.updateBooking"})
	public void partialUpdate() {
		
		PojoPartialUpdate bodyObject = new PojoPartialUpdate("Alex", "Brown");
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.cookie("token="+token)
		.when()
		.body(bodyObject)
		.log()
		.everything(true)
		.patch("/booking/"+bookingId);
		
		response.jsonPath().prettyPrint();
		
		PojoCreateBookingBody responseObject = response.getBody().as(PojoCreateBookingBody.class);
		
		Assert.assertTrue(responseObject.getFirstname().equals("Alex"), "First Name not updated");
		Assert.assertTrue(responseObject.getLastname().equals("Brown"), "Check in date not updated");
		System.out.println("Booking is done in the name of: "+responseObject.getFirstname()+" "+responseObject.getLastname());

		response.then().assertThat().statusCode(200);
		System.out.println(response.getStatusCode());
	}

}
