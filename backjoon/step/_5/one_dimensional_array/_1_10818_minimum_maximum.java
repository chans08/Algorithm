package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _1_10818_minimum_maximum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, min, max;
		int[] array;
		
		n = Integer.parseInt(br.readLine());
		array = Arrays.stream(br.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();
		
		min = max = array[0];
		for (int i=1; i<array.length; i++) {
			if (min > array[i]) {
				min = array[i];
				continue;
			}
			if (max < array[i]) {
				max = array[i];
				continue;
			}
		}
		System.out.printf("%d %d", min, max);
	}
}
