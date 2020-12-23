package review2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test08_01 {

	public static void main(String[] args) {
		/* 정수 n을 입력 받고 입력받은 수만큼 단어와 뜻을 입력받아 저장하고 출력하는 코드를 작성하세요. */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력 하세요 : ");
		int num = scan.nextInt();
		
		ArrayList<String> word = new ArrayList<String>();
		ArrayList<String> meaning = new ArrayList<String>();
		
		for(int i=0; i<num; i++) {
			System.out.print("단어를 입력하세요 : ");
			String str = scan.next();
			word.add(str);
			System.out.print("뜻을 입력하세요 : ");
			str = scan.next();
			meaning.add(str);
		}
		System.out.println();
		for(int i=0; i<word.size(); i++) {
			System.out.println(word.get(i) + " : " + meaning.get(i));
		}
		System.out.println();
		System.out.print("검색할 단어를 입력하세요 : ");
		String str = scan.next();
		if(word.indexOf(str) != -1) {
			int i = word.indexOf(str);
			System.out.println(word.get(i) + " : " + meaning.get(i));
		}
		scan.close();
		
	}

}







