package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Medicine implements Serializable {

	private String med_id; // PK
	private String reserv_id; // FK
	private String med_name;
	private String symptom;
	private String co_name;
	private String med_category;
	private int price;
	private int quantity;
	private String filename;
	private String dir;
	
	public Medicine() {
		
	}
	
	public Medicine(String med_id) {
		super();
		this.med_id = med_id;
	}

	public Medicine(String med_id, String reserv_id, String med_name, String symptom,
			String co_name, String med_category, int price, int quantity) {
		super();
		this.med_id = med_id;
		this.reserv_id = reserv_id;
		this.med_name = med_name;
		this.symptom = symptom;
		this.co_name = co_name;
		this.med_category = med_category;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Medicine(String med_id, String med_name, String symptom, String co_name,
			String med_category, int price, int quantity) {
		super();
		this.med_id = med_id;
		this.med_name = med_name;
		this.symptom = symptom;
		this.co_name = co_name;
		this.med_category = med_category;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Medicine(String med_id, String med_name, String symptom, String co_name,
			String med_category, int price, int quantity, String filename) {
		super();
		this.med_id = med_id;
		this.med_name = med_name;
		this.symptom = symptom;
		this.co_name = co_name;
		this.med_category = med_category;
		this.price = price;
		this.quantity = quantity;
		this.filename = filename;
	}

	public String getMed_id() {
		return med_id;
	}

	public void setMed_id(String med_id) {
		this.med_id = med_id;
	}

	public String getReserv_id() {
		return reserv_id;
	}

	public void setReserv_id(String reserv_id) {
		this.reserv_id = reserv_id;
	}

	public String getMed_name() {
		return med_name;
	}

	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public String getMed_category() {
		return med_category;
	}

	public void setMed_category(String med_category) {
		this.med_category = med_category;
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

	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
}
