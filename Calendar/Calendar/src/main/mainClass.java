package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainClass {

	public static void main(String[] args) {

		/*
			Calendar year month day
			Date 					time
		*/
		
		//Calendar cal = new GregorianCalendar();
		
		Calendar calen = Calendar.getInstance();	//static과 동일 - 인스턴스생성없이 사용
		
		//날짜 
		int year = calen.get(Calendar.YEAR);
		int month = calen.get(Calendar.MONTH) + 1; //month만 범위가 0~11까지 있음
		int day = calen.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month +"월 " + day + "일");
		
		//날짜를 설정
		calen.set(Calendar.YEAR, 2021);
		calen.set(Calendar.MONTH, 4 - 1);	//4월
		calen.set(Calendar.DATE,13);
		
		year = calen.get(Calendar.YEAR);
		month = calen.get(Calendar.MONTH) + 1;
		day = calen.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month +"월 " + day + "일");
		
		//요일
		int weekday = calen.get(Calendar.DAY_OF_WEEK);	// 1 ~ 7 : 일 ~ 토
		System.out.println(weekday);
		
		switch(weekday){
			case 1 : 
				System.out.println("일요일입니다.");
				break;
			case 2 : 
				System.out.println("월요일입니다.");
				break;
			case 3 : 
				System.out.println("화요일입니다.");
				break;
		}
		
		calen.set(Calendar.YEAR, 2020);
		calen.set(Calendar.MONTH, 11-1);
		
		//지정한 달의 마지막 날짜 31 30 29 28 
		int lastday = calen.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("lastday : "+lastday);
				
		//위쪽의 빈칸
		weekday = calen.get(Calendar.DAY_OF_WEEK);
		int upspace = (weekday - 1) % 7;
				
		System.out.println("위쪽 빈칸 수 : "+upspace);
				
				
		//그 달의 마지막 날짜
		lastday = calen.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("lastday : "+lastday);
				
		//밑쪽의 빈칸
		calen.set(Calendar.DATE, lastday);	//마지막 날로 셋팅
		//-> 마지막날짜 요일이 필요함 
		weekday = calen.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekday);
				
		int downspace = 7 - weekday;
		System.out.println("밑쪽 빈칸 수 : "+downspace);
		
		//달력출력
		year = 2020;
		month = 11;
		
		calen.set(Calendar.YEAR, year);
		calen.set(Calendar.MONTH, month-1);
		calen.set(Calendar.DATE, 1);
						
		int startDay = calen.get(Calendar.DAY_OF_WEEK);
		int lastDay = calen.getActualMaximum(Calendar.DAY_OF_MONTH);
		int date = 1;
		
		System.out.println(year +"년 "+month +"월 ");
		System.out.println("===================================================");
		String week_day = "일월화수목금토";
		
		for (int i = 0; i < week_day.length(); i++) {
			char c = week_day.charAt(i);
			System.out.print(c + "\t");
		}
		System.out.println();
		System.out.println("===================================================");
		
		//윗쪽빈칸
		for (int i = 1; i < startDay; i++) {
			System.out.print("*"+"\t");
		}
		
		//날짜 
		for (int i = 0; i < lastDay; i++) {
			System.out.print(date + "\t");
			
			//개행
			if((date + startDay -1) % 7 == 0) {
				System.out.println();
			}
			
			date++;
		}
		
		//밑쪽의 빈칸
		for (int i = 0; i < (7 - (startDay + lastDay- 1) % 7); i++) {
			System.out.print("*"+"\t");
		}
		System.out.println();
		System.out.println("===================================================");
	}

}
