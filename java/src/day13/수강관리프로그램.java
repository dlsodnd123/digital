package day13;

import java.util.Scanner;

public class 수강관리프로그램 {

	public static void main(String[] args) {
		/*
		Subject s = new Subject("대학수학", "MSC001", "이순신", 4, 4, 2020, "2학기", "공통필수", "월1A, 월1B, 수1A, 수1B");
		//System.out.println(s);
		Student std = new Student("홍길동", "000101-3234567", "2020160123", "컴퓨터공학부", "소프트웨어과", 2);
		std.insertSubject(s);
		std.print();
		System.out.println("----------------");
		std.insertSubject(new Subject("대학영어", "MSC001", "유관순", 4, 4, 2020, "2학기", "공통필수", "월1A, 월1B, 수1A, 수1B"));
		std.print();
		System.out.println("----------------");
		std.deleteSubject("대학수학");
		std.print();
		*/
		Scanner scan = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		char menu = '0';
		do {
			sm.printMenu();
			menu = scan.next().charAt(0);
			switch(menu) {
			case '1': sm.insertStudent(scan);    break;
			case '2': sm.printStudent();     break;
			case '3': sm.searchStudent(scan);    break;
			case '4': sm.registerSubject(scan);  break;
			case '5': sm.deleteSubject(scan);    break;
			case '6': break;
			default:
				sm.printAlert();
			}
			
		}while(menu != '6');
		sm.printExit();
		scan.close();
	}
	
	

}
/* 학생 클래스의 필요한 멤버 변수/메소드를 생성하세요. 
 * - 학생 1명의 정보를 나타내는 클래스
 * - 멤버 변수 : 학생이름, 주민번호, 학번, 학부, 학과, 수강과목들, 학기(현재학생이 수료한 학기)
 * - 멤버 메소드: getter/setter, print(), 수강 과목 추가, 수강 과목 삭제, 
 * 				수강 과목 복사(private) : 수강과목 추가시 배열이 다 차있으면 배열의 크기를 늘림
 *				equals() : 오버라이딩
 * - 생성자
 * */
