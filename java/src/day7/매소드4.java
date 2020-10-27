package day7;

public class 매소드4 {

	public static void main(String[] args) {
		// 매개변수가 일반 변수이면 매개변수의 값이 바뀌지 않는다.
		// => 텍스트 파일을 복사하여 실행한 후 작업을 하면 원본이 안바뀐다.
		// 매개변수가 참조 변수이면 매개변수의 값이 바뀔수 있다.
		// =>바로가기를 이용하여 프로그램을 실행후 내용을 변경하면 원본이 바뀔수 있다.
		int arr[] = new int[] {1,3,5,7,9,2,4,6,8,10,11};
		printArray(arr);
		//sortArry(arr);
		arr = sortArry2(arr);
		printArray(arr);
		arr = creatArray(5);
		printArray(arr);
	}
	/* 기능 : 주어진 정수 배열의 값들을 콘솔에 출력하는 메소드
	 * 매개변수 : 정수 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 매소드명 : printArray
	 * */
	static void printArray(int arr[]) {
		for(int i = 0 ; i < arr.length ; i++) {
			//5개씩 한줄에 출력하기 위한 코드
			if(i % 5 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	/* 기능 : 주어진 정수 배열을 정렬하는 메소드
	 * 매개변수 : 주어진 정수 배열 => int arr[]
	 * 리턴타입1 : 없음 => void
	 * 리턴티입2 : 정렬된 배열 => int []
	 * 메소드명 : sortArray*/
	static void sortArry(int [] arr) {
		for(int i = 0; i < arr.length-1 ; i++) {
			for(int j = 0 ; j <arr.length-1 ; j++) {
				//배열 j번지에 있는 값이 다음 배열값(j+1번지값)보다 크면
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	static int [] sortArry2(int [] arr) {
		for(int i = 0; i < arr.length-1 ; i++) {
			for(int j = 0 ; j <arr.length-1 ; j++) {
				//배열 j번지에 있는 값이 다음 배열값(j+1번지값)보다 크면
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	return arr;
	}
	/* 기능 : 새로운 정수 배열을 만들어서 돌려주는 메소드
	 * 매개변수 : 배열의 길이 => int size
	 * 리턴타입 : 새로 만든 배열 => int[]
	 * 메소드명 : creatArray*/
	 static int[] creatArray(int size) {
		 return new int[size];
	 }

}
