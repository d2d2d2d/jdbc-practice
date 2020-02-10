package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
//		insertTest(1L, 2L, 2L);
//		insertTest(2L, 1L, 1L);
		selectTest();
	}

	public static void insertTest(long customerNo, long bookNo, long count) {
		CartVo vo = new CartVo();
		vo.setCustomerNo(customerNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		new CartDao().insert(vo);
	}

	public static void selectTest() {
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}

}
