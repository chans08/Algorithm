package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6_8958_OX_quiz {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t, score = 0, sum = 0;
		String quizResult;
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			quizResult = br.readLine();
			
			for (int j=0; j<quizResult.length(); j++) {
				if (quizResult.charAt(j) == 'O') {
					score++;
					sum += score;
				} else {
					score = 0;
				}
			}
			System.out.println(sum);
			sum = 0;
			score = 0;
		}
	}
}
