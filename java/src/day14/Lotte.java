package day14;
/* 사용자번호 클래스의 필요한 멤버/메소드를 생성하시오
 * 6개짜리 로또 번호를 생성하는 클래스
 * - 멤버 변수 : 6개짜리 로또 번호
 * - 멤버 메소드: 랜덤번호생성
 * - 생성자 
 * */
public class Lotte {
	protected int [] numbers = new int [6];
	
	public void print() {
		for(int i = 0; i<=numbers.length; i++) {
			System.out.print("로또 번호 : ");
			System.out.print(numbers[i] + " ");
		}
	}
	
	//로또번호 자동입력
	public void lotteNumbers(int arr[]) {
		int cnt = 0;
		while(cnt < arr.length) {		
			int r = random();	
			if(!isContain(arr,r)) {		
				arr[cnt] = r;			
				cnt++;
			}
		}
	}
	
	static boolean isContain(int []arr, int num) {
		for(int tmp : arr) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	
	static int random() {
		return (int)((45 - 1 +1) * Math.random() + 1);
	}



	public Lotte(int[] numbers) {
		super();
		this.numbers = numbers;
	}
	
	
}

