package edu.global.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		System.out.println("doget() ..");
//		System.out.println(request.getRemoteAddr());
//		System.out.println(request.getRemoteHost());
//
//		String name = request.getParameter("name");
//
//		System.out.println(name);
//		String ID = request.getParameter("id");
//
//		System.out.println(ID);
//		String PW = request.getParameter("pw");
//
//		System.out.println(PW);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		String pw = request.getParameter("pw");
		System.out.println(pw);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("이름 : "+ name + "</br>");
		writer.println("아이디 : "+ id + "</br>");
		writer.println("비밀번호 : "+ pw + "</br>");
		writer.println("</body></html>");
	}

}
