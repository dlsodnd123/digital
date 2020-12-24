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
		WordBook wb = new WordBook();
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
			case 1 : wb.addWord(scan);
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
	private ArrayList<Word> list = new ArrayList<Word>();

	public ArrayList<Word> getList() {
		return list;
	}

	public void setList(ArrayList<Word> list) {
		this.list = list;
	}
	
	public WordBook() {}
	
	public void addWord(Scanner scan){
		System.out.print("단어 : ");
		String word = scan.next();
		System.out.print("의미 : ");
		String mean = scan.next();
		list.add(new Word(word,mean));
	}

}

class Word implements Comparable{
	private String word;
	private String mean;
	
	public Word(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}

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

	@Override
	public int compareTo(Object o) {
		Word word= (Word)o;
		return this.word.compareTo(word.word);
	}

	@Override
	public String toString() {
		return "[" + word + " : " + mean + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(obj instanceof String) {
			return word.equals(obj);
		}
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
	
}