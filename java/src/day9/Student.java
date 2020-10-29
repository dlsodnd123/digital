package day9;

public class Student {
	private String name;
	private int age;
	private String phoneNumber;
	private String academy;
	private String subject;
	
	//수강생정보 조회
	public void print() {
		System.out.println("---수강생 정보---");
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("연락처 : "+phoneNumber);
		System.out.println("등록지점 : "+academy);
		System.out.println("수강과목 : "+subject);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Student(){}
}
