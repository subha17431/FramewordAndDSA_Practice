package api.restfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBooking extends BaseClass {
	
	@Test(dependsOnMethods = "mentorHomeWork.api.restfulBooker.CreateToken.createToken")
	public void createBooking() {
		
		PojoBookingDates datesObject = new PojoBookingDates("2023-09-02", "2023-09-03");
		PojoCreateBookingBody bodyObject = new PojoCreateBookingBody("Subhadutta", "Dash", 1000, true, datesObject, "Breakfast & Dinner");
		Response response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.when()
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
		.post("/booking");
		
		response.jsonPath().prettyPrint();
		PojoCreateBookingResponse responseObject = response.getBody().as(PojoCreateBookingResponse.class);
		bookingId = responseObject.getBookingid();
		System.out.println("Created Booking Id is: "+responseObject.getBookingid());
		System.out.println("Booking is done in the name of: "+responseObject.getBooking().getFirstname()+" "+responseObject.getBooking().getLastname());
		System.out.println("Check In Date is: "+responseObject.getBooking().getBookingdates().getCheckin());
		response.then().assertThat().statusCode(200);
		System.out.println(response.getStatusCode());
	}
}
