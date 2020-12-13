package fileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainClass {

	public static void main(String[] args)  {
		//file read
		try {
			//File file = new File("D:\\tmp\\text.txt");
			File file = new File("D:\\tmp\\newfile.txt");
			//instance, object
			
			
			FileReader fr = new FileReader(file);
				//파일이 없을수도 있어서 오류가 발생하니
					//- throws FileNotFoundException를 넣는다.
			
			
			
			//한문자씩 읽어들임
			/*	
			String str = "";
				
			int c = fr.read(); //한문자씩 읽어들임
			
			while(c != -1) {	// -1 == 파일의 끝
				System.out.println((char)c);
				str = str + (char)c;
				c = fr.read();
			}
			
			System.out.println(str);
			*/
			
			String str = "";
			
			//문장으로 읽는다				Buffer == 저장공간
			BufferedReader br = new BufferedReader(fr);
			
			while(( str = br.readLine() ) != null) { //파일 끝이 아닐때 까지
				System.out.println(str);
			}
			br.close(); //파일을 읽을때는 항상 닫아줘야 함
		}
		
		catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 읽어들일 수 없습니다.");
		}
		
	}
	
	
	
	
}
