package day3;

public class For문3 {

	public static void main(String[] args) {
		/* 1부터 100까지 2의 배수들을 출력하는 예제
		 * 반복횟수 : i는 2부터 100까지 출력
		 *  - 초기화 : i는 2부터
		 *  - 조건식 : i는 2부터 100까지 => i는 100보다 크거나 같다
		 *  - 증감연산자 : i = i + 2
		 * 규칙성 : i출력
		 */
		int i;
		for( i = 2 ; i <= 100 ; i = i + 2 ) {
			System.out.print(i + " ");
			//i가 10의 배수이면 엔터
			if(i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	

	}

}
