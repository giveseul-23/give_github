package fileProc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class practice {

	public static void main(String[] args) throws IOException {
		//파일생성
		File f = creatFile("test");
		
		//파일쓰기
		String str[] = {"안녕하세요","건강하세요","행복하세요"};
		boolean b = dataSave(f, str);
		if(b==true) {
			System.out.println("파일쓰기에 성공하였습니다.");
		}else {
			System.out.println("파일쓰기에 실패하였습니다.");
		}
		//파일 읽기
		String datas[] = dataLoad(f);
		
		for (String s : datas) {
			System.out.println(s);
		}
	}
	
	//파일생성 	 -> 파일명
	static File creatFile(String filename) {
		File f = new File("c:/JAVAP/"+filename+".txt");
		
		if(f.exists()) {
			System.out.println("파일이 존재합니다.");
		}
		else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(filename+" 파일을 생성했습니다");
		}
		
		return f;
	}
	
	//파일쓰기, 추가쓰기
	static boolean dataSave(File f, String datas[]) {
		FileWriter fw;
		try {
			fw = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		BufferedWriter bw = new BufferedWriter(fw); //한 문장으로
		PrintWriter pw = new PrintWriter(bw);
		
		for (int i = 0; i < datas.length; i++) {
			pw.println(datas[i]);
		}
		
		pw.close();
		
		return true;
	}
	
	
	//파일 읽기 -> output
	//파일에 모든 데이터를 String[]
	static String[] dataLoad(File f) throws IOException {
		String datas[] = null;
		
	
		try {
			FileReader fr = new FileReader(f);//파일에 있는 내용을 읽어라
			
			//데이터 수 취득
			int count = 0;	//배열의 수
			String str;	//문자열
			BufferedReader br = new BufferedReader(fr);
			//읽는 저장공간에 읽었던 파일내용을 저장함
			
			while((str = br.readLine())!= null) {
				count++; //문장의 길이만큼 카운트를 해줌
			}
			
			br.close();	//파일을 닫아줌(열었을때는 무조건 닫아주는 구문을 작성해야한다.)
			
			//데이터 수에 맞게 할당
			fr = new FileReader(f); //다시 초기화
			datas = new String[count]; //읽어들였던  count수만큼 배열의 갯수를 만든다.
			
			//데이터의 취득
			br = new BufferedReader(fr); //초기화
			int i = 0;
			while((str = br.readLine()) != null) {
				//문장이 끝날때 까지
				datas[i] = str;	//파일안에 "~"텍스트를 하나하나 저장해줌
				i++;
			}
			
			br.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//예외
		}
		
		
		return datas;
		
	}
}
