package org.phani.scheduler.dao;

public class SQL {

	public String ISSLOTBOOKED = "SELECT isBooked FROM BOOKSLOT WHERE MONTHNO = ? AND DAYNO = ? AND SLOTNO = ?";
	
	public String ISSLOTEXIST = "SELECT COUNT(isBooked) FROM BOOKSLOT WHERE MONTHNO = ? AND DAYNO = ? AND SLOTNO = ?";
	
	public String CREATESLOT = "INSERT INTO BOOKSLOT(monthNO, dayNo, slotNo, isBooked) VALUES (?,?,?,?)";
	
	public String BOOKSLOT = "UPDATE BOOKSLOT SET isBooked = ? WHERE MONTHNO = ? AND DAYNO = ? AND SLOTNO = ?";
	
	public String GETALLBOOKEDSLOTSMONTHLY = "SELECT slotNo, isBooked, dayNo FROM BOOKSLOT WHERE MONTHNO = ? ORDER BY dayNo, slotNo ASC";
	
}
