package step._21.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class _1_1920_search_num {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());
		String[] numArrayA = scanner.nextLine().split(" ");
		Arrays.sort(numArrayA);
		int num2 = Integer.parseInt(scanner.nextLine());
		String[] numArrayToFind = scanner.nextLine().split(" ");
		for (int i=0; i<numArrayToFind.length; i++) {
			int idx = Arrays.binarySearch(numArrayA, numArrayToFind[i]);
			if (idx >= 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
