package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _7_4344_above_average {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t, n;
		double average = 0, percentage = 0;
		int[] data;
		t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			data = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			
			for (int j=1; j<data.length; j++) {
				average += data[j];
			}
			average /= data[0];
			
			for (int j=1; j<data.length; j++) {
				if (data[j] > average) percentage = percentage + 1;
			}
			percentage = percentage / data[0] * 100;
			
			System.out.printf("%.3f%%\n", percentage);
			average = 0;
			percentage = 0;
		}
	}
}
