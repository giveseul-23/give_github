package practice01;

import java.util.Arrays;
import java.util.Scanner;

public class studentClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		//학생 성적계산기
		
		/*
			배열로 작성하면 2차배열이 됨
			예시로 보자면
			String array2[][] = {
				{이름, 국어성적, 수학성적, 영어성적},
				{이름, 국어성적, 수학성적, 영어성적},
				{이름, 국어성적, 수학성적, 영어성적}
			}
		*/
		
		String student[][] = null;
		int count;
		String name, lang, math, eng;
		
		//학생통계수 입력
		System.out.print("몇명의 학생을 입력하시겠습니까 = ");
		count =  sc.nextInt();
		
		student = new String[count][4];	//입력하고싶은 학생 수만큼
		
		
		//루프 - 배열의 갯수만큼 입력 받음
		int loop = 0;
		
		while(loop<student.length) {
				//이름 입력
				System.out.print("학생의 이름을 입력하세요 = ");
				name = sc.next();
				
				//국어성적 입력
				boolean realnum = false;	//숫자, 문자 구분
				while(true) {
					System.out.print("국어성적을 입력하세요");
					lang = sc.next();
					
					for (int i = 0; i < lang.length(); i++) {
						int asc =  (int)lang.charAt(i);
						
						if(asc>47 && asc<58) {
							realnum = true;
							break;
						}
					}
					
					if(realnum ==  true) {
						break;
					}
					
					System.out.println("문자가 포함되어 있습니다. 다시");
				}
				
				//수학 입력
				realnum = false;	//숫자, 문자 구분
				while(true) {
					System.out.print("수학성적을 입력하세요");
					math = sc.next();
								
					for (int i = 0; i < math.length(); i++) {
							int asc =  (int)math.charAt(i);
									
							if(asc>47 && asc<58) {
								realnum = true;
								break;
							}
					}
							
					if(realnum ==  true) {
							break;
					}
							
					System.out.println("문자가 포함되어 있습니다. 다시");
				}
						
				//영어성적 입력
				realnum = false;	//숫자, 문자 구분
				while(true) {
					System.out.print("영어성적을 입력하세요");
					eng = sc.next();
							
					for (int i = 0; i < eng.length(); i++) {
						int asc =  (int)eng.charAt(i);
								
						if(asc>47 && asc<58) {
							realnum = true;
							break;
						}
					}
							
					if(realnum ==  true) {
						break;
					}
							
					System.out.println("문자가 포함되어 있습니다. 다시");
				}
				
				student[loop][0] = name;
				student[loop][1] = lang;
				student[loop][2] = math;
				student[loop][3] = eng;
				
				loop++;
		}
		
		
		//입력받은 학생 정보들 출력
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[0].length; j++) {
				System.out.print(student[i][j]+" ");
			}
		}
		
		System.out.println();
		
		
		//각 학생들의 총점
		
		int sum[] = new int[count];//학생들의 총점을 받기 위한 1차배열 생성
		
		for (int i = 0; i < sum.length; i++) {

			int langnum = Integer.parseInt(student[i][1]);
			int mathnum = Integer.parseInt(student[i][2]);
			int engnum = Integer.parseInt(student[i][3]);
			
			sum[i] = langnum + mathnum + engnum;
		}
		
		//총점 출력
		for (int i = 0; i < sum.length; i++) {
			System.out.println(student[i][0]+"의 학생의 총점은 "+sum[i]);
		}
		
		//총점의 1등 점수 출력 - swap
		int max = sum[0];//기준을 주는 것이 가장 더 확실한 방법
		
		for (int i = 0; i < sum.length; i++) {
			if(max<sum[i]) {
				max = sum[i];
			}
		}
		
		System.out.println("총점의 1등 점수는 "+max+"이다.");
		
		//국어과목의 1등 점수
		int lang_num[] = new int[count];
		for (int i = 0; i < lang_num.length; i++) {
			lang_num[i] = Integer.parseInt(student[i][1]);
		}
		
		int langMax = lang_num[0];
		
		for (int i = 0; i < lang_num.length; i++) {
			if(langMax<lang_num[i]) {
				langMax = lang_num[i];
			}
		}
		
		System.out.println("국어점수의 1등 점수는 "+langMax+"이다.");
		
		//영어과목의 최하점수
		int eng_num[] = new int[count];
		for (int i = 0; i < eng_num.length; i++) {
			eng_num[i] = Integer.parseInt(student[i][3]);
		}
		
		int engMin = eng_num[0];
		for (int i = 0; i < eng_num.length; i++) {
			if(engMin>eng_num[i]) {
				engMin = eng_num[i];
			}
		}
		System.out.println("영어의 최하점수는 "+engMin+"이다.");
		
		//총점의 평균
		int addResult = 0;
		double avg;
		
		for (int i = 0; i < sum.length; i++) {
			addResult = addResult + sum[i];
		}
		avg = (double) (addResult/student.length);
		
		System.out.println("총점의 평균은 "+avg+"이다.");
		
		// 이름 입력시 그 학생 성적 출력
		System.out.println("원하는 정보의 학생이름을 입력해주세요");
		String inputName = sc.next();
		
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[0].length; j++) {
				if(inputName.equals(student[i][0])) {
					System.out.print(student[i][j]+" ");
				}
			}
		}
		
	}

}
