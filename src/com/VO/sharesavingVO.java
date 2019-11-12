package com.VO;

public class sharesavingVO {
	private int no;
	private int shareno;
	private String masterid;
	private String id;
	private String title;
	private int current_amount;
	private int target_amount;
	private String time;
	private String comtime;
	
	public String getMasterid() {
		return masterid;
	}
	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}
	public int getShareno() {
		return shareno;
	}
	public void setShareno(int shareno) {
		this.shareno = shareno;
	}
	public int getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(int current_amount) {
		this.current_amount = current_amount;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTarget_amount() {
		return target_amount;
	}
	public void setTarget_amount(int target_amount) {
		this.target_amount = target_amount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getComtime() {
		return comtime;
	}
	public void setComtime(String comtime) {
		this.comtime = comtime;
	}
	public sharesavingVO() {
		super();
	}
	public sharesavingVO(int no, String id, String title, int target_amount, String time) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.target_amount = target_amount;
		this.time = time;
	}
	
	public sharesavingVO(int no, String id, String title, int target_amount, String time, String comtime) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.target_amount = target_amount;
		this.time = time;
		this.comtime = comtime;
	}
	public sharesavingVO(String id, String title, int target_amount) {
		super();
		this.id = id;
		this.title = title;
		this.target_amount = target_amount;
	}
	public sharesavingVO(int no, String id, String title, int target_amount) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.target_amount = target_amount;
	}
	public sharesavingVO(int no, int shareno, String id, String title, int current_amount, int target_amount,
			String time, String comtime) {
		super();
		this.no = no;
		this.shareno = shareno;
		this.id = id;
		this.title = title;
		this.current_amount = current_amount;
		this.target_amount = target_amount;
		this.time = time;
		this.comtime = comtime;
	}
	public sharesavingVO(int no, int shareno, String masterid, String id, String title, int current_amount,
			int target_amount, String time, String comtime) {
		super();
		this.no = no;
		this.shareno = shareno;
		this.masterid = masterid;
		this.id = id;
		this.title = title;
		this.current_amount = current_amount;
		this.target_amount = target_amount;
		this.time = time;
		this.comtime = comtime;
	}
	
	
}
