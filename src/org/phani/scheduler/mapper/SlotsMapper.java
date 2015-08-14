package org.phani.scheduler.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.phani.scheduler.vo.TempVo;

public class SlotsMapper {

	public List<TempVo> MonthDaySlotExtractor(String [] arr){
		String [] temp = seperateByComma(arr);
		List<TempVo> temp1 = seperateByDot(temp);
		return temp1;
	}
	
	private String[] seperateByComma(String [] arr){
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i];
		}
		String[] tempArr = temp.split(",");
		return tempArr;
	}
	
	private List<TempVo> seperateByDot(String [] arr){
		String temp = "";
		
		List<TempVo> tempList = new ArrayList<TempVo>();
		for (int i = 0; i < arr.length; i++) {
			TempVo tempVo = new TempVo();
			temp = arr[i];
			String[] tempArr = temp.split("\\.");
			tempVo.setMonthNo(tempArr[0].toString());
			tempVo.setDayNo(tempArr[1].toString());
			tempVo.setSlotNo(tempArr[2].toString());
			tempList.add(tempVo);
		}
		
		return tempList;
	}
	
	public static void main(String[] args) {
		SlotsMapper mapper = new SlotsMapper();
		String[] arrrrr = {"1.1.1,2.2.2,3.3.3"};
		mapper.MonthDaySlotExtractor(arrrrr);
	}
}
