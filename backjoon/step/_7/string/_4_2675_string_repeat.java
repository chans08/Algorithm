package step._7.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4_2675_string_repeat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int r;
		String s;
		for (int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			r = Integer.parseInt(input[0]);
			s = input[1];
			
			for (int j=0; j<s.length(); j++) {
				for (int k=0; k<r; k++) {
					bw.write(s.charAt(j));
				}
			}
			bw.flush();
			bw.newLine();
		}
		
	}
}
