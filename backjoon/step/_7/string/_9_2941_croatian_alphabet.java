package step._7.string;

import java.util.Scanner;

public class _9_2941_croatian_alphabet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.nextLine();
		String croatianAlphabets2 = "c= c- d- lj nj s= z=";
		String croatianAlphabets3 = "dz=";
		int alphabetNum = 0, i = 0;
		
		while (i < txt.length()) {
			if (i<txt.length()-2 && txt.substring(i, i+3).equals(croatianAlphabets3)) {
				alphabetNum++;
				i += 3;
				continue;
			}
			
			if (i<txt.length()-1 && croatianAlphabets2.contains(txt.substring(i, i+2))) {
				alphabetNum++;
				i += 2;
				continue;
			}
			
			alphabetNum++;
			i++;
			continue;
		}
		
		System.out.println(alphabetNum);
	}
}
