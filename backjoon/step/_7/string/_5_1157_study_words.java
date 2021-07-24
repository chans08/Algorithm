package step._7.string;

import java.util.Scanner;

public class _5_1157_study_words {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine().toLowerCase();
		int[] charBox = new int[(int)'z' + 1];
		int idx = 0, max = 0, sndMax = 0;
		for (int i=0; i<word.length(); i++) {
			int character = word.charAt(i);
			charBox[character]++; 
		}
		
		for (int i=(int)'a'; i<=(int)'z'; i++) {
			if (max < charBox[i]) {
				idx = i;
				max = charBox[i];
			}
			else if (sndMax < charBox[i]) sndMax = charBox[i];
		}
		
		if (max > sndMax) System.out.println((char)(idx - 'a' + 'A'));
		else System.out.println("?");
	}
}
