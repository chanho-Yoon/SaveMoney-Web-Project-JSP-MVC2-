package com.VO;

public class savingVO {
	private int no;
	private String id;
	private int current_amount;
	private int target_amount;
	private String title;
	private String data;
	private String comdata;
	
	
	public String getComdata() {
		return comdata;
	}
	public void setComdata(String comdata) {
		this.comdata = comdata;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(int current_amount) {
		this.current_amount = current_amount;
	}
	public int getTarget_amount() {
		return target_amount;
	}
	public void setTarget_amount(int target_amount) {
		this.target_amount = target_amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public savingVO(int no, String id, int current_amount, int target_amount, String title, String data) {
		super();
		this.no = no;
		this.id = id;
		this.current_amount = current_amount;
		this.target_amount = target_amount;
		this.title = title;
		this.data = data;
	}
	public savingVO(int no, String id, int current_amount, int target_amount, String title, String data,
			String comdata) {
		super();
		this.no = no;
		this.id = id;
		this.current_amount = current_amount;
		this.target_amount = target_amount;
		this.title = title;
		this.data = data;
		this.comdata = comdata;
	}
	public savingVO() {
		super();
	}
	
	
}
