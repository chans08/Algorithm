package step._1.IO_and_arithmetic_operations;

import java.util.Scanner;

public class _10_10430_remainder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b, c;
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		System.out.println((a+b)%c);
		System.out.println(((a%c)+(b%c))%c);
		System.out.println((a*b)%c);
		System.out.println(((a%c)*(b%c))%c);
	}
}
