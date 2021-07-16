package step._4.while_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2_10951_A_plus_B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp;
		String[] temps;
		int a, b, sum;
		
		while ((temp = br.readLine()) != null && !temp.isEmpty()) {
			temps = temp.split(" ");
			a = Integer.parseInt(temps[0]);
			b = Integer.parseInt(temps[1]);
			sum = a + b;
			bw.write(String.valueOf(sum));
			bw.newLine();
		}
		bw.flush();
	}
}
