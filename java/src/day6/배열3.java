package day6;

public class 배열3 {

	public static void main(String[] args) {
		/* 10개짜리 배열을 생성하여 0번지에 1, 1번지에 2 ... 9번지에 10을 저장하고 출력하는 예제
		 * 
		 */
		int size = 10;
		int arr1[] = new int[size];
		
		
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;
		arr1[5] = 6;
		arr1[6] = 7;
		arr1[7] = 8;
		arr1[8] = 9;
		arr1[9] = 10;
		
		System.out.println("arr[" + 0 + "]=" + arr1[0]);
		System.out.println("arr[" + 1 + "]=" + arr1[1]);
		System.out.println("arr[" + 2 + "]=" + arr1[2]);
		System.out.println("arr[" + 3 + "]=" + arr1[3]);
		System.out.println("arr[" + 4 + "]=" + arr1[4]);
		System.out.println("arr[" + 5 + "]=" + arr1[5]);
		System.out.println("arr[" + 6 + "]=" + arr1[6]);
		System.out.println("arr[" + 7 + "]=" + arr1[7]);
		System.out.println("arr[" + 8 + "]=" + arr1[8]);
		System.out.println("arr[" + 9 + "]=" + arr1[9]);
		System.out.println("---------------------------");
		
		for(int i = 0; i < size; i++) {
			arr1[i] = i+1;
			System.out.println("arr[" + i + "]=" + arr1[i]);
		}
	}
}
