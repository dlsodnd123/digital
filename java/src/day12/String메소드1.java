package day12;

public class String메소드1 {

	public static void main(String[] args) {
		String str = "Green Compter";
		//chatAt(index) : index 번지에 있는 문자열 반환
		System.out.println("------charAt-----");
		System.out.println(str.charAt(0));
		//compareTo(str) : str문자열과 비교하여 같으면 0, 사전순으로 앞이면 -1, 뒤 1
		System.out.println("------compareTo---");
		System.out.println("b".compareTo("b"));
		System.out.println("b".compareTo("a"));
		System.out.println("b".compareTo("c")); 
		//concat : 이어 붙이기, +연산자와 같은 기능
		System.out.println("------concat-----");
		System.out.println("Hello ".concat("world"));
		System.out.println("Hello " + "world");
		//equals : 두 문자열이 같은지 다른지를 확인
		System.out.println("------equals-----");
		System.out.println("Hello".equals("Hello"));
		System.out.println("Hello".equals("hello"));
		//indexof : 주어진 문자가 문자열에 있는지 확인하고 위치를 알려준다. 못 찾으면 -1을 반환
		System.out.println("------indexOf----");
		String str1 = "Hello world";
		char search1 = 'w';
		int index = str1.indexOf(search1);
		if(index >= 0) {
			System.out.println(str1 + "문자열에는 " + search1 + "이(가) " + index + "번째 위치에 있습니다.");
		}
		String search2 = "world";
		index = str1.indexOf(search2);
		if(index >= 0) {
			System.out.println(str1 + "문자열에는 " + search2 + "이(가) " + index + "번째 위치에 있습니다.");
		}
		index = str1.indexOf(search1,7);
		if(index >= 0) {
			System.out.println(str1 + "문자열에는 " + search1 + "이(가) " + index + "번째 위치에 있습니다.");
		}else {
			System.out.println(str1 + "문자열에는 " + search1 + "이(가) " + "7번째이후로는 찾을 수 없습니다.");

		}
		//replace : 문자열 중의 문자를 새로운 문자로 변경해준다.
		System.out.println("------replace----");
		System.out.println("Hello World World".replace('W', 'w'));
		System.out.println("Hello world world".replace("world", "jave"));
		//split : 문자열을 지정된 분리자로 나누어 문자열 배열에 분배해준다.
		System.out.println("------split------");
		String[] arr = "dog,cat,tiger".split(",");
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		System.out.println("------join-------");
		System.out.println(String.join(",", arr));
		//substring() : 주어진 시작위치에서 끝 위치에 포함된 문자열은 얻는다.
		System.out.println("------substring--");
		String fileName = "String메소드.java";
		int index2 = fileName.lastIndexOf('.');
		String suffix = fileName.substring(index2+1);
		System.out.println(fileName + "의 확장자 : " + suffix);
		//trim() : 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다. 문자열 중간에 있는 공백은 제거되지 않는다.
		System.out.println("------trim-------");
		System.out.println("    Hello       ".trim());
		//valueOf : 문자열이 아닌 것을 문자열로 만들어준다(클래스메소드)
		System.out.println("------valueOf----");
		System.out.println(String.valueOf(1.23));
		String str3 = ""+123;
		//문자형을 기본형값으로
		int num1 = Integer.parseInt(str3);
		System.out.println(num1);
		int num2 = Integer.valueOf(str3);
		System.out.println(num2);
	}

}
