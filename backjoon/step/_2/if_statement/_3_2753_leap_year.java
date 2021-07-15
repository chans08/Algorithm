package step._2.if_statement;

import java.util.Scanner;

public class _3_2753_leap_year {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year;
		year = scanner.nextInt();
		if ((year % 4 == 0) && !(year % 100 == 0)) {
			System.out.println("1");
			return;
		}
		if (year % 400 == 0) {
			System.out.println("1");
			return;
		}
		
		System.out.println("0");
	}
}
