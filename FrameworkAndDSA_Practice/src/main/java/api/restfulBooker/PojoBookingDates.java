package api.restfulBooker;

public class PojoBookingDates {
	
	private String checkin;
	private String checkout;
	
	public PojoBookingDates(String checkin, String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public PojoBookingDates() {}
	
	public String getCheckin() {
		return checkin;
	}
	
	public String getCheckout() {
		return checkout;
	}

}
