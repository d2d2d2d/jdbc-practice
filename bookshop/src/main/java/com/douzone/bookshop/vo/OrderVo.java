package com.douzone.bookshop.vo;

public class OrderVo {
	private String no;
	private Long customerNo;
	private int payment;
	private String address;
	
	private String customerName;
	private String customerEmail;
	
	private Long orderBookNo;
	private Long BookNo;
	
	public Long getOrderBookNo() {
		return orderBookNo;
	}
	public void setOrderBookNo(Long orderBookNo) {
		this.orderBookNo = orderBookNo;
	}
	public Long getBookNo() {
		return BookNo;
	}
	public void setBookNo(Long bookNo) {
		BookNo = bookNo;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	@Override
	public String toString() {
		return no  + " " + customerName + "/" + customerEmail+ " " + payment + " " + address + "\n";
	}
	

}
