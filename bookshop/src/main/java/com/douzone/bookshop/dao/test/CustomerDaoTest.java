package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CustomerDao;
import com.douzone.bookshop.vo.CustomerVo;

public class CustomerDaoTest {
	public static void main(String[] args) {
		insertTest("이예은", "010-1234-5678", "yeeun@naver.com", "dldPdms");
		insertTest("이예람", "010-0987-6543", "yeram@gmail.com", "dldPfka");
		selectTest();
	}

	public static void insertTest(String name, String phonenumber, String email, String password) {
		CustomerVo vo = new CustomerVo();
		vo.setName(name);
		vo.setPhonenumber(phonenumber);
		vo.setEmail(email);
		vo.setPassword(password);
		new CustomerDao().insert(vo);
	}

	public static void selectTest() {
		List<CustomerVo> list = new CustomerDao().findAll();
		for(CustomerVo vo : list) {
			System.out.println(vo);
		}
	}
}

