package core.momoinfo;

public class MomoInfo {
	private int momoId;
	private int spotId;
	private int itemId;
	private int memberId;
	private String inDate;
	private String outDate;
	private int priceByHour;
	private String status;
	
	public MomoInfo(int momoId, int spotId, int itemId, int memberId, String inDate, String outDate, int priceByHour,
			String status) {
		super();
		this.momoId = momoId;
		this.spotId = spotId;
		this.itemId = itemId;
		this.memberId = memberId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.priceByHour = priceByHour;
		this.status = status;
	}

	public int getMomoId() {
		return momoId;
	}

	public void setMomoId(int momoId) {
		this.momoId = momoId;
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public int getPriceByHour() {
		return priceByHour;
	}

	public void setPriceByHour(int priceByHour) {
		this.priceByHour = priceByHour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MomoInfo [momoId=" + momoId + ", spotId=" + spotId + ", itemId=" + itemId + ", memberId=" + memberId
				+ ", inDate=" + inDate + ", outDate=" + outDate + ", priceByHour=" + priceByHour + ", status=" + status
				+ "]";
	}	
}
