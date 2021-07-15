package step._3.for_statement;

import java.util.Scanner;

public class _1_2739_multiplication_table {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		for (int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n", n, i, n*i);
		}
	}
}
