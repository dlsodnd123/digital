package day14;

import java.util.Arrays;

/* 사용자번호 클래스의 필요한 멤버/메소드를 생성하시오
 * 6개짜리 로또 번호를 생성하는 클래스
 * - 멤버 변수 : 6개짜리 로또 번호 ,  int lottoNumber1 ~ 6
 * - 멤버 메소드:  getter/setter, toString(), 랜덤번호생성
 * - 생성자 
 * */
public class userNumber {
	int lottoNumber1;
	int lottoNumber2;
	int lottoNumber3;
	int lottoNumber4;
	int lottoNumber5;
	int lottoNumber6;
	
	public int getLottoNumber1() {
		return lottoNumber1;
	}
	public void setLottoNumber1(int lottoNumber1) {
		this.lottoNumber1 = lottoNumber1;
	}
	public int getLottoNumber2() {
		return lottoNumber2;
	}
	public void setLottoNumber2(int lottoNumber2) {
		this.lottoNumber2 = lottoNumber2;
	}
	public int getLottoNumber3() {
		return lottoNumber3;
	}
	public void setLottoNumber3(int lottoNumber3) {
		this.lottoNumber3 = lottoNumber3;
	}
	public int getLottoNumber4() {
		return lottoNumber4;
	}
	public void setLottoNumber4(int lottoNumber4) {
		this.lottoNumber4 = lottoNumber4;
	}
	public int getLottoNumber5() {
		return lottoNumber5;
	}
	public void setLottoNumber5(int lottoNumber5) {
		this.lottoNumber5 = lottoNumber5;
	}
	public int getLottoNumber6() {
		return lottoNumber6;
	}
	public void setLottoNumber6(int lottoNumber6) {
		this.lottoNumber6 = lottoNumber6;
	}
	
	public userNumber(int lottoNumber1, int lottoNumber2, int lottoNumber3, int lottoNumber4, int lottoNumber5,
			int lottoNumber6) {
		super();
		this.lottoNumber1 = lottoNumber1;
		this.lottoNumber2 = lottoNumber2;
		this.lottoNumber3 = lottoNumber3;
		this.lottoNumber4 = lottoNumber4;
		this.lottoNumber5 = lottoNumber5;
		this.lottoNumber6 = lottoNumber6;
	}
	
	
	
}



