package com.douzone.bookshop.vo;

public class OrderBookVo {
	private String OrderNo;
	private long bookNo;
	private long count;

	private String BookTitle;

	@Override
	public String toString() {
		return bookNo + " " + BookTitle + " " + count;
	}
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
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
	public void setCount(long count) {
		this.count = count;
	}
}
