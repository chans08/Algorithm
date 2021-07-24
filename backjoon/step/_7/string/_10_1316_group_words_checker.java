package step._7.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10_1316_group_words_checker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = n;
		String word;
		int[] alphabetCnt;
		
		for (int i=0; i<n; i++) {
			word = br.readLine() + " ";
			alphabetCnt = new int['z' + 1];
			for (int j=0; j<word.length()-1; j++) {
				if (word.charAt(j) == word.charAt(j+1)) {
					continue;
				}
				
				alphabetCnt[word.charAt(j)]++;
				if (alphabetCnt[word.charAt(j)] >= 2) {
					cnt--;
					break;
				}	
			}
		}
		System.out.println(cnt);
	}
}
