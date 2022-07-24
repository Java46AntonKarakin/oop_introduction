package additional_task;

public class Lottery {

	int [] winningCombination;
	
	public Lottery(int[] winningCombination) {
		this.winningCombination = winningCombination;
	}	
	
	public int rateCombination(int playerCombination[]) {
		int[] lut = new int[50];
		int res = 0;
		
		for (int i = 0; i < playerCombination.length; i++) {
			lut [playerCombination [i]]++;
		}
		for (int i = 0; i < winningCombination.length; i++) {
			lut [winningCombination [i]]++;
		}
		
		for (int i : lut) {
			if (i != 0) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Lottery loto = new Lottery(new int[] { 5, 2, 17, 48, 43, 7, 9 });
		if (loto.rateCombination(new int[] { 3, 5, 12, 17, 44, 10, 7 }) != 3) {
			System.out.println("Test 1 failed");
			return;
		}
		if (loto.rateCombination(new int[] { 3, 5, 12, 17, 49, 9, 7 }) != 5) {
			System.out.println("Test 2 failed");
			return;
		}
		System.out.println("Success");
	}
}