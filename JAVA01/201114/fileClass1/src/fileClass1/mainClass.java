package fileClass1;

import java.io.File;
import java.io.IOException;

public class mainClass {
	public static void main(String[] args)
			/*throws Exception*/ {
		/*
			source code -> 알고리즘(logic)
			
			file :  저장 매체 -> 기능 	== Database
					데이터 저장, 불러오기
					
			*.txt
			*.jpg *.dll *.lib *.jar *.bmp -> bitmap
			
					dynamic link library(동적 파일)					
					library(정적 파일)			
		*/
		
		// 파일 목록
		//File fdir = new File("C:\\");
		
		/*
		String filelist[] = fdir.list();		
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		
		/*
		// 파일, 폴더, 그외
		File fdir = new File("C:\\");
		File filelist[] = fdir.listFiles();
		
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {		// 파일
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) {	// 폴더
				System.out.println("[폴더]" + filelist[i].getName());
			}
			else {	// ?
				System.out.println("[?]" + filelist[i].getName());				
			}			
		}
		
		*/
		
		// 파일 생성
		String fileStr = "D:\\tmp\\newfile.txt";
		File newfile = new File(fileStr);
		
		
		try {
			
			if(newfile.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패");
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//파일의 존재여부
		if(newfile.exists() == true) {
			System.out.println("파일이 존재합니다.");
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		/*
		//파일삭제
		if(newfile.delete()) {
			System.out.println("파일을 삭제하였습니다.");
		}else {
			System.out.println("파일 삭제하지 못했습니다.");
		}
		*/
		
		//파일 읽기가능
		if(newfile.canRead()) {
			System.out.println("파일을 읽기 가능합니다.");
		}else {
			System.out.println("파일을 읽기 불가능합니다.");
		}
		
		//읽기전용
		//newfile.setReadOnly(); // -> 읽기만 가능해서 쓰기는 불가능
		newfile.setWritable(true);
		
		//파일 쓰기(==편집)가능
		if(newfile.canWrite()) {
			System.out.println("파일쓰기가 가능합니다.");
		}else {
			System.out.println("파일쓰기가 불가능합니다.");
		}
		
	}

}










