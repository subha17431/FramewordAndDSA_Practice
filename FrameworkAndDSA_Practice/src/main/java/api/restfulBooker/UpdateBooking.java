package api.restfulBooker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateBooking extends BaseClass{
	
	@Test(dependsOnMethods = {"mentorHomeWork.api.restfulBooker.CreateBooking.createBooking", "mentorHomeWork.api.restfulBooker.GetBookingDetails.getBookingDetails"})
	public void updateBooking() {
		
		String updatedFirstName = "Subha", updatedCheckIn = "2023-09-01";
		int updatedTotalPrice = 2000;
		PojoBookingDates datesObject = new PojoBookingDates(updatedCheckIn, "2023-09-03");
		PojoCreateBookingBody bodyObject = new PojoCreateBookingBody(updatedFirstName, "Dash", updatedTotalPrice, true, datesObject, "Breakfast & Dinner");

		Response response = RestAssured.given()
		.accept("application/json")
		.contentType("application/json")
		.body(bodyObject)
		/*
		 * "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}"
		 */
		.log()
		.everything(true)
		.put("/booking/"+bookingId);
		
		response.jsonPath().prettyPrint();
		PojoCreateBookingBody responseObject = response.getBody().as(PojoCreateBookingBody.class);
		
		Assert.assertTrue(responseObject.getFirstname().equals(updatedFirstName), "First Name not updated");
		Assert.assertTrue(responseObject.getBookingdates().getCheckin().equals(updatedCheckIn), "Check in date not updated");
		Assert.assertTrue(responseObject.getTotalprice()==updatedTotalPrice, "Total price not updated");
		System.out.println("Booking is done in the name of: "+responseObject.getFirstname()+" "+responseObject.getLastname());
		System.out.println("Check In Date is: "+responseObject.getBookingdates().getCheckin());
		System.out.println("Total Price is: "+responseObject.getTotalprice());
		response.then().assertThat().statusCode(200);
		System.out.println(response.getStatusCode());
		
	}

}
