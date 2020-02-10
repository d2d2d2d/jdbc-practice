package com.douzone.bookshop.main;

import com.douzone.bookshop.dao.test.BookDaoTest;
import com.douzone.bookshop.dao.test.CartDaoTest;
import com.douzone.bookshop.dao.test.CategoryDaoTest;
import com.douzone.bookshop.dao.test.CustomerDaoTest;
import com.douzone.bookshop.dao.test.OrderDaoTest;

public class BookShopApp {

	public static void main(String[] args) {
		CategoryDaoTest.insertTest("인터넷소설");
		CategoryDaoTest.insertTest("IT");
		CategoryDaoTest.insertTest("토익");
		CategoryDaoTest.selectTest();
		
		BookDaoTest.insertTest("늑대의유혹", 10000, 1);
		BookDaoTest.insertTest("이것이자바다", 12000, 2);
		BookDaoTest.insertTest("해커스토익", 15000, 3);
		BookDaoTest.selectTest();
		
		CustomerDaoTest.insertTest("이예은", "010-1234-5678", "yeeun@naver.com", "dldPdms");
		CustomerDaoTest.insertTest("이예람", "010-0987-6543", "yeram@gmail.com", "dldPfka");
		CustomerDaoTest.selectTest();
		
		CartDaoTest.insertTest(1L, 2L, 2L);
		CartDaoTest.insertTest(2L, 1L, 1L);
		CartDaoTest.selectTest();
		
		OrderDaoTest.insertTest(1L, 24000, "원주");
		OrderDaoTest.insertOrderBookTest(2L, "이것이자바다", 2L);
		OrderDaoTest.selectTest();
		OrderDaoTest.selectOrderBookTest();
	}

}
