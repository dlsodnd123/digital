package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		/* 클래스며이 동일해야 한다.
		HashMap<A, B> map = new HashMap<A, B>();

		Set<Map.Entry<A, B>> set = map.entrySet();
		Iterator<Map.Entry<A, B>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<A, B> tmp = it.next();
		}
		*/
		//key 중복불가 value 중복가능
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("abc123", "abcdefg1234567");
		map.put("abc123", "abc1234"); // key 중복
		map.put("qwe123", "qwe123");
		map.put("asd123", "qwe123");  // value 중복
		//map을 set으로 전환 후 Iterator를 사용하여 출력
		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> tmp = it.next();
			System.out.println("ID :" + tmp.getKey() + ", PW : " + tmp.getValue());
		}
		

	}

}