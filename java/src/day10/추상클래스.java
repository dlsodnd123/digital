package day10;

public class 추상클래스 {

	public static void main(String[] args) {
		
		/* 추상클래스 : 추상 메소드가 있는 클래스
		 * 추상메소드 : 메소드의 선언부만 있고, 구현보가 없는 메소드
		 * abstract 리턴타입 메소드명(매개변수);
		 * 추상 클래스를 이용하여 객체를 만들 수 없다.
		 */ 
		//Animal2 a = new Animal2();
		Animal2 b = new Dog2();
		b.howl();
		
	}

}

abstract class Animal2 {
	public String name;
	public String category;
	public void info() {
		System.out.println("----------------");
		System.out.println("이름 : " + name);
		System.out.println("분류 : " + category);
		System.out.println("----------------");
	}
	public abstract void howl();
}
//추상 클래스를 상속받은 클래스가 추상 클래스가 아니면 부모의 추상 메소드를 반드시 구현해야한다.(오버라이딩)
class Dog2 extends Animal2{

	@Override
	public void howl() {
		System.out.println("멍멍");
	}
	
}