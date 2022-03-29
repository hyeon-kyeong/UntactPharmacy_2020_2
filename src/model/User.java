package model;

import java.io.Serializable;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	private String user_id;
	private String user_no;
	private String user_password;
	private String user_name;
	private String email;
	private String phone;
	private String gender;
	private String birth_date;

	private String symptom;
	private int user_level;

	public User() { }		// 기본 생성자

	public User(String user_id, String user_password) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
	}

	//RegisterUserController 
	public User(String user_id, String user_password, String user_name, String email, String phone, String gender,
			String birth_date, String symptom) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.birth_date = birth_date;
		this.symptom = symptom;
	}

	//UpdateUserController
	public User(String user_id, String user_password, String user_name, String email, String phone, String gender,
			String birth_date, String symptom, int user_level) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.birth_date = birth_date;
		this.symptom = symptom;
		this.user_level = user_level;
	}


	public User(String user_id, String user_password, String user_name, String email, String phone, String gender,
			String symptom) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.symptom = symptom;
	}

	public User(String user_id, String user_name, String email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
	}

	public User(String user_id, String user_no, String user_password, String user_name, String email, String phone,
			String gender, String birth_date, String symptom, int user_level) {
		super();
		this.user_id = user_id;
		this.user_no = user_no;
		this.user_password = user_password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.birth_date = birth_date;
		this.symptom = symptom;
		this.user_level = user_level;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		System.out.println(password);
		if (password == null) {
			return false;
		}
		return this.user_password.equals(password);
	}

	//	로그인시 관리자 여부 (회원등급) 확인 
	public boolean isManager() {
		//		System.out.println(this.user_level);
		if (this.user_level < 2) {
			return false;
		}
		return true;
	}

	public boolean isSameUser(String userid) {
		return this.user_id.equals(userid);
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_no=" + user_no + ", password=" + user_password + ", name=" + user_name + ", email=" + email + ", phone="
				+ phone + ", gender="+gender + ", birth_date="+birth_date +", symptom=" +symptom+ ", user_level=" + user_level+"]";
	}	


}
