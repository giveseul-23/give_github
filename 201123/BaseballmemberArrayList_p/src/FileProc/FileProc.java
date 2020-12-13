package FileProc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dto.Human;

public class FileProc {
	
	private File f;
	
	public FileProc(String filename) {
		f = new File("D:/tmp/"+filename+".txt");
	}
	
	//파일생성
	public void creatfile() {
		try {
			if(f.createNewFile()) {
				System.out.println("파일생성 성공");
			}else {
				System.out.println("파일생성 실패");
			}
		} catch (IOException e) {
			System.out.println("파일 입출력 문제발생");
		}
	}
	
	//파일쓰기(save)
	public void saveData(String []datas) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 저장시 문제 발생");
		}
		
		
	}
	
	//파일읽기(load)
	public String[] loadDate() {
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			//data수 조사
			int count = 0;
			String str = "";
			
			while((str = br.readLine()) != null) {
				count++;
			}
			br.close();
			
			if(count == 0) {
				return null;
			}
			
			//동적할당
			datas = new String[count];
			
			//data를 저장
			br = new BufferedReader(new FileReader(f));
			
			int j = 0;
			while((str = br.readLine()) != null) {
				datas[j] = str;
				j++;
			}
			
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return datas;
		
	}
}
