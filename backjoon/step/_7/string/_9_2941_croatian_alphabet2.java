package step._7.string;

import java.util.Scanner;

public class _9_2941_croatian_alphabet2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.nextLine();
		String[] croatianAlphabet = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		txt = txt.replaceAll(String.join("|", croatianAlphabet), "!");
		System.out.println(txt.length());
	}
}
