package day6;

import java.util.Scanner;

public class 배열5 {

	public static void main(String[] args) {
/* 3명의 국어 점수를 입력받아 배열에 저장하고, 3명의 국어 점수의 총점과 평균을 구하는 예제 */
		
		int size = 3;
		int kor[] = new int[size];
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		double avg;
		
		for( int i = 0 ; i < kor.length ; i++) {
			System.out.print(i+1 + "번 학생의 국어성적 : ");
			kor[i] = scan.nextInt();
			sum = sum + kor[i];
		}
		avg = (double)sum / kor.length;
		System.out.println("3명 학생의 총점 : " + sum);
		System.out.println("3명 학생의 평균 : " + avg);
		scan.close();

	}

}
