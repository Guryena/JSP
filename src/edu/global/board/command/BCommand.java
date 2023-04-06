package edu.global.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	public abstract void excute(HttpServletRequest request, HttpServletResponse response);
	
}
