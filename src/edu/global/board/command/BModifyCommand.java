package edu.global.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BoardDAO;

public class BModifyCommand implements BCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String bcontent = request.getParameter("bcontent");
		String btitle = request.getParameter("btitle");
		
		BoardDAO dao = new BoardDAO();
		
		dao.modify(bid, bname, bcontent, btitle);
		
	}

}
