package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Post implements Serializable {
	
	private int post_id;
	private String user_id;
	private String med_id;
	private String post_date;
	private String title;	
	private String content;
	private String ingestion_start;
	private String ingestion_end;

	//기본 생성자
	public Post() {}
	
	// 기본키 포함 생성자
	public Post(int post_id, String user_id) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
	}
	
	// 전체 매개변수 생성자
	public Post(int post_id, String user_id, String med_id, String post_date,
			String title, String content, String ingestion_start,
			String ingestion_end) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.med_id = med_id;
		this.post_date = post_date;
		this.title = title;
		this.content = content;
		this.ingestion_start = ingestion_start;
		this.ingestion_end = ingestion_end;
	}
	
	// getter, setter 정의
	public int getPost_id() {
		return post_id;
	}
	
	public void setPost_id(int post_id) {
		this.post_id = post_id;
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
	
	public String getPost_date() {
		return post_date;
	}
	
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getIngestion_start() {
		return ingestion_start;
	}

	public void setIngestion_start(String ingestion_start) {
		this.ingestion_start = ingestion_start;
	}

	public String getIngestion_end() {
		return ingestion_end;
	}

	public void setIngestion_end(String ingestion_end) {
		this.ingestion_end = ingestion_end;
	}
	
}
