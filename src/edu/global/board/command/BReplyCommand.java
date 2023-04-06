package edu.global.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.board.dao.BoardDAO;

public class BReplyCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
	      String bid = request.getParameter("bid");
	      String bname = request.getParameter("bname");
	      String btitle = request.getParameter("btitle");
	      String bcontent = request.getParameter("bcontent");
	      String bgroup = request.getParameter("bgroup");
	      String bstep = request.getParameter("bstep");
	      String bindent = request.getParameter("bindent");
	      
	      BoardDAO dao = new BoardDAO();
	      dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
	}

}
