package com.VO;

public class messageVO {
	private int no;
	private String send_id;
	private String receive_id;
	private String title;
	private int target_amount;
	private String content;
	private int shareno;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getReceive_id() {
		return receive_id;
	}
	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getShareno() {
		return shareno;
	}
	public void setShareno(int shareno) {
		this.shareno = shareno;
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
	messageVO(){}
	public messageVO(int no, String send_id, String receive_id, String content, int shareno) {
		super();
		this.no = no;
		this.send_id = send_id;
		this.receive_id = receive_id;
		this.content = content;
		this.shareno = shareno;
	}
	public messageVO(String send_id, String receive_id, String content, int shareno) {
		super();
		this.send_id = send_id;
		this.receive_id = receive_id;
		this.content = content;
		this.shareno = shareno;
	}
	public messageVO(int no, String send_id, String receive_id, String title, int target_amount, String content,
			int shareno) {
		super();
		this.no = no;
		this.send_id = send_id;
		this.receive_id = receive_id;
		this.title = title;
		this.target_amount = target_amount;
		this.content = content;
		this.shareno = shareno;
	}
}
