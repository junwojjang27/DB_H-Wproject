package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/databaseTest")
public class DatabaseTestServlet extends HttpServlet {
	@SuppressWarnings("deprecation")
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h3>Database ���� ���ߵǶ� 1<h3><body>");
		
		String userName = "";
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";
		
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			
//			String sql = "SELECT * FROM databasetest.member";
			String sql = "SELECT * FROM databasetest.addressbook";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				userName = rs.getString("name");
				System.out.printf("title: %s\n", userName);
				out.print("<br>" + userName);
			} 
			
			rs.close();
			st.close();
			con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		out.print("</html>");
		out.close();
	}	
}