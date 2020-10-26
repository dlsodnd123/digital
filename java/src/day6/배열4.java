package day6;

import java.util.Scanner;

public class 배열4 {

	public static void main(String[] args) {
		/* 짝수 10개를 배열에 저장하고 저장된 배열의 값을 출력하는 예제 */
		
		int size = 10;
		int arr1[] = new int[size];
		
		for(int i = 0, j = 0 ; i < arr1.length ; i++ ) {
			j = j + 2;
			arr1[i] = j;
			System.out.println("arr1[" + i + "]=" + arr1[i]);
		}
		System.out.println("----------------------------");

		for(int i = 0 ; i < arr1.length ; i++ ) {
			arr1[i] = 2*i+2;
			System.out.println("arr1[" + i + "]=" + arr1[i]);
		}
		
	}

}
