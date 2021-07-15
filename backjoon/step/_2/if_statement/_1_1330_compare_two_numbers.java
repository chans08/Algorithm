package step._2.if_statement;

import java.util.Scanner;

public class _1_1330_compare_two_numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		if (a > b) System.out.println(">");
		else if (a < b) System.out.println("<");
		else System.out.println("==");
	}
}
