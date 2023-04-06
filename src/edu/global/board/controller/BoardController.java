package edu.global.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.command.BCommand;
import edu.global.board.command.BContentCommand;
import edu.global.board.command.BDeleteCommand;
import edu.global.board.command.BListCommand;
import edu.global.board.command.BModifyCommand;
import edu.global.board.command.BReplyCommand;
import edu.global.board.command.BReplyViewCommand;
import edu.global.board.command.BWriteCommand;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo()..");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		System.out.println("uri : " + uri);
		System.out.println("contextPath: " + contextPath);
		System.out.println("com : " + com);
		
		if (com.equals("/list.do")) {
			command = new BListCommand();
			command.excute(request, response);
			viewPage = "list.jsp";
		}
		else if (com.equals("/content_view.do")) {
			command = new BContentCommand();
			command.excute(request, response);
			viewPage = "content_view.jsp";
		}
		else if (com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}
		else if (com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}
		else if (com.equals("/write_view.do")) {
			System.out.println("/write_view.do..");
			viewPage = "write_view.jsp";
		}
		else if (com.equals("/write.do")) {
			System.out.println("/write.do..");
			command = new BWriteCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}
		else if (com.equals("/reply_view.do")) {
			System.out.println("/reply_view.do..");
			command = new BReplyViewCommand();
			command.excute(request, response);
			viewPage = "reply_view.jsp";
		}
		else if (com.equals("/reply.do")) {
			System.out.println("reply.do..");
			command = new BReplyCommand();
			command.excute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
