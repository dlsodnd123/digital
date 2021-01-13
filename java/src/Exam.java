import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술 연산자를 입력하세요.(예 : 1 + 2)");
		int num1 = scan.nextInt();
		char calc = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		calc(num1,calc,num2);
		
		scan.close();
	}
	private static void calc(int num1, char calc, int num2) {
		double result = 0;
		if(calc != '+' && calc != '-' && calc != '*' && calc != '/' && calc != '%') {
			System.out.println("산술연산자는 +, -, *, /, % 만 입력가능합니다.");
			return;
		}
		if(calc == '+') {
			result = num1 + num2;
		}else if(calc == '-') {
			result = num1 - num2;
		}else if(calc == '*') {
			result = num1 * num2;
		}else if(calc == '/') {
			if(num1 == 0 || num2 == 0) {
				System.out.println("0으로는 나눌수 없습니다.");
				return;
			}
			result = num1 / (double)num2;
		}else if(calc == '%') {
			if(num1 == 0 || num2 == 0) {
				System.out.println("0으로는 나눌수 없습니다.");
				return;
			}
			result = num1 % num2;
		}
		System.out.println(num1 + " " + calc + " " + num2 + " = " + result);
		return;
	}
}
