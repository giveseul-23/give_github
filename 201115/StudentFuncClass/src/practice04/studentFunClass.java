package practice04;

import java.util.Scanner;

public class studentFunClass {

	public static void main(String[] args) {
		//성적계산기 - Function
		int count;
		String studentInfom[][] = null;
		int subNum[][] = null;
		int add[];   
		int max = 0;
		double avg = 0;
		int langMax;
		int mathMin;
		
		//학생 수 
		count = studentCount();
		
		//학생정보 입력
			// 이름, 국, 수, 영
		studentInfom = studentInfo(count);
		
		//성적만 있는 배열만들기
		subNum = subjectNum(studentInfom);
	
		//각 학생의 총점
		add = sum(subNum,studentInfom);
		
		//총점의 1등
		max = numberOne(add);
		System.out.println();
		System.out.println("총점의 1등 점수는 "+max+"점 이다.");
		
		//총점의 평균
		avg = avg(add);
		System.out.println("총점의 평균은 "+avg+"점 이다.");
		
		//국어의 1등점수
		langMax = langOne(subNum);
		System.out.println("국어점수의 1등은 "+langMax+"점 이다.");
		
		//수학의 최하점수
		mathMin = mathmin(subNum);
		System.out.println("수학점수의 최하점수는 "+mathMin+"점 이다.");
		
		//학생이름 입력시 정보 출력
		inputInfo(studentInfom);
		
	}

	//학생 수 입력받기
	static int studentCount() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력하고자 하는 학생의 수를 입력하세요 : ");
		int count = sc.nextInt();
		
		return count;
	}
	
	//학생정보 입력받기
	static String[][] studentInfo(int count){
		Scanner sc = new Scanner(System.in);
		String student[][] = new String[count][4];
		String name, lang, math, eng;
		
		int w = 0;
		while(w<student.length) {
			//이름
			System.out.print("학생의 이름을 입력하세요 : ");
			name = sc.next();
			if(name.trim().equals(" ")) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			
			//국어성적 입력
			lang = num("국어");
			
			//수학성적 입력
			math = num("수학");
			
			//영어성적 입력
			eng = num("영어");
			
			student[w][0] = name;
			student[w][1] = lang;
			student[w][2] = math;
			student[w][3] = eng;
			
			w++;
		}
		
		return student;
	} 
	
	//성적만 있는 배열 만들기
	 static int[][] subjectNum(String[][] student){
		 int[][] subNum = new int[student.length][3];
		 
		 for (int i = 0; i < subNum.length; i++) {
			for (int j = 0; j < 3; j++) {
				subNum[i][j] = Integer.parseInt(student[i][j+1]);
			}
		}
		 
		 return subNum;
	 }
	
	 //각 학생의 총점
	 static int[] sum(int[][] subNum, String[][] student) {
		 int add[] = new int[subNum.length];
		 
		 for (int i = 0; i < add.length; i++) {
			int lang = subNum[i][0];
			int math = subNum[i][1];
			int eng = subNum[i][2];
			
			add[i] = lang + math + eng;
		}
		 	for (int i = 0; i < add.length; i++) {
		 		System.out.print(student[i][0]+"의 학생의 총점수는"+add[i]+" ");
			}
		 	
		 	return add;
	 }
	 
	 //총점의 1등 점수
	 static int numberOne(int[] sum) {
		 int max = sum[0];
		 
		 for (int i = 0; i < sum.length; i++) {
			 if(max<sum[i]) {
				 max = sum[i];
			 }
		}
		 
		 return max;
	 }
	 
	 //총점의 평균
	 static double avg(int[] sum) {
		 int result = 0;
		 double avg = 0;
		 
		 for (int i = 0; i < sum.length; i++) {
			result = result + sum[i];
		 }
		 
		 avg = (double)result/sum.length;
		 
		 return avg;
	 }
	 
	 //국어점수의 1등
	 static int langOne(int[][] subNum) {
		 int[] lang = new int[subNum.length];
		 
		 for (int i = 0; i < lang.length; i++) {
			lang[i] = subNum[i][0];
		}
		 
		int max = lang[0];
		
		for (int i = 0; i < lang.length; i++) {
			if(max<lang[i]) {
				max = lang[i];
			}
		}
		
		return max;
	 }
	
	//수학의 최하점수 
	 static int mathmin(int[][] subNum) {
		 int[] math = new int[subNum.length];
		 
		 for (int i = 0; i < math.length; i++) {
			math[i] = subNum[i][1];
		}
		 
		int min = math[0];
		
		for (int i = 0; i < math.length; i++) {
			if(min>math[i]) {
				min = math[i];
			}
		}
		
		return min;
	 } 
	 
	 //학생이름 입력시 정보 출력
	 static void inputInfo(String[][] student) {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("원하는 정보의 학생 이름을 입력하세요 : ");
		 String username =  sc.next();
		 
		 for (int i = 0; i < student.length; i++) {
			 for (int j = 0; j < student[0].length; j++) {
				 if(username.equals(student[i][0])) {
					 	System.out.print(student[i][j]+" ");
				}
			}
		 }
		 
	 }
	 
	 
	//성적입력받기
	static String num(String str) {
		Scanner sc = new Scanner(System.in);
		String num;
		
		boolean b = false;
		
		while(true) {
			System.out.print(str+"의 점수를 입력하세요 : ");
			num = sc.next();
			
			for (int i = 0; i < num.length(); i++) {
				int asc = (int)num.charAt(i);
				
				if(asc>47 && asc<58) {
					b = true;
					break;
				}
			}
			if(b==true) {
				break;
			}
			
			System.out.print("문자가 있습니다. 다시");
		}
		return num;
	}
 	
}
