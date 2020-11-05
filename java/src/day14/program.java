package day14;
/* 로또 프로그램 
 * - 당첨번호 등록 : 당첨번호를 입력하면 누적 저장
 * - 로또 번호 확인 : 당첨되었는지 확인하고 등수 출력
 * - 역대 당첨번호 확인 : 누적 된 당첨번호 출력
 * - 로또 자동 번호 발행
 * - 로또 수동 번호 발행 
 * */
public interface program {
	
	void lottoRegisterNumber(); //당첨번호 등록
	void lottoCheckNumber(); //로또 번호 확인
	void previousWinningNumbers(); //역대 당첨번호 확인
	void lottoAutomaticNumberIssuance(); //로또 자동 번호 발행
	void lottoManualNumberIssuance(); //로또 수동 번호 발행 

}
