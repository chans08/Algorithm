package com.algorithm2020.qualification;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string of digits S, insert a minimum number of opening and closing parentheses into it such that the resulting string is balanced and each digit d is inside exactly d pairs of matching parentheses.
 * 
 * match: An opening parenthesis and a closing parenthesis that is further to its right
 * nesting depth of a position p: the number of pairs of matching parentheses m such that p is included in the nesting of m.
 * 
 * S: a string of digits
 * S': another string
 * 
 * 	- all parentheses in S' match some other parenthesis,
	- removing any and all parentheses from S' results in S,
	- each digit in S' is equal to its nesting depth, and
	- S' is of minimum length
 * 
 * [Input]
 * T: the number of test cases
 * T lines follow. Each line represents a test case and contains only the string S.
 * 
 * [Ouput]
 * Case #x: y, where x is the test case number (starting from 1) and y is the string S' defined above.
 * 
 * [Limits]
 * Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ¡Â T ¡Â 100.
1 ¡Â length of S ¡Â 100.
 * 
 * @author CMN
 *
 */
public class NestingDepth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		scanner.nextLine();
		for (int i=1; i<=T; i++) {
			String result = "";
			String line = scanner.nextLine();
			int depth = 0;
			int diff = 0;
			Stack<String> openParenthesises = new Stack<>();
			for (int j=0; j<line.length(); j++) {
				char c = line.charAt(j);
				depth = c - 48;
				diff = openParenthesises.size() - depth;
				while (diff != 0) {
					if (diff < 0) {
						openParenthesises.add("(");
						result += "(";
						diff++;
					} else if (diff > 0) {
						openParenthesises.pop();
						result += ")";
						diff--;
					}
				}
				result += c;
			}
			while (openParenthesises.size() != 0) {
				result += ")";
				openParenthesises.pop();
			}
			System.out.printf("Case #%d: %s\r\n", i, result);
		}
	}
}
