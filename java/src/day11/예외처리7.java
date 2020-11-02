package day11;

public class 예외처리7 {

	public static void main(String[] args) {
		mathod1();
		mathod2();
	}
	public static void mathod1() {
		try {
			System.out.println("mathod1이 실행중입니다.");
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("메소드1 종료");
	}
	
	public static void mathod2() {
		try {
			System.out.println("mathod2이 실행중입니다.");
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("메소드2 종료");
		}
	}
}

/* 예외처리 정리
 * - 예외처리 방법
 *  1. 예외가 발생한 메소드가 직접 처리
 *   try~catch문
 *  2. 예외가 발생한 메소드가 직접 처리하지 않고 해당 메소드를 호출한 메소드에게 시키는 방법
 *   throw
 * - 예외종류 RuntimeException
 * - finally 리턴문이 있어도 finally문을 실행하고 나감.  
 *  */
