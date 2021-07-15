package step._3.for_statement;

import java.util.Scanner;

public class _2_10950_A_plus_B_minus_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t, a, b;
		t = scanner.nextInt();
		for (int i=0; i<t; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			
			System.out.println(a + b);
		}
	}
}
