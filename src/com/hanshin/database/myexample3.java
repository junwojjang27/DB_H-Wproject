package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/my3")
public class myexample3 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String v_ = req.getParameter("value");						//주석처리 a가 application, s가 session
		int v = Integer.parseInt(v_);
		String op = req.getParameter("operator");
		
//a		ServletContext application = req.getServletContext();
//s		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		
		if(op.contentEquals("=")) {
			int result = 0;
//a			int prev = (int)application.getAttribute("value");
//a			String prev_op = (String)application.getAttribute("operator");
			
//s			int prev = (int)session.getAttribute("value");
//s			String prev_op = (String)session.getAttribute("operator");
			
//a,s		if(prev_op.contentEquals("+")) {
//a,s			result = prev + v;
//a,s		}
//a,s		else if(prev_op.equals("-")) {
//a,s				result = prev - v;
//a,s		}
			
			int prev=0;
			String prev_op = "";
			for(Cookie c: cookies) {		//Cookie는 배열이라 다른것들처럼 if문이아니라 for문 돌린것.
				if(c.getName().equals("value")) {
					prev = Integer.parseInt(c.getValue());
				}
				if(c.getName().equals("operator")) {
					prev_op = c.getValue();
				}
			}
			
			if(prev_op.contentEquals("+"))
				result = prev + v;
			else
				result = prev - v;
			
			resp.getWriter().printf("Result is %d\n", result);
		}
		else {
//a			application.setAttribute("value", v);
//a			application.setAttribute("operator", op);
			
//s			session.setAttribute("value", v);
//s			session.setAttribute("operator", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie operatorCookie = new Cookie("operator", op);
			
//쿠키 경로 설정	valueCookie.setPath("cal2");
//쿠키 수명 설정	valueCookie.setMaxAge(10);		//10초
			
			resp.addCookie(valueCookie);
			resp.addCookie(operatorCookie);
			
			
		}
		
	}

}
