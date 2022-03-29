package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Reservation implements Serializable {

	private int reserv_id;
	private String user_id;
	private String med_id;
	private String pharm_name;
	private String reserv_date;
	private String address;
	private List<LineItem> lineItems = new ArrayList<LineItem>();



	//  »ı¼ºÀÚ	
	public Reservation() {}

	public Reservation(int reserv_id) {
		super();
		this.reserv_id = reserv_id;
	}

	public Reservation(int reserv_id, String user_id, String med_id,
			String pharm_name, String reserv_date, String address) {
		super();
		this.reserv_id = reserv_id;
		this.user_id = user_id;
		this.med_id = med_id;
		this.pharm_name = pharm_name;
		this.reserv_date = reserv_date;
		this.address = address;
	}

	public int getReserv_id() {
		return reserv_id;
	}

	public void setReserv_id(int reserv_id) {
		this.reserv_id = reserv_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMed_id() {
		return med_id;
	}

	public void setMed_id(String med_id) {
		this.med_id = med_id;
	}

	public String getPharm_name() {
		return pharm_name;
	}

	public void setPharm_name(String pharm_name) {
		this.pharm_name = pharm_name;
	}

	public String getReserv_date() {
		return reserv_date;
	}

	public void setReserv_date(String reserv_date) {
		this.reserv_date = reserv_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setLineItems(List<LineItem> lineItems) { this.lineItems = lineItems; }
	public List<LineItem> getLineItems() { return lineItems; }

}