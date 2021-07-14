package kakao_code_festival._2018.preliminaries;

import java.util.Scanner;

public class _A_15953_prize_hunter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t, rank1, rank2;
		
		t = scanner.nextInt();
		for (int i=0; i<t; i++) {
			rank1 = scanner.nextInt();
			rank2 = scanner.nextInt();
			
			System.out.println(getPrize1(rank1) + getPrize2(rank2));
		}
	}
	
	public static int getPrize1(int rank) {
		if (rank <= 0) return 0;
		if (rank <= 1) return 5000000;
		if (rank <= 3) return 3000000;
		if (rank <= 6) return 2000000;
		if (rank <= 10) return 500000;
		if (rank <= 15) return 300000;
		if (rank <= 21) return 100000;
		return 0;
	}
	
	public static int getPrize2(int rank) {
		if (rank <= 0) return 0;
		if (rank <= 1) return 5120000;
		if (rank <= 3) return 2560000;
		if (rank <= 7) return 1280000;
		if (rank <= 15) return 640000;
		if (rank <= 31) return 320000;
		return 0;
	}
}
