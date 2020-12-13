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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import dto.Human;

public class FileProc {
	
	private File f;
	
	public FileProc(String filename) {
		f = new File("C:/JAVAP/"+filename+".txt");
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
	public void saveData(HashMap<String, Human> hMap) {
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			Iterator<String> it = hMap.keySet().iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				pw.println(key+"-"+hMap.get(key));
			}
			pw.close();
			System.out.println("저장완료!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 저장시 문제 발생");
		}
		
		
	}
	
	//파일읽기(load)
	public List<String> loadDate() {
		
		List<String> strList = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String str;
			while((str = br.readLine()) != null) {
				strList.add(str);
			}
			
			br.close();
			
		} catch (Exception e) {
			System.out.println("불러오기 오류발생!");
		}
		
		return strList;
		
	}
}
