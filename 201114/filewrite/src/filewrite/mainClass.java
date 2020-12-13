package filewrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mainClass {

	public static void main(String[] args) throws Exception {
		
		//file write
			//-> 파일이 생성되어있지 않아도 생성해줌
			//변경하고 저장하면 덮어씌어져서 기존 데이터는 사라짐
		
							// == D:\\tmp\\newfile.txt
		File file = new File("D:/tmp/text.txt");
		
		/*
		//한 문자씩 쓰기(기입)
		FileWriter fw = new FileWriter(file);
		fw.write("hello" + "\n");
		fw.close(); //해당 구문을 입력하지 않으면 파일에 쓰기 불가능
		
		
		//추가쓰기
		FileWriter fw = new FileWriter(file,true);
		fw.write("hello" + "\n");
		fw.close();
		*/
		
		//문장으로 쓰기
		FileWriter fw = new FileWriter(file); //파일 object 생성
		BufferedWriter bw = new BufferedWriter(fw); //한 문장으로
		PrintWriter pw = new PrintWriter(bw); 
		 
		pw.print("안녕 ");
		pw.println("하이하이 ");
		pw.println("건강하세요 ");
		
		pw.close();
		bw.close();
		fw.close();
		
		
	}

}
