package step._1.IO_and_arithmetic_operations;

import java.util.Scanner;

public class _11_2588_mutiply {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		int _1_digit, _10_digit, _100_digit;
		int i, j, k;
		
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		i = a * (b % 10);
		j = a * (b % 100 - b % 10);
		k = a * (b % 1000 - b % 100);
		
		_1_digit = i;
		_10_digit = j / 10;
		_100_digit = k / 100;
		
		System.out.println(_1_digit);
		System.out.println(_10_digit);
		System.out.println(_100_digit);
		System.out.println(i + j + k);
	}
}
