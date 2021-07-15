package step._2.if_statement;

import java.util.Scanner;

public class _5_2884_alarm_clock {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int h, m;
		int _m;
		h = scanner.nextInt();
		m = scanner.nextInt();
		
		if (m >= 45) {
			System.out.println(h + " " + (m - 45));
			return;
		}
		
		_m = m + 15;
		if (h == 0) {
			System.out.println(23 + " " + _m);
			return;
		}
		
		System.out.println((h - 1) + " " + _m);
	}
}
