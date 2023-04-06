package edu.global.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BoardDAO;

public class BDeleteCommand implements BCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String bid = request.getParameter("bid");
		
		BoardDAO dao = new BoardDAO();
		
		dao.delete(bid);
		
	}

}
