package model;

public class LineItem_reservDTO {

	private String reserv_id;
	private String lineno;
	private String med_id;
	private int price;
	private int quantity;
	private int total_price;
	
	public LineItem_reservDTO(String reserv_id) {
		super();
		this.reserv_id = reserv_id;
	}

	public LineItem_reservDTO(String reserv_id, String lineno, String med_id, int price, int quantity,
			int total_price) {
		super();
		this.reserv_id = reserv_id;
		this.lineno = lineno;
		this.med_id = med_id;
		this.price = price;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	public String getReserv_id() {
		return reserv_id;
	}

	public void setReserv_id(String reserv_id) {
		this.reserv_id = reserv_id;
	}

	public String getLineno() {
		return lineno;
	}

	public void setLineno(String lineno) {
		this.lineno = lineno;
	}

	public String getMed_id() {
		return med_id;
	}

	public void setMed_id(String med_id) {
		this.med_id = med_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
}
