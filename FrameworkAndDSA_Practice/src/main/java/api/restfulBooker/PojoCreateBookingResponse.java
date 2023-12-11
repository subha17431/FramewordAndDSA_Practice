package api.restfulBooker;

public class PojoCreateBookingResponse {
	
	private int bookingid;
	private PojoCreateBookingBody booking;
	
	public PojoCreateBookingResponse(int bookingid, PojoCreateBookingBody booking) {
		this.bookingid = bookingid;
		this.booking = booking;
	}
	
	public PojoCreateBookingResponse() {}
	
	public int getBookingid() {
		return bookingid;
	}
	
	public PojoCreateBookingBody getBooking() {
		return booking;
	}

}
