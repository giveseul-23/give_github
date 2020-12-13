package fileProc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mainClass {

	public static void main(String[] args) throws IOException {
		//파일생성 	 -> 파일명
		File fr = new File("D:/tmp/test.txt");
		
		if(fr.createNewFile()) {
			System.out.println("파일생성 성공");
		}else {
			System.out.println("파일생성 실패");
		}	
		//파일쓰기/추가쓰기 -> input
			FileWriter fw = new FileWriter(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.print("입력1/");
			pw.print("입력2/");
			pw.print("입력3/");
			
			pw.close();
			bw.close();
			fw.close();
			
			FileWriter fw2 = new FileWriter(fr,true);
			fw2.write("입력4");
			fw2.close();
			
			
		//파일읽기 -> output
		FileReader fre = new FileReader(fr);
		
		String str ="";
		String result = null;
		
		BufferedReader br = new BufferedReader(fre);
		
		while((str = br.readLine()) != null) {
			
			result = str;
			System.out.println(result);
			
		}
		br.close();
		
		String array[] = result.split("/");
		
		for (int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		
		
		
	}
	
}
