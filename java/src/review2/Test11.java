package review2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		/* 단어장 프로그램을 작성하세요. 
		 * 1. 단어 등록
		 * 2. 단어 검색
		 * 3. 단어 수정
		 * 4. 단어 출력
		 * 5. 종료
		 * */
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		do {
			System.out.println("------- 메뉴 ---------");
			System.out.println("1. 단어 등록");
			System.out.println("2. 단어 검색");
			System.out.println("3. 단어 수정");
			System.out.println("4. 단어 출력");
			System.out.println("5. 종료");
			System.out.println("--------------------");
			System.out.println("메뉴를 선택해주세요 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1 : 
			case 2 :
			case 3 : 
			case 4 :
			case 5 : 
				System.out.println("프로그램종료!!");
				break;
			default :
			}
			
		}while(menu !=5);
		
		scan.close();
	}

}
class WordBook{
	private String word;
	private String mean;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	
	public WordBook() {}
	
	public WordBook(String word, String mean) {
		this.word = word;
		this.mean = mean;		
	}
	
	@Override
	public String toString() {
		return "[" + word + " : " + mean + "]";
	}
	//단어 등록
	public void wordAdd(Scanner scan) {
		System.out.print("단어 입력 : ");
		String word = scan.next();
		System.out.print("의미 입력 : ");
		String mean = scan.next();
		
	}
	//단어 검색
	
	//단어 수정
	
	//단어 출력
	
}