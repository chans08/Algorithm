package step._7.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _6_1152_number_of_words {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//sol1();
		sol2();
	}
	
	public static void sol2() {
		StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
		System.out.println(st.countTokens());
	}
	
	public static void sol1() {
		String txt = scanner.nextLine().trim();
		int wordsNum = 0;
		if (!txt.isEmpty()) wordsNum = txt.split(" ").length;
		System.out.println(wordsNum);
	}
}
