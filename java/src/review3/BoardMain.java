package review3;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/* 1. 게시글 등록
		 * 2. 게시글 조회 // 특정 목록 선택
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 게시글 목록 
		 * 6. 종료
		 * 번호 제목 작성자 작성일
		 * 게시글
		 * 	- 번호, 제목, 내용, 작성자, 작성일
		 * */
		
		int menu;
		ArrayList<Board> list = new ArrayList<Board>();
		do {
			printMenu();
			menu = scan.nextInt();
			String tmpTitle;
			switch(menu) {
			case 1:
				// 게시판에 게시글 등록
				System.out.println("게시글 등록");
				enrollMentBoard(list);
				break;
			case 2:
				// 게시글의 제목을 검색하여 콘솔에 출력
				System.out.println("게시글 조회");
				tmpTitle = inputtitle();
				searchTilte(list, tmpTitle);
				break;
			case 3:
				// 게시글의 제목을 검색하여 제목과 같은 게시글 수정
				System.out.println("게시글 수정");
				// inputNum();
				// modifyBoard();
				break;
			case 4:
				// 게시글의 제목을 검색하여 제목과 같은 게시글 삭제
				System.out.println("게시글 삭제");
				tmpTitle = inputtitle();
				deleteBoard(list, tmpTitle);
				break;
			case 5:
				// 게시글 목록을 번호순서대로(최신글이 위로)정렬하여 출력
				System.out.println("게시글 목록");
				//sortBorad();
				printBorad(list);
				break;
			case 6:
				System.out.println("종료");
				break;
				
			}
		}while(menu != 6);
		System.out.println("프로그램 종료!!");
		scan.close();
	}
	private static void printMenu() {
		System.out.println("------------------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 게시글 목록");
		System.out.println("6. 종료");
		System.out.println("------------------------");
		System.out.print("메뉴 선택(1~6) : ");
	}
	/* 기능 : 게시판에 게시글 등록하는 메소드
	 * 매개변수 : 게시글 => ArrayList<Board> list
	 * 리턴타입 : 없음 => void
	 * 메소드명 : enrollMentBoard
	 * */
	private static void enrollMentBoard(ArrayList<Board> list) {
		Board tmp = new Board();
		System.out.println("------------------------");
		System.out.println("	게시글 등록");
		System.out.println("------------------------");
		System.out.print("제목 : ");
		tmp.setTitle(scan.next());
		System.out.println("내용 : ");
		tmp.setContents(scan.next());
		System.out.print("작성자 : ");
		tmp.setWriter(scan.next());
		System.out.print("작성일 : ");
		tmp.setDateCreated(scan.next());
		list.add(tmp);
	}
	/* 기능 : 검색/수정/삭제할 게시글의 제목을 입력받는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 게시글의 제목 => Board
	 * 메소드명 : inputTitle
	 * */
	private static String inputtitle() {
		System.out.println("------------------------");
		System.out.println("	게시글 제목 입력");
		System.out.println("------------------------");
		System.out.print("제목 : ");
		String tmp = scan.next();
		return tmp;
	}
	/* 기능 : 게시글의 제목을 검색하여 해당하는 게시글을 콘솔에 출력하는 메소드
	 * 매개변수 : 게시글, 제목 => ArrayList<Board> list, Board title
	 * 리턴타입 : 없음 
	 * 메소드명 : searchTilte
	 * */
	private static void searchTilte(ArrayList<Board> list, String title){
		for(Board tmp : list) {
			if(tmp.equals(title.getTitle())) {
				System.out.println("---------검색결과---------");
				System.out.println(tmp);
			}
		}
		System.out.println("------------------------");
		System.out.println("해당 게시글이 없습니다.");
	}
	/* 기능 : 게시글의 제목을 검색하여 제목과 같은 게시글의 내용 수정
	 * 매개변수 : 게시글, 제목 => ArrayList<Board> list, Board title
	 * 리턴타입 : 없음
	 * 메소드명 : modifyBoard
	 * */
	private static void modifyBoard(ArrayList<Board> list, Board title) {
		
	}
	
	/* 기능 : 게시글의 제목을 검색하여 해당하는 게시글 삭제하는 메소드
	 * 매개변수 : 게시글, 제목 => ArrayList<Board> list, Board title
	 * 리턴타입 : 없음
	 * 메소드명 : deleteBoard
	 * */
	private static void deleteBoard(ArrayList<Board> list, Board title) {
		for(int i=0; i<list.size(); i++) {
			Board tmp = list.get(i);
			if(tmp.equals(title.getTitle())) {
				list.remove(i);
			}
		}
	}
	/* 기능 : 게시글을 정렬하는 메소드
	 * 매개변수 : 게시글 => ArraryList<Board> list
	 * 리턴타입 : 없음
	 * 메소드명 : sortBorad
	 * */
	private static void sortBorad(ArrayList<Board> list)  {
		
	}
	/* 기능 : 게시글 목록을 출력하는 메소드
	 * 매개변수 : 게시글 => ArraryList<Board> list
	 * 리턴타입 : 없음
	 * 메소드명 : printBorad
	 * */
	private static void printBorad(ArrayList<Board> list) {
		System.out.println("------------------------");
		System.out.println("	게시글 출력");
		System.out.println("------------------------");
		for(Board tmp : list) {
			System.out.println(tmp);
		}
	}
}

class Board implements Comparable{
	// 번호, 제목, 내용, 작성자, 작성일
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String dateCreated;
	static int count;
		
	public Board(int num, String title, String contents, String writer, String dateCreated) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.dateCreated = dateCreated;
	}
	
	public Board() {
		count++;
		num = count;
	}
	
	@Override
	public String toString() {
		return "번호 : " + num + "\n제목 : " + title + "\n내용 :\n" + contents + "\n작성자 : " + writer
				+ "\n작성일 : " + dateCreated +"\n------------------------";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof String)
			return title.equals(obj);
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public int compareTo(Object o) {
		Board title = (Board) o;
		return this.title.compareTo(title.title);
	}
	
}