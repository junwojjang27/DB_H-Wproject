package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Base extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {

//		super.init(config);
		
		System.out.println("init called Yeah~1212");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service called please hi~");
		//super.service(req, res);
	}
	
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service called");
//		super.service(req, res);
//	}
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			// TODO Auto-generated method stub
//		super.service(req, resp);
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("doget called");
//		
//		resp.setCharacterEncoding("UTF-8");					//이거랑 아래줄은 한글을 처리하기 위해 사용
//		resp.setContentType("text/html; charset=UTF8");
//		PrintWriter out = resp.getWriter();
//		out.print("<html><head><title>Test</title></head>");
//		out.print("<body><h1>hello 안녕</h1></body>");
//		out.print("</html>");
//		out.close();
//	}
	
	
	
}
