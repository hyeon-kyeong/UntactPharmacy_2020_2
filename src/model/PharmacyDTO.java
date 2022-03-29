package model;

import java.io.Serializable;

public class PharmacyDTO implements Serializable{

		private String pharm_name;
		private String position;
		
		
		public PharmacyDTO(String pharm_name) {
			this.pharm_name = pharm_name;
		}

		public PharmacyDTO(String pharm_name, String position) {
			super();
			this.pharm_name = pharm_name;
			this.position = position;
		}

		public PharmacyDTO() {
			// TODO Auto-generated constructor stub
		}

		public String getPharm_name() {
			return pharm_name;
		}

		public void setPharm_name(String pharm_name) {
			this.pharm_name = pharm_name;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}
		
	}


