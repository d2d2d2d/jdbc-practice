package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CustomerVo;

public class CustomerDao {
	public CustomerVo find(Long no) {
		return null;
	}

	public List<CustomerVo> find(CustomerVo vo) {
		return null;
	}

	public List<CustomerVo> findAll(){
		List<CustomerVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, name, phonenumber, email, password\r\n" + 
					"from customer";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			//5. 결과 가져오기
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				String phonenumber = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);

				CustomerVo vo = new CustomerVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPhonenumber(phonenumber);
				vo.setEmail(email);
				vo.setPassword(password);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			//6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return result;
	}

	public Boolean insert(CustomerVo CustomerVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into customer values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, CustomerVo.getName());
			pstmt.setString(2, CustomerVo.getPhonenumber());
			pstmt.setString(3, CustomerVo.getEmail());
			pstmt.setString(4, CustomerVo.getPassword());

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			//6. 자원정리
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;		
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		return conn;
	}
}
