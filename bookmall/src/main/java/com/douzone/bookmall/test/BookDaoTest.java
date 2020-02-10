package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.AuthorDao;
import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.AuthorVo;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest("채식주의자", "대여중", 1L);
//		insertTest("몽실언니");
//		insertTest("총균쇠");
		selectTest();
	}

	public static void insertTest(String title, String state, long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setState(state);
		vo.setAuthorNo(authorNo);
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

}
