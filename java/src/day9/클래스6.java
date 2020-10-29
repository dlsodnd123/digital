package day9;

import java.util.Scanner;

public class 클래스6 {

	public static void main(String[] args) {
		GreenComputerStudent c = new GreenComputerStudent();
		c.Enrollment();

	}

}
/* 그린 컴퓨터 아트 학원 수강생(전 지점)을 관리하기 위한 클래스를 만들어보세요
 * 멤버 변수 : 수강생이름, 수강생나이, 수강생연락처, 수강생등록지점, 수강과목 => String name, int age, String phoneNumber, String academy, String subject
 * 멤버 메소드 :수강생정보 등록, 수강생정보 조회
 * 클래스명 : GreenComputerStudent
 * */
class GreenComputerStudent {
	private String [] name = new String[5];
	private int [] age = new int[5];
	private String [] phoneNumber = new String[5];
	private String [] academy = new String[5];
	private String [] subject = new String[5];
	
	//수강생정보 등록
	public void Enrollment() {
		for(int i = 0; i<name.length ; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.print("이름을 입력하세요 : ");
			name[i] = scan.next();
			
			System.out.print("나이를 입력하세요 : ");
			age[i] = scan.nextInt();
			
			System.out.print("연락처를 입력하세요 : ");
			phoneNumber[i] = scan.next();
			
			System.out.print("지점을 입력하세요 : ");
			academy[i] = scan.next();
			
			System.out.print("수강과목 입력하세요 : ");
			subject[i] = scan.next();
			
			scan.close();
		}
	}
	//수강생정보 조회
	public void print() {
		for(int i = 0; i<name.length ; i++) {
			System.out.println("---수강생 정보---");
			System.out.println("이름 : "+name);
			System.out.println("나이 : "+age);
			System.out.println("연락처 : "+phoneNumber);
			System.out.println("등록지점 : "+academy);
			System.out.println("수강과목 : "+subject);
		}
	}
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getAge() {
		return age;
	}
	public void setAge(int[] age) {
		this.age = age;
	}
	public String[] getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String[] getAcademy() {
		return academy;
	}
	public void setAcademy(String[] academy) {
		this.academy = academy;
	}
	public String[] getSubject() {
		return subject;
	}
	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	public GreenComputerStudent(){}
	
}
 