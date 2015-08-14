package org.phani.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import org.phani.scheduler.vo.MonthVo;
import org.phani.scheduler.vo.TempVo;

public interface ISchedulerDAO {

	public boolean isSlotExistAndBooked(List<TempVo> tempList);
	public boolean isSlotBooked(TempVo vo);
	public void bookSlot(TempVo vo, Connection connection, PreparedStatement statement);
	public void createSlot(TempVo vo, Connection connection);
	public Map<Integer, MonthVo> getAllBookedSlotsforMotth(Integer mono, Map<Integer, MonthVo> map);
	
}
