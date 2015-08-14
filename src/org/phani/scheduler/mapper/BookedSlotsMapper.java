package org.phani.scheduler.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.phani.scheduler.vo.MonthVo;
import org.phani.scheduler.vo.SlotsVo;
import org.phani.scheduler.vo.TempVo;

public class BookedSlotsMapper {

	public static Map<Integer, MonthVo> entireMonth = new HashMap();
	static Map<Integer, MonthVo> updatedMonthMap = new HashMap();
	
	public void bookedSlots(TempVo tempVo,
			Map<Integer, MonthVo> tempMonthMap) {
		//Map<Integer, MonthVo> entireMap = new HashMap();
		//Map<Integer, MonthVo> updatedMonthMap = new HashMap();
		for (Map.Entry<Integer, MonthVo> entry : tempMonthMap.entrySet()) {
			/*
			 * if
			 * ((Integer.toString(entry.getValue().getMonthNo())).equals(tempList
			 * . .getMonthNo())) { if
			 * (Integer.toString(entry.getKey()).equals(tempVo.getDayNo())) {
			 */
			List<SlotsVo> tempSlotsVos = new ArrayList<SlotsVo>();
			MonthVo monthVo = new MonthVo();
			SlotsVo slotsVo = new SlotsVo();
			for (int i = 0; i < entry.getValue().getSlots().size(); i++) {
				if ((Integer.toString(entry.getValue().getMonthNo()).equals(
						tempVo.getMonthNo()) && (Integer.toString(
						entry.getKey()).equals(tempVo.getDayNo()) && (Integer
						.toString(entry.getValue().getSlots().get(i)
								.getSlotNo()).equals(tempVo.getSlotNo()))))) {

					monthVo.setMonthNo(entry.getValue().getMonthNo());
					monthVo.setDayNo(entry.getKey());
					slotsVo.setSlotNo(entry.getValue().getSlots().get(i)
							.getSlotNo());
					slotsVo.setSlotBooked(true);
					tempSlotsVos.add(slotsVo);
					monthVo.setSlots(tempSlotsVos);
					monthVo.setDayName(entry.getValue().getDayName());
					updatedMonthMap.put(entry.getKey(), monthVo);
					System.out.println("<---------Selected--------->"
							+ entry.getValue().getMonthNo() + "."
							+ entry.getKey() + "."
							+ entry.getValue().getSlots().get(i).getSlotNo());
				} else {

					monthVo.setMonthNo(entry.getValue().getMonthNo());
					monthVo.setDayNo(entry.getKey());
					slotsVo.setSlotNo(entry.getValue().getSlots().get(i)
							.getSlotNo());
					slotsVo.setSlotBooked(false);
					tempSlotsVos.add(slotsVo);
					monthVo.setSlots(tempSlotsVos);
					monthVo.setDayName(entry.getValue().getDayName());
					updatedMonthMap.put(entry.getKey(), monthVo);
					/*System.out.println("NOT Selected--->"
							+ entry.getValue().getMonthNo() + "."
							+ entry.getKey() + "."
							+ entry.getValue().getSlots().get(i).getSlotNo());*/
				}
			}
			entireMonth.putAll(updatedMonthMap);
		}
		System.out.println(updatedMonthMap.size());

	}

	public  void getMap(){
		this.entireMonth = updatedMonthMap;
	}
	
	private Map<Integer, MonthVo> getSlotComparer(TempVo tempVo,
			Map<Integer, MonthVo> tempMonthMap) {
		Map<Integer, MonthVo> updatedMonthMap = new HashMap();

		for (Map.Entry<Integer, MonthVo> entry : tempMonthMap.entrySet()) {
			if ((Integer.toString(entry.getValue().getMonthNo())).equals(tempVo
					.getMonthNo())) {
				if (Integer.toString(entry.getKey()).equals(tempVo.getDayNo())) {
					List<SlotsVo> tempSlotsVos = new ArrayList<SlotsVo>();
					for (int i = 0; i < entry.getValue().getSlots().size(); i++) {
						MonthVo monthVo = new MonthVo();
						SlotsVo slotsVo = new SlotsVo();
						if ((Integer.toString(entry.getValue().getSlots()
								.get(i).getSlotNo()))
								.equals(tempVo.getSlotNo())) {
							monthVo.setMonthNo(entry.getValue().getMonthNo());
							monthVo.setDayNo(entry.getKey());
							slotsVo.setSlotNo(entry.getValue().getSlots()
									.get(i).getSlotNo());
							slotsVo.setSlotBooked(true);
							tempSlotsVos.add(slotsVo);
							monthVo.setSlots(tempSlotsVos);
							monthVo.setDayName(entry.getValue().getDayName());
							updatedMonthMap.put(entry.getKey(), monthVo);
							System.out.println("<-------Selected-------->"
									+ entry.getValue().getMonthNo()
									+ "."
									+ entry.getKey()
									+ "."
									+ entry.getValue().getSlots().get(i)
											.getSlotNo());
						} else {

							monthVo.setMonthNo(entry.getValue().getMonthNo());
							monthVo.setDayNo(entry.getKey());
							slotsVo.setSlotNo(entry.getValue().getSlots()
									.get(i).getSlotNo());
							slotsVo.setSlotBooked(false);
							tempSlotsVos.add(slotsVo);
							monthVo.setSlots(tempSlotsVos);
							monthVo.setDayName(entry.getValue().getDayName());
							updatedMonthMap.put(entry.getKey(), monthVo);
							System.out.println("NOT Selected--->"
									+ entry.getValue().getMonthNo()
									+ "."
									+ entry.getKey()
									+ "."
									+ entry.getValue().getSlots().get(i)
											.getSlotNo());
						}
					}

				} else {

					MonthVo monthVo = new MonthVo();

					monthVo.setMonthNo(entry.getValue().getMonthNo());
					SlotsVo slotsVo;
					monthVo.setDayNo(entry.getKey());
					List<SlotsVo> tempSlotsVos = new ArrayList<SlotsVo>();
					for (int i = 0; i < entry.getValue().getSlots().size(); i++) {
						slotsVo = new SlotsVo();
						slotsVo.setSlotNo(entry.getValue().getSlots().get(i)
								.getSlotNo());
						slotsVo.setSlotBooked(false);
						tempSlotsVos.add(slotsVo);
					}

					monthVo.setSlots(tempSlotsVos);
					monthVo.setDayName(entry.getValue().getDayName());
					updatedMonthMap.put(entry.getKey(), monthVo);

				}
			} else {

			}
		}
		return updatedMonthMap;
	}

	public Map<Integer, MonthVo> getEntireMonth() {
		return entireMonth;
	}

	public void setEntireMonth(Map<Integer, MonthVo> entireMonth) {
		this.entireMonth = entireMonth;
	}

}
