package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4_3052_remainder {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a, b = 42, cnt = 0, inputNum = 10;
		int[] remainders = new int[b];
		int temp;
		for (int i=0; i<inputNum; i++) {
			a = Integer.parseInt(br.readLine());
			temp = a % b;
			if (remainders[temp] == 0) cnt++;
			remainders[temp]++;
		}
		
		System.out.println(cnt);
	}
}
