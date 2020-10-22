package day4;

public class 이중for문 {

	public static void main(String[] args) {
		/* for(1.초기화; 2.조건식; 3.증감식){
		 *     for(4.초기화; 5.조건식; 6.증감식{
		 *       실행문1;
		 *     }
		 *     기타실행문;
		 * }
		 * 1,2,3에서 사용하는 변수와 4,5,6에서 사용하는 변수가 일반적으로 다르다.

		 * *****
		 * *****
		 * *****
		 */
		
		int i, j;
		for(i = 1; i <= 5; i++) {
			for(j = 1 ; j <= 10 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/* 구구단 2단에서 9단까지 출력하는 예제
		 * 반복횟수 : num은 1부터 9까지 1씩증가
		 * 규칙성 : 7 x num = 7 * num출력
		 */
		
		int num = 2;
		for( num = 2 ; num<=9 ; num ++) {
			for( i = 1 ; i <= 9 ; i++ ) {
				System.out.println(num + " x " + i + " = " + num*i);
			}
		}
		/* num가 소수인지 아닌지 판별하는 예제
		 * 
		 */
		int cnt = 0;
		
		for( num = 2 ; num <= 100 ; num++ ) {
			for( i = 1, cnt = 0 ; i <= num ; i ++ ) {
				if(num % i == 0) {
					cnt++;
				}
			}
			if(cnt == 2) {
				System.out.print(num + " ");
			}
		}				
	}
}
