package main;

import student.studentClass;

public class mainClass {

	public static void main(String[] args) {
		
		studentClass stu = new studentClass();
		stu.setNumber(1);
		stu.setName("홍길동");
		stu.setLanguage(95);
		stu.setMath(100);
		stu.setEnglish(85);
		
		String name = stu.getName();
		System.out.println("name : "+name);//홍길동
		
		String[][] student = {
				{"aaa","90","80","85"},
		};
		
		studentClass students[] = new studentClass[3];	//객체배열
		// == studentClass students1, students2, students3
		
		//같은 형식은 빌리지만 동적할당은 다 다르게 저장해서 해줌 - studentClass를 복사하는것도X
		//형식만 같을뿐 저장소는 다 다름
		//왜냐하면 name에 다 다른 이름이 저장되어야 하기 때문에
		students[0] = new studentClass();	//생성을 무조건 해줘야함 - 그래야 동적할당이 됨
		students[1] = new studentClass();
		students[2] = new studentClass();
		
		
		students[0].setName("aa");
		students[0].setNumber(1);
		students[0].setLanguage(90);
		students[0].setMath(100);
		students[0].setEnglish(95);
	}

}
