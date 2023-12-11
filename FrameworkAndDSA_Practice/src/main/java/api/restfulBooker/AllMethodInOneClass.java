package api.restfulBooker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AllMethodInOneClass extends BaseClass {
	
	//Create Token
	
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
		Assert.assertNotNull(token, "Null Token Value");
		response.then().assertThat().statusCode(200);
		System.out.println(token);
	}
	
	//Create Booking
	
	@Test(dependsOnMethods = "mentorHomeWork.api.restfulBooker.AllMethodInOneClass.createToken")
	public void createBooking() {
		
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
		Assert.assertTrue(responseObject.getBooking().getFirstname().equals(bodyObject.getFirstname()), "First Name not the same as requested");
		Assert.assertTrue(responseObject.getBooking().getLastname().equals(bodyObject.getLastname()), "Last Name not the same as requested");
		Assert.assertTrue(responseObject.getBooking().getTotalprice() == (bodyObject.getTotalprice()), "Total Price not the same as requested");
		Assert.assertTrue(responseObject.getBooking().getBookingdates().getCheckin().equals(bodyObject.getBookingdates().getCheckin()), "Check In date not the same as requested");
		Assert.assertTrue(responseObject.getBooking().getBookingdates().getCheckout().equals(bodyObject.getBookingdates().getCheckout()), "Check out date not the same as requested");
	}
	
	//Get Booking Ids and Verify if newly created booking id is present in the list
	
	@Test(dependsOnMethods = "mentorHomeWork.api.restfulBooker.AllMethodInOneClass.createBooking")
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
	
	//Get Booking Details of the above Booking Id created
	
	@Test(dependsOnMethods = {"mentorHomeWork.api.restfulBooker.AllMethodInOneClass.createBooking", "mentorHomeWork.api.restfulBooker.AllMethodInOneClass.getBookingIds"})
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
		Assert.assertTrue(responseObject.getFirstname().equals(bodyObject.getFirstname()), "First Name Doesn't Match");
		Assert.assertTrue(responseObject.getBookingdates().getCheckin().equals("2023-09-02"), "Check in Date Doesn't Match");		
	}
	
	//Update Booking
	
	@Test(dependsOnMethods = {"mentorHomeWork.api.restfulBooker.AllMethodInOneClass.createBooking", "mentorHomeWork.api.restfulBooker.AllMethodInOneClass.getBookingDetails"})
	public void updateBooking() {
		
		String updatedFirstName = "Subha", updatedCheckIn = "2023-09-01";
		int updatedTotalPrice = 2000;
		PojoBookingDates datesObject = new PojoBookingDates(updatedCheckIn, "2023-09-03");
		PojoCreateBookingBody bodyObjectUpdate = new PojoCreateBookingBody(updatedFirstName, "Dash", updatedTotalPrice, true, datesObject, "Breakfast & Dinner");

		Response response = RestAssured.given()
		.accept("application/json")
		.contentType("application/json")
		.body(bodyObjectUpdate)
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
		
		Assert.assertTrue(responseObject.getFirstname().equals(bodyObjectUpdate.getFirstname()), "First Name not updated");
		Assert.assertTrue(responseObject.getBookingdates().getCheckin().equals(bodyObjectUpdate.getBookingdates().getCheckin()), "Check in date not updated");
		Assert.assertTrue(responseObject.getTotalprice()==bodyObjectUpdate.getTotalprice(), "Total price not updated");
		System.out.println("Booking is done in the name of: "+responseObject.getFirstname()+" "+responseObject.getLastname());
		System.out.println("Check In Date is: "+responseObject.getBookingdates().getCheckin());
		System.out.println("Total Price is: "+responseObject.getTotalprice());
		response.then().assertThat().statusCode(200);
		System.out.println(response.getStatusCode());
		
	}
	
	//Partial Update
	
	@Test(dependsOnMethods = {"mentorHomeWork.api.restfulBooker.AllMethodInOneClass.createBooking" , "mentorHomeWork.api.restfulBooker.AllMethodInOneClass.updateBooking"})
	public void partialUpdate() {
		
		PojoPartialUpdate bodyObjectParUpdate = new PojoPartialUpdate("Alex", "Brown");
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.cookie("token="+token)
		.when()
		.body(bodyObjectParUpdate)
		.log()
		.everything(true)
		.patch("/booking/"+bookingId);
		
		response.jsonPath().prettyPrint();
		
		PojoCreateBookingBody responseObject = response.getBody().as(PojoCreateBookingBody.class);
		
		Assert.assertTrue(responseObject.getFirstname().equals(bodyObjectParUpdate.getFirstname()), "First Name not updated");
		Assert.assertTrue(responseObject.getLastname().equals(bodyObjectParUpdate.getLastname()), "Check in date not updated");
		System.out.println("Booking is done in the name of: "+responseObject.getFirstname()+" "+responseObject.getLastname());

		response.then().assertThat().statusCode(200);
		System.out.println(response.getStatusCode());
	}
	
	//Delete Booking and Verify if Deleted
	
	@Test(dependsOnMethods = "mentorHomeWork.api.restfulBooker.AllMethodInOneClass.partialUpdate")
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
