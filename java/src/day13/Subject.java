package day13;

// ctrl + shift + 방향키 : 블록설정

/* 과목 클래스의 필요한 멤버 변수/메소드를 생성하세요. 
 * 과목 클래스는 한 과목의 정보를 나타내는 클래스
 * - 멤버 변수 : 과목명, 과목코드, 교수명, 시수, 학점, 년도, 학기, 분류, 수업시간
 * - 멤버 메소드 : getter/setter, toString()
 * - 생성자
 * */
public class Subject {
	private String subjectTitle;
	private String subjectCode;
	private String professor;
	private int subjectTime;
	private int subjectPoint;
	private int subjectYear;
	private String subjectTerm;
	private String subjectCategory;
	private String subjectSchedule;
	
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjecTitle(String subjecTitle) {
		this.subjectTitle = subjecTitle;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getSubjectTime() {
		return subjectTime;
	}
	public void setSubjectTime(int subjectTime) {
		this.subjectTime = subjectTime;
	}
	public int getSubjectPoint() {
		return subjectPoint;
	}
	public void setSubjectPoint(int subjectPoint) {
		this.subjectPoint = subjectPoint;
	}
	public int getSubjectYear() {
		return subjectYear;
	}
	public void setSubjectYear(int subjectYear) {
		this.subjectYear = subjectYear;
	}
	public String getSubjectTerm() {
		return subjectTerm;
	}
	public void setSubjectTerm(String subjectTerm) {
		this.subjectTerm = subjectTerm;
	}
	public String getSubjectCategory() {
		return subjectCategory;
	}
	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}
	public String getSubjectSchedule() {
		return subjectSchedule;
	}
	public void setSubjectSchedule(String subjectSchedule) {
		this.subjectSchedule = subjectSchedule;
	}
	@Override
	public String toString() {
		return "과목 [과목명=" + subjectTitle + ", 과목코드=" + subjectCode + ", 담당교수=" + professor
				+ ", 시수=" + subjectTime + ", 학점=" + subjectPoint + ", 년도=" + subjectYear
				+ ", 학기=" + subjectTerm + ", 분류=" + subjectCategory + ", 시간="
				+ subjectSchedule + "]";
	}
	public Subject(String subjecTitle, String subjectCode, String professor, int subjectTime, int subjectPoint,
			int subjectYear, String subjectTerm, String subjectCategory, String subjectSchedule) {
		super();
		this.subjectTitle = subjecTitle;
		this.subjectCode = subjectCode;
		this.professor = professor;
		this.subjectTime = subjectTime;
		this.subjectPoint = subjectPoint;
		this.subjectYear = subjectYear;
		this.subjectTerm = subjectTerm;
		this.subjectCategory = subjectCategory;
		this.subjectSchedule = subjectSchedule;
	}
	public Subject(String sTitle) {
		subjectTitle = sTitle;
	}
	
}
