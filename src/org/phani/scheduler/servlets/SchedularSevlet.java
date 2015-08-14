package org.phani.scheduler.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phani.scheduler.dao.SchedulerDAO;
import org.phani.scheduler.mapper.BookedSlotsMapper;
import org.phani.scheduler.mapper.MonthMapper;
import org.phani.scheduler.mapper.SlotsMapper;
import org.phani.scheduler.temp.TempClass;
import org.phani.scheduler.vo.MonthVo;
import org.phani.scheduler.vo.TempVo;

/**
 * Servlet implementation class SchedularSevlet
 */
public class SchedularSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SlotsMapper sMapper = new SlotsMapper();
	public Map<Integer, MonthVo> tempEntireMonth = new HashMap();
	public Map<Integer, MonthVo> entireMonth = new HashMap();
	public MonthMapper mapper = new MonthMapper();
	public SchedulerDAO schedulerDAO = new SchedulerDAO();
	public BookedSlotsMapper bsMapper = new BookedSlotsMapper();
	public TempClass tempClass = new TempClass();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedularSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String arr[] = request.getParameterValues("hiddenArr");
		String month = (String) request.getParameter("month");
		List<TempVo> bookedSlotsList = new ArrayList<TempVo>();
		int monthNo = mapper.getMonthNo(month);
		List<TempVo> tempList = sMapper.MonthDaySlotExtractor(arr);
		tempEntireMonth = mapper.getCurrentMonth(month);
		boolean isSlotBooked = schedulerDAO.isSlotExistAndBooked(tempList);
		tempClass.invokeDao(monthNo, tempEntireMonth);
		if (isSlotBooked){
		bsMapper.getMap();
		}
		
		
		request.setAttribute("month", month);
		request.setAttribute("entireMonth", entireMonth);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/jsp/datespage1.jsp");
		dispatcher.forward(request, response);
		
		
		
		
 	}

}
