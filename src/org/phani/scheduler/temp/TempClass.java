package org.phani.scheduler.temp;

import java.util.Map;

import org.phani.scheduler.dao.SchedulerDAO;
import org.phani.scheduler.vo.MonthVo;

public class TempClass {
	
	public SchedulerDAO schedulerDAO = new SchedulerDAO();
	public void invokeDao(int monthNo , Map<Integer, MonthVo> map){
		schedulerDAO.getAllBookedSlotsforMotth(monthNo, map);
	}
	
}
