package api.restfulBooker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIds extends BaseClass {
	
	
	@Test(dependsOnMethods = "mentorHomeWork.api.restfulBooker.CreateBooking.createBooking")
	public void getBookingIds() {
		
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.log()
		.everything(true)
		.basePath("/booking/")
		.get();
		
		//PojoBookingId object = new PojoBookingId(bookingId);
		PojoBookingId[] allBookingIds = response.getBody().as(PojoBookingId[].class);
		int count = 0;
		//ArrayList<PojoBookingId> bookingIds = new ArrayList<PojoBookingId>(Arrays.asList(allBookingIds));
		//Assert.assertTrue(bookingIds.contains(object), "Newly created booking is not present");
		for (PojoBookingId pojoBookingId : allBookingIds) {
			if (pojoBookingId.getBookingid() == bookingId) {
				count++;
				System.out.println("Newly created booking id is present: "+pojoBookingId.getBookingid());
				break;
			}
		}
		Assert.assertTrue(count==1, "Newly created booking is not present");
		System.out.println(allBookingIds.toString());
	}

}
