package step._3.for_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6_2742_print_N_desc {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n;
		n = Integer.parseInt(br.readLine());
		for (int i=n; i>=1; i--) {
			bw.write(String.valueOf(i));
			bw.newLine();
		}
		bw.flush();
	}
}
