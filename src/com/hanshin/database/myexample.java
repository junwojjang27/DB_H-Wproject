package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myexample extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("서비스 동작!");
		super.service(req, res);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("do !");
		resp.setContentType("text/html; charset=UTF-8");	//한글지원
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>get</title></head>");
		out.print("<body>");
		out.print("<h1>DATABASE 데이터베이스</h1>");
		out.println("</body></html>");
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("post");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>POST</title></head>");
		out.print("<body>");
		out.print("<h1>DATABASE 데이터베이스</h1>");				
		out.println("</body></html>");
		out.close();
	}

}
