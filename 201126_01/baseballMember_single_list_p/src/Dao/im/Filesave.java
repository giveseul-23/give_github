package Dao.im;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Dao.MemberDao;
import Single.SingleClass;
import dto.Human;

public class Filesave implements MemberDao{
	
	private File f;
	
	public Filesave(String fname) {
		f = new File("C:/JAVAP/"+fname+".txt");
	}
	
	public void createFile() {
		try {
			if(f.createNewFile()) {
				System.out.println("파일생성 성공!");
			}else {
				System.out.println("파일생성 실패!");
			}
		} catch (IOException e) {
			System.out.println("파일 입출력 문제발생");
		}
	}

	@Override
	public void proc() {
		SingleClass si = SingleClass.getInstance();
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			
			for (int i = 0; i < si.getList().size(); i++) {
				Human h = si.getList().get(i);
				pw.println(h);
			}
			
			pw.close();
		} catch (Exception e) {
			System.out.println("파일저장 문제 발생");
		}
	}
	
}
