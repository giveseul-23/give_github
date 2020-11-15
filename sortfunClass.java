package practice02;

import java.util.Arrays;
import java.util.Scanner;

public class sortfunClass {

	public static void main(String[] args) {
		

		//sorting Function
		int count;
		int number[] = null;
		boolean sortTF = false;
		
		//정렬을 원하는 수의 갯수
		count = inputCount();
		
		//정렬하고자 하는 숫자
		number = inputNumArr(count);
		
		System.out.println(Arrays.toString(number));
		
		//올림, 내림 입력
		sortTF = inputSort();
		
		//입력에 따른 판정
		//출력
		resultSort(sortTF,number);
		
	}

	//정렬 원하는 수 입력
		static int inputCount() {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("정렬을 하고자하는 수의 갯수를 입력하세요  : ");
			int count = sc.nextInt();
			
			return count;
			
		}
		
		//정렬하고자 하는 숫자 입력
		static int[] inputNumArr(int count) {
			Scanner sc = new Scanner(System.in);
			int[] numberArr = new int[count];
			int w = 0;
			
			while(w<numberArr.length) {
				while(true) {
					System.out.print((w+1)+"의 자리 숫자를 입력하세요 : ");
					String snum = sc.next();
					
					if(isNumber(snum)==false) {
						System.out.println("문자를 포함하고 있습니다. 다시");
						continue;
					}else if(isNumber(snum)==true){
						numberArr[w] = Integer.parseInt(snum);
						break;
					}
				}
				
				w++;
			}
			return numberArr;
		}
		
		//올림,내림 입력받기
		static boolean inputSort() {
			Scanner sc = new Scanner(System.in);
			
			boolean sortTF = false;
			
			System.out.print("정렬을 선택하세요.[올림(1)/내림(2)] : ");
			String sortword = sc.next();
			
			if(sortword.equals("1")) {
				//올림
				sortTF = true;
			}else if(sortword.equals("2")) {
				//내림
				sortTF = false;
			}
			
			return sortTF;
		}
		
		//올림내림 입력받은 값으로 정렬해주기
		static void resultSort(boolean sortTF, int[] number) {
			int num[] = null;
			int temp;
			if(sortTF == true) {
				for (int i = 0; i < number.length-1; i++) {
					for (int j = i+1; j < number.length; j++) {
						if(number[i]>number[j]) {
							temp = number[i];
							number[i] = number[j];
							number[j] = temp;
						}
					}
				}
			}else if(sortTF == false) {
				for (int i = 0; i < number.length-1; i++) {
					for (int j = i+1; j < number.length; j++) {
						if(number[i]<number[j]) {
							temp = number[i];
							number[i] = number[j];
							number[j] = temp;
						}
					}
				}
			}
			
			System.out.println(Arrays.toString(number));
		}
		
		//숫자 문자 구분
		static boolean isNumber(String snum) {
			boolean realNum = true;
			for (int i = 0; i < snum.length(); i++) {
				int asc = (int)snum.charAt(i);
				
				if(asc<48 || asc>58) {
					realNum = false;
				}
			}
			
			return realNum;
		}
	
}
