package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import member.member;

public class DataProc {
	File f;
	
	public DataProc() {
		member m = new member();
	}
	
	public File createFile(String filename) {
		f = new File("D:/tmp/"+filename+".txt");
		
		if(f.exists()) {
			System.out.println("파일이 존재 합니다.");
		}else {
			try {
				f.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(filename+"을 생성했습니다.");
		}
		return f;
		
	}
	
	public void dataSave(File f,  String  datas[]) {
		FileWriter fw;
		try {
			fw = new FileWriter(f,false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for(String str : datas) {
				pw.print(str);
			}
			
			pw.close();
			bw.close();
			fw.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
	}
	
}
