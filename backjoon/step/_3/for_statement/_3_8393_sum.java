package step._3.for_statement;

import java.util.Scanner;

public class _3_8393_sum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, sum = 0;
		n = scanner.nextInt();
		
		for (int i=1; i<=n; i++) {
			sum = sum + i;
		}
		
		System.out.println(sum);
	}
}
