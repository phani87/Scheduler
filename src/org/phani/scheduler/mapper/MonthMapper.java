package org.phani.scheduler.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.phani.scheduler.vo.MonthVo;
import org.phani.scheduler.vo.SlotsVo;

public class MonthMapper {

	boolean isKnuckle = false;

	public Map<Integer, MonthVo> getCurrentMonth(String monthName) {
		int monthNo = getMonthNo(monthName);
		Map<Integer, MonthVo> mann = new HashMap();
		String firstDay = getFirstDayOfMonth(monthNo);
		if (isKnuckle) {
			mann = createMonthDays(firstDay, 31, monthNo);
		} else if (!isKnuckle && monthNo == 1) {
			mann = createMonthDays(firstDay, 28, monthNo);
		} else {
			mann = createMonthDays(firstDay, 30, monthNo);
		}

		/*
		 * Iterator<Integer> iterator = mann.keySet().iterator();
		 * while(iterator.hasNext()){ Integer key = iterator.next();
		 * System.out.println("day No--"+key+"  value"+mann.get(key)); }
		 */
		return mann;

	}

	public Map<Integer, MonthVo> getCurrentMonth(Integer monthNo) {
		// int monthNo = getMonthNo(mvo.getMonth());
		Map<Integer, MonthVo> mann = new HashMap();
		String firstDay = getFirstDayOfMonth(monthNo);
		if (isKnuckle) {
			mann = createMonthDays(firstDay, 31, monthNo);
		} else if (!isKnuckle && monthNo == 1) {
			mann = createMonthDays(firstDay, 28, monthNo);
		} else {
			mann = createMonthDays(firstDay, 30, monthNo);
		}

		/*
		 * Iterator<Integer> iterator = mann.keySet().iterator();
		 * while(iterator.hasNext()){ Integer key = iterator.next();
		 * System.out.println("day No--"+key+"  value"+mann.get(key)); }
		 */
		return mann;

	}

	public Map<Integer, MonthVo> createMonthDays(String first, int noOfDays,
			Integer monthNo) {
		int dayNo = getDayNo(first);
		int j = 0;
		int k = 1;
		SlotsVo slots;
		Map<Integer, MonthVo> dateMap = new HashMap();
		MonthVo monVo;

		for (int i = dayNo; i <= 7; i++) {
			List<SlotsVo> slotsDetailsList = new ArrayList<SlotsVo>();
			monVo= new MonthVo();
			if (i == 7 && k < noOfDays) {
				i = 0;
			} else if (k == 32) {
				break;
			} else if (k > noOfDays) {
				break;
			}
			monVo.setMonthNo(monthNo);
			monVo.setDayName(getDayName(i));
			for (int l = 0; l < 21; l++) {
				slots = new SlotsVo();
				slots.setSlotNo(l);
				slots.setSlotBooked(false);
				slotsDetailsList.add(slots);
			}
			monVo.setSlots(slotsDetailsList);
			dateMap.put(k, monVo);
			k++;

		}
		return dateMap;
	}

	public int getMonthNo(String monthName) {
		int monthNo = 0;

		switch (monthName) {
		case "January":
			monthNo = 0;
			isKnuckle = true;
			break;
		case "Febuary":
			monthNo = 1;
			break;
		case "March":
			monthNo = 2;
			isKnuckle = true;
			break;
		case "April":
			monthNo = 3;
			break;
		case "May":
			monthNo = 4;
			isKnuckle = true;
			break;
		case "June":
			monthNo = 5;
			break;
		case "July":
			monthNo = 6;
			isKnuckle = true;
			break;
		case "August":
			monthNo = 7;
			isKnuckle = true;
			break;
		case "September":
			monthNo = 8;
			break;
		case "October":
			monthNo = 9;
			isKnuckle = true;
			break;
		case "November":
			monthNo = 10;
			break;
		case "December":
			monthNo = 11;
			isKnuckle = true;
			break;
		}
		return monthNo;
	}

	private String getDayName(int dayNo) {
		String dayName = "";
		switch (dayNo) {
		case 0:
			dayName = "Monday";
			break;
		case 1:
			dayName = "Tuesday";
			break;
		case 2:
			dayName = "Wednesday";
			break;
		case 3:
			dayName = "Thursday";
			break;
		case 4:
			dayName = "Friday";
			break;
		case 5:
			dayName = "Saturday";
			break;
		case 6:
			dayName = "Sunday";
			break;
		}
		return dayName;
	}

	private int getDayNo(String firstDay) {
		int day = 0;
		switch (firstDay) {
		case "Monday":
			day = 0;
			break;
		case "Tuesday":
			day = 1;
			break;
		case "Wednesday":
			day = 2;
			break;
		case "Thursday":
			day = 3;
			break;
		case "Friday":
			day = 4;
			break;
		case "Saturday":
			day = 5;
			break;
		case "Sunday":
			day = 6;
			break;
		}
		return day;
	}

	private String getFirstDayOfMonth(int monthNo) {

		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.DATE,25);
		cal.set(Calendar.MONTH, monthNo);
		cal.set(Calendar.YEAR, 2015);

		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = cal.getTime();

		DateFormat sdf = new SimpleDateFormat("EEEEEEEE");
		String firstDay = sdf.format(firstDayOfMonth);
		System.out.println("First Day of Month: " + firstDay);
		return firstDay;

	}

	public static void main(String[] args) {
		MonthMapper andDay = new MonthMapper();
		Map<Integer, MonthVo> testmap = andDay.getCurrentMonth("May");
		System.out.println("Total Map Size--" + testmap.size());
		for (Map.Entry<Integer, MonthVo> entry : testmap.entrySet()) {
			Integer key = entry.getKey();
			MonthVo value = entry.getValue();

			System.out.println("Month No-- " + value.getMonthNo()
					+ " Day Name-- " + value.getDayName() + " No of Slots-- "
					+ value.getSlots().size());

		}
	}

}
