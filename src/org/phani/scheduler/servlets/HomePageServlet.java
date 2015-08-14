package org.phani.scheduler.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phani.scheduler.mapper.MonthMapper;
import org.phani.scheduler.vo.MonthVo;

/**
 * Servlet implementation class HomePageServlet
 */
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Map<Integer, MonthVo> entireMonth = new HashMap();
	public MonthMapper mapper;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String month = request.getParameter("month");
		System.out.println(month);
		
		mapper = new MonthMapper();
		int monthNo = mapper.getMonthNo(month);
		entireMonth = mapper.getCurrentMonth(month);
		request.setAttribute("month", month);
		request.setAttribute("entireMonth", entireMonth);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/jsp/datespage.jsp");
		dispatcher.forward(request, response);
	}

}
