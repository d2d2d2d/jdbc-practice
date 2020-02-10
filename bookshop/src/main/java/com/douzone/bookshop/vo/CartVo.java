package com.douzone.bookshop.vo;

public class CartVo {
	private long customerNo;
	private long bookNo;
	
	private String title;
	private long count;
	private int price;
	
	public long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(long customerNo) {
		this.customerNo = customerNo;
	}
	public long getBookNo() {
		return bookNo;
	}
	public void setBookNo(long bookNo) {
		this.bookNo = bookNo;
	}
	public long getCount() {
		return count;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCount(long count2) {
		this.count = count2;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "CartVo [title=" + title + ", count=" + count + ", price=" + price + "]";
	}
}
