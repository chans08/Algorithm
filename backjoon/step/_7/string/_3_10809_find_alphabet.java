package step._7.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3_10809_find_alphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = br.readLine();
		String result;
		for (int i=(int)'a'; i<=(int)'z'; i++) {
			bw.write(String.valueOf(word.indexOf(i)));
			bw.write(" ");
		}
		bw.flush();
	}
}
