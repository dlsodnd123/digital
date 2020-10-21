package day3;

public class For문1 {

	public static void main(String[] args) {
		/*
		 * 반복문 : 규칙적인 작업을 반복적으로 할 때 사용하는 문법
		 * 종류 : for문, while문, do while문
		 *  - for문과 while문은 문법은 다르지만 동작 방식은 같다
		 *  - do while문은 다르다
		 
		 * <for문>
		 * for(1.초기화; 2.조건식; 4.증감연산식){
		 * 	  3.실행문;
		 * }
		 * 1. 초기화 : 조건식이나 실행문에서 사용하는 변수를 초기화, 반복문 실행시 처음만 실행된다. 생략 가능
		 * 2. 조건식 : 반복문에 반복을 결정하는 식으로 참이면 반복하고 거짓이면 그만한다. 생략 가능(생략하면 무조건 참)
		 * 4. 증감연산식 : 조건식에서 사용하는 변수를 증가/감소시켜서 반복횟수를 결정한다. 생략 가능
		 */
		
	int num;
	//num = num + 1 // num++ // ++num
	/*
	 * 1부터 10까지 출력하는 예제
	 * 반복횟수 : num이 1부터 10까지 1씩증가
	 *  - 초기화 : num은 1부터
	 *  - 조건식 : num가 10까지 => 10보다 작거나 같다
	 *  - 증감연산식 : num가 1씩 증가
	 * 규칙성(실행문) : num를 출력
	 * 반복문 종료 후 : 없음(예제에 따라 다름)
	 * */

	for(num = 1 ; num <= 10 ; num = num + 1) {
		System.out.print(num+" ");
	}
	
	System.out.println();
	/* 10부터 1까지 출력하는 예제
	 * 반복횟수 : num이 10부터 1까지 1씩감소
	 *  - 초기화 : num은 10부터
	 *  - 조건식 : num가 1까지 => 1보다 크거나 같다
	 *  - 증감연산식 : num가 1씩 감소
	 * 규칙성 : num을 출력
	 * 반복문 종류 후 : 없음
	 */
	
	for(num = 10 ; num >= 1 ; num--) {
		System.out.print(num + " ");
	}
	System.out.println();	
	/* 1부터 10사이의 모든 짝수를 출력하는 예제
	 * 반복횟수 : num이 2부터 10까지 2씩증가
	 *  - 초기화 : num는 2부터
	 *  - 조건식 : num가 10까지 => 10보다 작거나 같다
	 *  - 증감연산식 : num가 2씩
	 * 규칙성 : num를 출력
	 */
	for(num = 2 ; num <= 10 ; num = num + 2 ) {
		System.out.print(num + " ");
	}
	System.out.println();
	 /* 반복횟수 : num이 1부터 10까지 1씩증가
	 *  - 초기화 : num는 1부터
	 *  - 조건식 : num가 10까지 => 10보다 작거나 같다
	 *  - 증감연산식 : num가 1씩
	 * 규칙성 : num가 짝수이면 num를 출력
	 */
	
	for(num = 1 ; num <= 10 ; num++ ) {
		if(num % 2 == 0) {
			System.out.print(num + " ");
		}
	}
	System.out.println();
	/* 구구단 7단을 출력하는 예제
	 * 반복횟수 : num는 1부터 9까지 1씩 증가
	 *  - 초기화 : num는 1부터
	 *  - 조건식 : num가 9까지 => 9보다 작거나 같다
	 *  - 증감연산식 : num가 1씩증가
	 * 규칙성 : 7 x num = 7 * num를 출력
	 */
	
	
	for( num = 1 ; num <= 9 ; num++ ) {
		System.out.println("7 x " + num + " = " + num*7 );
	}
	}
}
