package com.VO;

public class savememberVO {
	private String id;
	private String pw;
	private String gender;
	private String age;
	
	
	public savememberVO(String id, String pw, String gender, String age) {
		super();
		this.id = id;
		this.pw = pw;
		this.gender = gender;
		this.age = age;
	}
	
	public savememberVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public savememberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
