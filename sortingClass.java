package practice01;

import java.util.Arrays;
import java.util.Scanner;

public class sortingClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
	
		String count;	//몇개 정렬
		int numArr[];
		
		//user 몇개를 정렬?
		
		boolean b = false;
		while(true) {
			
			System.out.println("몇개를 입력하시겠습니까?");
			count = sc.next();
			
			for (int i = 0; i < count.length(); i++) {
				int asc = (int)count.charAt(i);
				
				if(asc>47 && asc<58) {
					b = true;
					break;
				}
			}
			
			if(b == true) {
				break;
			}
			
			System.out.println("숫자가 아닙니다. 다시 입력하세요");
			
		}
		
		int index = Integer.parseInt(count);
		numArr = new int[index];
		
		///배열확보
			//숫자들 입력(잘못 입력시 다시 입력)
			//->문자?숫자?
		
		
		String snum;
		int w = 0;
		while(w<numArr.length) {
			boolean b2 = false;
				while(true) {
						System.out.println("배열할 숫자를 입력하세요");
						snum = sc.next();
						
						for (int j = 0; j < snum.length(); j++) {
							int asc = (int)snum.charAt(j);
							
							if(asc>47 && asc<58) {
								b2=true;
								break;
							}
						}
						
					if(b2 == true) {
						break;
					}
					
					System.out.println("숫자가 아닙니다. 다시 입력하세요");
				}
				
				int num = Integer.parseInt(snum);
				numArr[w] = num;
				
				w++;
		}
		
		//입력받은 배열 출력
		//System.out.println(Arrays.toString(numArr));
		
		
		//올림?내림? 입력
		System.out.println("어떤 정렬방식을 선택하시겠습니까? 오름(1)/내림(2)를 입력해주세요.");
		String sw = sc.next();
		int temp;
		
		//정렬기능
		if(sw.equals("1")) {
			for (int i = 0; i < numArr.length-1; i++) {
				for (int j = i+1; j < numArr.length; j++) {
					if(numArr[i]>numArr[j]) {
						temp = numArr[i];
						numArr[i] = numArr[j];
						numArr[j] = temp;
					}
				}
			}
		}else if(sw.equals("2")) {
			for (int i = 0; i < numArr.length-1; i++) {
				for (int j = i+1; j < numArr.length; j++) {
					if(numArr[i]<numArr[j]) {
						temp = numArr[i];
						numArr[i] = numArr[j];
						numArr[j] = temp;
					}
				}
			}
		}
		
		System.out.print(Arrays.toString(numArr));
			
		


	}
}
