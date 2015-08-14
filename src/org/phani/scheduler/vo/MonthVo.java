package org.phani.scheduler.vo;

import java.util.List;

public class MonthVo {

	private Integer monthNo;
	private Integer dayNo;
	private String dayName;
	private List<SlotsVo> slots;
	
	//setters and getters
	
	public Integer getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(Integer monthNo) {
		this.monthNo = monthNo;
	}
	public Integer getDayNo() {
		return dayNo;
	}
	public void setDayNo(Integer dayNo) {
		this.dayNo = dayNo;
	}
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	public List<SlotsVo> getSlots() {
		return slots;
	}
	public void setSlots(List<SlotsVo> slots) {
		this.slots = slots;
	}
	
}
