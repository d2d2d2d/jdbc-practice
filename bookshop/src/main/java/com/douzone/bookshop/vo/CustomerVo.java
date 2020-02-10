package com.douzone.bookshop.vo;

public class CustomerVo {
	private Long no;
	private String name;
	private String phonenumber;
	private String email;
	private String password;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerVo [no=" + no + ", name=" + name + ", phonenumber=" + phonenumber + ", email=" + email
				+ ", password=" + password + "]";
	}

	
}
