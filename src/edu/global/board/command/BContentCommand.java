package edu.global.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.baord.dto.BoardDTO;
import edu.global.board.dao.BoardDAO;

public class BContentCommand implements BCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		String bid = request.getParameter("bid");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contenteView(bid);
		
		request.setAttribute("content_view", dto);
		
	}

}
