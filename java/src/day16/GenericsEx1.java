package day16;

public class GenericsEx1 {
	//지네릭스 : 메서드나 클래스를 만들 때 멤버 변수 또는 매개변수의 클래스가 고정된 클래스가 아닐 때 사용되는 것
	//클래스의 멤버변수의 타입이 다양하게 들어올때 사용
	public static void main(String[] args) {
		Array<Integer> arr = new Array<Integer>(new Integer[10]);
		arr.set(0, 10);
		System.out.println(arr.get(0));
		Array<Character> arr2 = new Array<Character>(new Character[10]);
		arr2.set(0, 'A');
		System.out.println(arr2.get(0));
	}

}

class Array<T>{
	T arr[];
	public Array(T[] arr) {
		this.arr = arr;		
	}
	public Array() {}
	public T get(int i) {
		if(arr.length > i)
		return arr[i];
		else return null;
	}
	public void set(int index, T value) {
		if(arr.length > index)
			arr[index] = value;
	}
}