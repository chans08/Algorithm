package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _5_1546_average {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, max = 0;
		double average = 0;
		int[] scores;
		n = Integer.parseInt(br.readLine());
		scores = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		
		for (int i=0; i<n; i++) {
			if (max < scores[i]) max = scores[i];
			average += scores[i];
		}
		average /= n;
		
		System.out.println(average / max * 100);
	}
}
