package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class dataProc {
	private File f;
	
	public dataProc(String filename) {
		f = new File("C:/JAVAP/"+filename+".txt");
	}
	
	//파일생성
	public void creatFile() {
		try {
			if(f.createNewFile()) {
				System.out.println("파일 생성 성공");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			System.out.println("파일 입출력 문제발생");
		}
	}
	
	//파일 쓰기
	public void saveData(String[] datas) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			
			pw.close();
		} catch (IOException e) {
			System.out.println("파일저장 문제발생");
		}
		
	}
	
	//파일 데이터 불러오기
	public String[] loadData() {
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
		
			//데이터 수 조사
			int count = 0;
			String str = "";
			
			while((str = br.readLine()) != null) {
				count++;
			}
			
			br.close();
			
			
			if(count == 0) {
				return null;
			}
			
			//동적 할당
			datas = new String[count];
			
			//data를 저장
			br = new BufferedReader(new FileReader(f));
			int j = 0;
			while((str = br.readLine()) != null){
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
