package api.restfulBooker;

public class PojoCreateBookingBody {
	
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private PojoBookingDates bookingdates;
	private String additionalneeds;
	
	
	public PojoCreateBookingBody(String firstname, String lastname, int totalprice, boolean depositpaid, PojoBookingDates bookingdates, String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}
	
	public PojoCreateBookingBody() {}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public int getTotalprice() {
		return totalprice;
	}
	
	public boolean isDepositpaid() {
		return depositpaid;
	}
	
	public PojoBookingDates getBookingdates() {
		return bookingdates;
	}
	
	public String getAdditionalneeds() {
		return additionalneeds;
	}

}
