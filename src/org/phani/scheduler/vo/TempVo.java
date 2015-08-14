package org.phani.scheduler.vo;

public class TempVo {
	
	private String monthNo;
	private String dayNo;
	private String slotNo;
	private boolean isSlotBooked;
	
	//setters and getters
	public String getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(String monthNo) {
		this.monthNo = monthNo;
	}
	public String getDayNo() {
		return dayNo;
	}
	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}
	public String getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}
	public boolean isSlotBooked() {
		return isSlotBooked;
	}
	public void setSlotBooked(boolean isSlotBooked) {
		this.isSlotBooked = isSlotBooked;
	}

}
