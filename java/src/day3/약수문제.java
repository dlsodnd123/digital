package day3;

import java.util.Scanner;

public class 약수문제 {

	public static void main(String[] args) {
		/* num를 입력받아 입력받은 num가 약수들을 출력하는 예제
		 * 약수 : 나누어 떨어지는 수
		 * 12의 약수 : 1 2 3 4 6 12
		 * 반복횟수 : 1씩증가
		 *  - 초기화 : i는 1부터 
		 *  - 조건식 : i는 1부터 num까지 => i는 num보다 작거나 같다
		 *  - 증감연산자 : i는 1씩 증가
		 * 규칙성 : num % i == 0 같다면 i를 출력
		 * 반복문 종류후 :
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int i, num;
		System.out.print("정수를 입력하세요 : ");
		num = scan.nextInt();
		
		for( i=1 ; i <= num ; i++ ) {
			if(num % i == 0) {
				System.out.print(i + " ");
			}
		}
		
		
		scan.close();

	}

}
