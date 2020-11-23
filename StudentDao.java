package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import student.Student;

public class StudentDao {
	Scanner sc = new Scanner(System.in);
	
	
	private List<Student> list = new ArrayList<Student>();
	//private int memberNumber;
	
	Student is = new Student();
	
	//배열의 갯수는 외부에서 들어옴
	public StudentDao() {
		//memberNumber = 0;
		
		list.add(new Student(1, "홍길동", 100, 90, 80));
		list.add(new Student(2, "일지매", 90, 85, 90));
		list.add(new Student(3, "성춘향", 100, 100, 95));
		
	}
	
	//CRUD - 추가, 삭제, 검색, 수정
	public void insert() {	//create
			//int studentArr[];
		
			System.out.print("학생번호를 입력하세요 : ");
			int num = sc.nextInt();
			is.setNumber(num);
			
			System.out.print("학생이름을 입력하세요 : ");
			String name = sc.next();
			is.setName(name);
			
			System.out.print("국어점수를 입력하세요 : ");
			int lang = sc.nextInt();
			is.setLang(lang);
			
			System.out.print("수학점수를 입력하세요 : ");
			int math = sc.nextInt();
			is.setMath(math);
			
			System.out.print("영어점수를 입력하세요 : ");
			int eng = sc.nextInt();
			is.setEng(eng);
			
			list.add(new Student(num, name, lang, math, eng));
		
	}
	
	public void delete() {	//삭제
		System.out.print("삭제할 학생명 = ");
		String name = sc.next();
		
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(name.equals((list.get(i)).getName())) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			list.remove(index);
			System.out.println("성공적으로 삭제하였습니다.");
		}else {
			System.out.println("학생 데이터를 찾을 수 없습니다.");
		}
	}
	
	
	public void select() { //search
		System.out.print("검색할 학생명 = ");
		String name = sc.next();
		
		List<Student> flist = new ArrayList<Student>();
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			if(name.equals(s.getName())) {
				flist.add(s);
			}
		}
		
		if(!flist.isEmpty()) {
			System.out.println("검색된 데이터 >>");
			for (int i = 0; i < flist.size(); i++) {
				System.out.println(flist.get(i).toString());
			}
		}else {
			System.out.println("학생 데이터를 찾을 수 없습니다.");
		}
		
		/*
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(name.equals((list.get(i)).getName())) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			System.out.println(list.get(index));
		}else {
			System.out.println("학생 데이터를 찾을 수 없습니다.");
		}
		*/
	}
	
	
	public void update() { //수정
		System.out.print("수정할 학생명 = ");
		String name = sc.next();
		
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(name.equals((list.get(i)).getName())) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("학생 데이터를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("수정할 데이터를 입력 해 주십시오 >>");
		System.out.print("국어 = ");
		int lang = sc.nextInt();
		
		System.out.print("수학 = ");
		int math = sc.nextInt();
		
		System.out.print("영어 = ");
		int eng = sc.nextInt();
		
		Student s = list.get(index);
		
		s.setLang(lang);
		s.setMath(math);
		s.setEng(eng);
		
		System.out.println("수정되었습니다.");
	}
	
	public void allPrint() {
		System.out.println(list.toString());
	}
	
	//list배열 일반배열 복사
	
	public void arraySort() {
	//	List<Student> sortlist = new ArrayList<Student>(list);
		LinkedList<Student> sortlist = new LinkedList<Student>();
		
		for (Student s : list) {
			sortlist.add(s);	//list에서 sortlist로 넘겨받음
		}
		
		Student stu  = null;
		for (int i = 0; i < sortlist.size() -1; i++) {	//sortlist로 하는 이유는 원본 데이터를 유지하기 위해
			for (int j = i+1; j < sortlist.size(); j++) {
				int num1 = sortlist.get(i).getEng();
				int num2 = sortlist.get(j).getEng();
				
				if(num1 < num2) {
					stu = sortlist.get(i);
					sortlist.set(i, list.get(j));
					sortlist.set(j, stu);
				}
				
			}
		}
		
		System.out.println("정렬된 영어점수 : 내림차순 >>");
		for (int i = 0; i < sortlist.size(); i++) {
			Student s = sortlist.get(i);
			System.out.println(s.toString());
		}
	}
	
	/*
	public Student[] array_copy() {
		Student arrStudent[] = new Student[list.size()];
		for (int i = 0; i < arrStudent.length; i++) {
			arrStudent[i] = list.get(i);
		}
		
		
		for(int i = 0; i<arrStudent.length; i++){ 
				//데이터 복사
				arrStudent[i].setNumber((list.get(i)).getNumber());
				arrStudent[i].setName((list.get(i)).getName());
				arrStudent[i].setLang((list.get(i)).getLang());
				arrStudent[i].setMath((list.get(i)).getMath());
				arrStudent[i].setEng((list.get(i)).getEng());
		}
		
		return arrStudent;
	}
	
	//국어
	public void langsorting() {
		
		Student arrStudent[] = array_copy();
		
		langSortProc(arrStudent);
		
		System.out.println("국어점수의 순위 >>");
		
		for (Student s : arrStudent) {
			if(s != null) {
				System.out.println(s.toString());
			}
		}

	}
	
	//수학
		public void mathsorting() {
			
			Student arrStudent[] = array_copy();
			
			mathSortProc(arrStudent);
			
			System.out.println("수학점수의 순위 >>");
			
			for (Student s : arrStudent) {
				if(s != null) {
					System.out.println(s.toString());
				}
			}

		}
		
		//영어
				public void engsorting() {
					
					Student arrStudent[] = array_copy();
					
					engSortProc(arrStudent);
					
					System.out.println("영어점수의 순위 >>");
					
					for (Student s : arrStudent) {
						if(s != null) {
							System.out.println(s.toString());
						}
					}

				}

	
	//국어 우선순위
	public void langSortProc(Student arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] != null) {
					if(arr[i].getLang() < arr[j].getLang()) {
						swap(arr, i, j);
					}
				}
			}
		}
	}
	
	//수학 우선순위
	public void mathSortProc(Student arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] != null) {
					if(arr[i].getMath() < arr[j].getMath()) {
						swap(arr, i, j);
					}
				}
			}
		}
	}
	
	//영어 우선순위
	public void engSortProc(Student arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] != null) {
					if(arr[i].getEng() < arr[j].getEng()) {
						swap(arr, i, j);
					}
				}
			}
		}
	}
	
	public void swap(Student arr[], int i, int j) {
		Student temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	/**/
	
}
