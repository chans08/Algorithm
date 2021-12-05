package step._7.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10_1316_group_word_checker2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String word;
		int[][] checker;
		int numOfGroupWord = num;
		for (int i=0; i<num; i++) {
			word = br.readLine() + " ";
			checker = new int['z'-'a'+1][1]; //[is check ended
			for (int j=0; j<word.length()-1; j++) {
				char thisChar = word.charAt(j);
				char nextChar = word.charAt(j+1);
				if (checker[thisChar-'a'][0] == 1) {
					numOfGroupWord--;
					break;
				} 
				if (thisChar == nextChar) {
					checker[thisChar-'a'][0] = 0;
				} else {
					checker[thisChar-'a'][0] = 1;
				}
			}
		}
		System.out.println(numOfGroupWord);
	}
}
