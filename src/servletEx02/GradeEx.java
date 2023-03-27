package servletEx02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletEx02.grade.Grade;

/**
 * Servlet implementation class GradeEx
 */
@WebServlet("/GradeEx")
public class GradeEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ok");
		
		request.setCharacterEncoding("UTF-8");
		String getKor = request.getParameter("kor".trim()); //trim() removes meaningless spaces 
		String getEng = request.getParameter("eng".trim());
		String getMath = request.getParameter("math".trim());
		
		double kor = Double.valueOf(getKor);
		double eng = Double.valueOf(getEng);
		double math = Double.valueOf(getMath);
		
		
		Grade grade = new Grade(kor, eng, math);
		double sum = grade.getSum();
		double avg = grade.getAvg();
		char chgrade = grade.getGrade();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("합계 : " + sum);
		writer.println("평균 : " + avg);
		writer.println("등급 : " + chgrade);
		writer.println("</body></html>");
	}

}
