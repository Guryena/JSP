package edu.global.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.baord.dto.BoardDTO;
import edu.global.board.dao.BoardDAO;

public class BListCommand implements BCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		
		List<BoardDTO> vos = dao.list();
		
		request.setAttribute("boards", vos);
		
	}

}
