package step._6.function;

import java.util.Scanner;

public class _3_1065_one_number {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = 0;
		for (int i=1; i<=n; i++) {
			if (isOneNum(i)) sum += 1;
		}
		System.out.println(sum);
	}
	
	public static boolean isOneNum(int num) {
		String numStr = String.valueOf(num);
		int d, firstPlace, sndPlace;
		if (numStr.length() == 1) return true;
		firstPlace = numStr.charAt(0);
		sndPlace = numStr.charAt(1);
		d = firstPlace - sndPlace;
		for (int i=2; i<numStr.length(); i++) {
			if (d != numStr.charAt(i-1) - numStr.charAt(i)) return false;
		}
		return true;
	}
}
