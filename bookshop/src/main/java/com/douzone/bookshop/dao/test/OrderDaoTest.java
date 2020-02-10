package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insertTest(1L, 24000, "원주");
//		insertOrderBookTest(2L, "이것이자바다", 2L);
		selectTest();
		selectOrderBookTest();
	}

	public static void insertTest(long customerNo, int payment, String address) {
		OrderVo vo = new OrderVo();
		vo.setCustomerNo(customerNo);
		vo.setPayment(payment);
		vo.setAddress(address);

		new OrderDao().insert(vo);
	}
	
	public static void insertOrderBookTest(Long bookNo, String bookTitle , long count) {
		OrderBookVo vo = new OrderBookVo();
		vo.setBookNo(bookNo);
		vo.setBookTitle(bookTitle);
		vo.setCount(count);

		new OrderDao().insertOrderBook(vo);
	}

	public static void selectTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void selectOrderBookTest() {
		List<OrderBookVo> list = new OrderDao().findOrderBook();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
