package step._7.string;

import java.util.Scanner;

public class _2_11720_sum_of_numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numsLength = Integer.parseInt(scanner.nextLine());
		String nums = scanner.nextLine();
		int sum = 0;
		for (int i=0; i<numsLength; i++) {
			sum += nums.charAt(i) - (int)'0';
		}
		System.out.println(sum);
	}
}
