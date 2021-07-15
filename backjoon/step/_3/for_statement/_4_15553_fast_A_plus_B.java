package step._3.for_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4_15553_fast_A_plus_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t, a, b;
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			String[] inputs = br.readLine().split(" ");
			a = Integer.parseInt(inputs[0]);
			b = Integer.parseInt(inputs[1]);
			
			bw.write(String.valueOf(a + b));
			bw.newLine();
		}
		bw.flush();
	}
}
