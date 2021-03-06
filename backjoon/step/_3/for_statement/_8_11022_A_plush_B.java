package step._3.for_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _8_11022_A_plush_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t, a, b;
		t = Integer.parseInt(br.readLine());
		for (int i=1; i<=t; i++) {
			String[] inputs = br.readLine().split(" ");
			a = Integer.parseInt(inputs[0]);
			b = Integer.parseInt(inputs[1]);
			
			bw.write(String.format("Case #%d: %d + %d = %d\n", i, a, b, a+b));
		}
		bw.flush();
	}
}
