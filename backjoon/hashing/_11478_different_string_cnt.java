package hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 229908KB	832ms
 * @author CMN
 * @date 2022-01-31
 */
public class _11478_different_string_cnt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Set<String> subStringSet = new HashSet<>();
		//1. 문자 개수를 갖는 서브문자열을 set에 담는다.
		for (int i=1; i<=input.length(); i++) {
			for (int j=0; j<=input.length()-i; j++) {
				//System.out.println("i, j: " + i + ", " + j);
				//System.out.println("substring: " + input.substring(j, j+i));
				subStringSet.add(input.substring(j, j+i));
			}
		}
		//2. 개수 출력
		//System.out.println("subStringSet: " + subStringSet);
		System.out.println(subStringSet.size());
	}
}
