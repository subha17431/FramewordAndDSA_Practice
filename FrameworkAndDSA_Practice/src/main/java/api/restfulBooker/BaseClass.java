package api.restfulBooker;

import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;

public class BaseClass {

	public static String baseUri = "https://restful-booker.herokuapp.com";
	public static String token;
	public static int bookingId;
	PojoBookingDates datesObject = new PojoBookingDates("2023-09-02", "2023-09-03");
	PojoCreateBookingBody bodyObject = new PojoCreateBookingBody("Subhadutta", "Dash", 1000, true, datesObject, "Breakfast & Dinner");

	@BeforeMethod
	public void base() {

		RestAssured.baseURI = baseUri;
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "password123");
	}
}
