package step._2.if_statement;

import java.util.Scanner;

public class _2_9498_test_score {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score;
		score = scanner.nextInt();
		if (score >= 90) System.out.println("A");
		else if (score >= 80) System.out.println("B");
		else if (score >= 70) System.out.println("C");
		else if (score >= 60) System.out.println("D");
		else System.out.println("F");
	}
}
