package api.restfulBooker;

public class PojoGetBookingIdsResponse {
	
	private PojoBookingId[] bookingIds;
	
	public PojoGetBookingIdsResponse(PojoBookingId[] bookingIds) {
		this.bookingIds = bookingIds;
	}
	
	public PojoGetBookingIdsResponse() {}

	public PojoBookingId[] getBookingIds() {
		return bookingIds;
	}
	

}
