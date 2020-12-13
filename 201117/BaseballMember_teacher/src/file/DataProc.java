package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataProc {
	
	private File file;
	
	public DataProc(String filename) {
		file = new File("D:\\tmp\\" + filename + ".txt");		
	}
	
	// 파일 생성
	public void createFile() {
		try {
			if(file.createNewFile()) {		
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			System.out.println("파일 입출력 문제발생");
		}		
	}
	
	// 파일에 데이터 쓰기	
	/*
		번호:1001 이름:홍길동
		1001홍길동
		1001-홍길동-24-180.1-10-2-0.12
		
		들어가는 데이터 : String[]
	*/
	public void saveData(String []datas) {				
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			
			pw.close();
			
		} catch (IOException e) {
			System.out.println("파일 저장시 문제 발생");
		}
		
	}
	
		
	// 파일에서 데이터 읽기
	/*
	  	나오는 데이터 : String[]	  
	 */
	public String[] loadData() {
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// data의 수를 조사
			int count = 0;
			String str = "";
			
			while((str = br.readLine()) != null) {
				count++;					
			}
			br.close();
			
			if(count == 0) {				
				return null;
			}
			
			// 동적할당
			datas = new String[count];
			
			// data를 저장
			br = new BufferedReader(new FileReader(file));
			int j = 0;
			while((str = br.readLine()) != null) {
				datas[j] = str;
				j++;
			}
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	

}









