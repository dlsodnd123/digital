package day14;

public class LottoMain {

	public static void main(String[] args) {
		

		Lotto2 lotto = new Lotto2();
		lotto.randomLotto();
		System.out.println(lotto);
		int []arr = new int[] {1,2,3,4,5,6};
		lotto.insertNumber(arr);
		System.out.println(lotto);
		System.out.println("------------");
		LottoE lotto2 = new LottoE();
		lotto2.randomLotto();
		System.out.println(lotto2);
		int []arr2 = new int[] {1,2,3,4,5,6,7};
		lotto2.insertNumber(arr2);
		System.out.println(lotto2);
		
	}
}