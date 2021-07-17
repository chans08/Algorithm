package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2_2562_Maximum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0, idx = 0, num;
		
		for (int i=0; i<9; i++) {
			num = Integer.parseInt(br.readLine());
			if (max < num) {
				max = num;
				idx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
	}
}
