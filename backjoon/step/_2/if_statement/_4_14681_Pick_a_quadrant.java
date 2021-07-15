package step._2.if_statement;

import java.util.Scanner;

public class _4_14681_Pick_a_quadrant {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y;
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		if (x > 0 && y > 0) {
			System.out.println("1");
			return;
		}
		if (x > 0 && y < 0) {
			System.out.println("4");
			return;
		}
		if (x < 0 && y > 0) {
			System.out.println("2");
			return;
		}
		if (x < 0 && y < 0) {
			System.out.println("3");
		}
	}
}
