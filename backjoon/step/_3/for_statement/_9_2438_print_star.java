package step._3.for_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9_2438_print_star {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n;
		n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<n; i++) {
			sb.append("*");
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.flush();
	}
}
