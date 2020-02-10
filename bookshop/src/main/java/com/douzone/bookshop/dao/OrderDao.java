package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {
	public OrderVo find(Long no) {
		return null;
	}

	public List<OrderVo> find(OrderVo vo) {
		return null;
	}

	public List<OrderVo> findAll(){
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select o.no, cus.name, cus.email, o.payment, o.address\r\n" + 
					"from orders o, customer cus\r\n" + 
					"where o.customer_no = cus.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			//5. 결과 가져오기
			while(rs.next()) {
				String no = rs.getString(1);
				String customerName = rs.getString(2);
				String customerEmail = rs.getString(3);
				int payment = rs.getInt(4);
				String address = rs.getString(5);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setCustomerName(customerName);
				vo.setCustomerEmail(customerEmail);
				vo.setPayment(payment);
				vo.setAddress(address);

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

	public Boolean insert(OrderVo OrderVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "20200202-00001");
			pstmt.setLong(2, OrderVo.getCustomerNo());
			pstmt.setInt(3, OrderVo.getPayment());
			pstmt.setString(4, OrderVo.getAddress());

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
	
	public Boolean insertOrderBook(OrderBookVo OrderBookVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders_book values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "20200202-00001");
			pstmt.setLong(2, OrderBookVo.getBookNo());
			pstmt.setLong(3, OrderBookVo.getCount());

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

	public List<OrderBookVo> findOrderBook() {
		List<OrderBookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select b.no, b.title, ob.count\r\n" + 
					"from orders_book ob, orders o, book b\r\n" + 
					"where o.no = ob.order_no\r\n" + 
					"	  and b.no = ob.Book_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			//5. 결과 가져오기
			while(rs.next()) {
				Long bookNo = rs.getLong(1);
				String bookTitle = rs.getString(2);
				Long count = rs.getLong(3);

				OrderBookVo vo = new OrderBookVo();
				vo.setBookNo(bookNo);
				vo.setBookTitle(bookTitle);
				vo.setCount(count);

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
}
