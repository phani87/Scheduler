package org.phani.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.phani.scheduler.mapper.BookedSlotsMapper;
import org.phani.scheduler.vo.MonthVo;
import org.phani.scheduler.vo.TempVo;

public class SchedulerDAO implements ISchedulerDAO {

	TestDb testDb;

	public TempVo tempVo;
	public SQL sql = new SQL();
	

	/*
	 * public List<String> getWorkingDays() { try { testDb = new TestDb();
	 * 
	 * Connection connection = testDb.getConnection(); Statement statement =
	 * connection.createStatement(); ResultSet rs =
	 * statement.executeQuery("select * from workingDays"); while (rs.next()) {
	 * int id = rs.getInt(1); String workDay = rs.getString(2);
	 * System.out.println("ID: " + id + "\tWorkDay:  " + workDay); } rs.close();
	 * statement.close(); connection.close(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return null; }
	 */
	@Override
	public boolean isSlotExistAndBooked(List<TempVo> tempList) {
		testDb = new TestDb();
		boolean isSlotExitsAndBooked = false;
		System.out.println("----Enter--------isSlotExist()-------Enter---");
		Connection connection = testDb.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			for (TempVo itr : tempList) {
				statement = (PreparedStatement) connection
						.prepareStatement(sql.ISSLOTEXIST);
				statement.setString(1, itr.getMonthNo());
				statement.setString(2, itr.getDayNo());
				statement.setString(3, itr.getSlotNo());
				 rs = statement.executeQuery();
				while (rs.next()) {
					int isSlotExist = rs.getInt(1);
					System.out.println("isSlotExist------>>>>>>>>"
							+ isSlotExist);
					if (isSlotExist == 1) {
						if (!isSlotBooked(itr)) {
							bookSlot(itr, connection, statement);
							isSlotExitsAndBooked = true;
						} else {
							System.out.println("Slot is Booked!! Sorry!!");
							/*
							 * timeVO = new TimeVO();
							 * timeVO.setDayNo(vo.getMonthNo());
							 * timeVO.setDayNo(vo.getDayNo());
							 * timeVO.setSlotNo(vo.getSlotNo());
							 */
							//getAllBookedSlotsforMotth(Integer.parseInt(itr.getMonthNo()));
							isSlotExitsAndBooked = true;
						}

					} else {
						createSlot(itr, connection);
						bookSlot(itr, connection, statement);
						isSlotExitsAndBooked = true;

					}
				}
				
			}
			testDb.closeConnection(rs, statement, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----Exit--------isSlotExist()-------Exit---");
		return isSlotExitsAndBooked;
	}

	@Override
	public void bookSlot(TempVo vo, Connection connection,
			PreparedStatement statement) {
		System.out.println("----Enter--------bookSlot()-------Enter---");
		try {
			testDb = new TestDb();
			statement = (PreparedStatement) connection
					.prepareStatement(sql.BOOKSLOT);
			statement.setBoolean(1, true);
			statement.setString(2, vo.getMonthNo());
			statement.setString(3, vo.getDayNo());
			statement.setString(4, vo.getSlotNo());
			statement.executeUpdate();
			System.out.println("Slot Booked");
			// testDb.closeConnection(statement, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----Exit--------bookSlot()-------Exit---");
	}

	/*public static void main(String[] args) {
		SchedulerDAO dao = new SchedulerDAO();
		TempVo vo = new TempVo();
		vo.setMonthNo(1);
		vo.setDayNo(2);
		vo.setSlotNo(2);
		dao.isSlotExist(vo);
	}
*/
	@Override
	public void createSlot(TempVo vo, Connection connection) {
		try {
			testDb = new TestDb();

			PreparedStatement statement;

			statement = (PreparedStatement) connection
					.prepareStatement(sql.CREATESLOT);
			statement.setString(1, vo.getMonthNo());
			statement.setString(2, vo.getDayNo());
			statement.setString(3, vo.getSlotNo());
			statement.setBoolean(4, false);
			statement.executeUpdate();
			System.out.println("Slot Created");
			// testDb.closeConnection(statement, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean isSlotBooked(TempVo vo) {
		System.out.println("----Enter--------isSlotBooked()-------Enter---");
		boolean isSlotBook = false;
		try {
			testDb = new TestDb();

			Connection connection = testDb.getConnection();
			PreparedStatement statement;

			statement = (PreparedStatement) connection
					.prepareStatement(sql.ISSLOTBOOKED);
			statement.setString(1, vo.getMonthNo());
			statement.setString(2, vo.getDayNo());
			statement.setString(3, vo.getSlotNo());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				isSlotBook = rs.getBoolean(1);
				System.out.println("isSlotBook----------->>>>>>>" + isSlotBook);
			}
			// testDb.closeConnection(rs, statement, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("----Exit--------isSlotBooked()-------Exit---");
		return isSlotBook;
	}

	@Override
	public Map<Integer, MonthVo> getAllBookedSlotsforMotth(Integer mono, Map<Integer, MonthVo> map) {

		System.out.println("----Enter--------bookMonthList()-------Enter---");
		boolean isSlotBook = false;
		BookedSlotsMapper bookedSlotsMapper = new BookedSlotsMapper();
		Map<Integer, MonthVo> entMap = new HashMap();
		List<TempVo> bookeSlots = new ArrayList<TempVo>();
		try {
			testDb = new TestDb();

			Connection connection = testDb.getConnection();
			PreparedStatement statement;

			statement = (PreparedStatement) connection
					.prepareStatement(sql.GETALLBOOKEDSLOTSMONTHLY);
			statement.setInt(1, mono);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TempVo timeVO = new TempVo();
				timeVO.setSlotNo(rs.getString(1));
				timeVO.setSlotBooked(rs.getBoolean(2));
				timeVO.setDayNo(rs.getString(3));
				timeVO.setMonthNo(Integer.toString(mono));
				bookedSlotsMapper.bookedSlots(timeVO, map);
			}
			
			// testDb.closeConnection(rs, statement, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("----Exit--------bookMonthList()-------Exit---");
		return entMap;
	
	}
	
}
