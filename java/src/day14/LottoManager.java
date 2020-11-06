package day14;

import java.util.Scanner;

public class LottoManager {
	LottoE []lotto = new LottoE[5]; // 당첨번호를 저장할 배열
	int lCount = 0; // 현재 입력된 당첨번호 갯수
	Lotto2 user = new Lotto2(); // 사용자번호

	public void printMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 로또 번호 생성(수동)");
		System.out.println("2. 로또 번호 생성(자동)");
		System.out.println("3. 로또 당첨 번호 입력");
		System.out.println("4. 로또 당첨 확인");
		System.out.println("5. 로또 당첨 번호 확인(전체)");
		System.out.println("6. 종료");
		System.out.println("------------------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	//로또 번호 생성(수동)
	public void createLotto(Scanner scan) {
		System.out.print("로또 번호를 입력하세요.(중복되지 않게 6개 입력) : ");
		int []tmp = new int[6]; // 입력받은 값을 임시로 저장하는 배열 생성
		for(int i = 0; i<tmp.length; i++) {
			tmp[i] = scan.nextInt();
		}
		//중복 체크, 범위 체크를 해야함
		if(isDuplicaterd(tmp)) {
			printString("중복된 숫자가 있어서 생성이 취소됩니다.");
		}else {
			user.insertNumber(tmp); // Lotto2 insertNumber로 가서 수행
			printString("로또번호 : " + user);
		}
	}
	public void printString(String str) {
		System.out.println("****************************");
		System.out.println(str);
		System.out.println("****************************");
	}
	//중복 체크하는 메소드
	private boolean isDuplicaterd(int[] arr) { // arr에는 전에 입력하거나 생성한 배열의 값이 있음
		for(int i = 0; i<arr.length-1; i++) { 
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	//로또 번호 생성(자동)
	public void createLottoAuto() {
		user.randomLotto();
		printString("로또번호 : " + user);

	}
	// 로또 당첨 번호 입력
	public void insertLotto(Scanner scan) {
		System.out.print("로또 당첨 번호를 입력하세요.(중복되지 않게 7개 입력, 보너스 번호를 마지막에 입력) : ");
		int []tmp = new int[7]; // 임시로 저장할 수 있는 배열 7개 생성
		for(int i = 0; i<tmp.length; i++) {
			tmp[i] = scan.nextInt();
		}
		//중복 체크, 범위 체크를 해야함
		if(isDuplicaterd(tmp)) {
			printString("중복된 숫자가 있어서 생성이 취소됩니다.");
		}else {
			LottoE tmpLotto = new LottoE(); 
			tmpLotto.insertNumber(tmp); 
			lotto[lCount] = tmpLotto;
			lCount++;
			printString("로또번호 : " + tmpLotto);
		}
		
	}
	// 로또 당첨 확인
	public void checkLotto() {
		// 사용자 로또 번호를 입력하지 않았을 때
		if(user.contain(0)) {
			printString("로또 번호를 입력하세요");
			return;
		}
		// 당첨 로또 번호를 입력하지 않았을 때
		if(lCount == 0) {
			printString("당첨 번호를 입력하세요");
			return;
		}
		//당첨 갯수 확인
		int cnt = 0;
		//최신 당첨 번호
		LottoE tmp = lotto[lCount-1];
		
		for(int i=0; i<user.getNumbers().length; i++) {
			//lotto[lCount-1] : 마지막에 입력된 당첨 번호 : 최신 당첨번호
			//lotto[lCount-1].getNumbers()[i] : 최신 당첨번호 중 i번째 번호
			int num = tmp.getNumbers()[i];
			if(user.contain(num)) {  // 당첨번호 하나를 꺼내서 user에 있는지 확인후 있으면(true) 당첨 갯수(cnt)1증가
				cnt++;
			}
		}
		int rank = -1; 
		// 당첨 등수 계산
		switch(cnt) {
		case 6: rank = 1; break;
		case 5:
			if(user.contain(tmp.getBonus())) {
				rank = 2;
			}else {
				rank= 3;
			}
//			rank = user.contain(tmp.getBonus()) ? 2 : 3; // 위의 if문을 한줄로 표현한다면
			break;
		case 4: rank = 4; break;
		case 3: rank = 5; break;
		}
		if(rank != -1) {
			printString(rank + "등 담청!!!");
		}else {
			printString("꽝!!!");
		}

	}
	// 로또 당첨 번호 확인(전체)
	public void printLotto() {
//		for(int i = lCount-1; i>=0; i--) {
//			System.out.println(i+1+"회차 : " + lotto[i]);
//		}
		String str = "";
		for(int i = lCount-1; i>=0; i--) {
			str += (i+1) + "회차 : " + lotto[i]+"\n"; // 문자열에서 '+=' 는 이어붙어주는 용도 '\n'은 엔터
		}
		// 마지막 로또 번호에 들어가는 엔터('\n')를 제거
		str = str.substring(0, str.length()-1);
		printString(str);
	}
	
	

}
