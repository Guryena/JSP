package edu.global.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.baord.dto.BoardDTO;
import edu.global.board.dao.BoardDAO;

public class BReplyViewCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO vo = dao.reply_view(bid);
		
		request.setAttribute("reply_view", vo);
	}

}
