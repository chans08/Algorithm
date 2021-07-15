package step._3.for_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _11_10871_less_than_X {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, x, tmp;
		List<Integer> result = new ArrayList<>();
		
		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		n = Integer.parseInt(input1[0]);
		x = Integer.parseInt(input1[1]);
		
		for (int i=0; i<n; i++) {
			tmp = Integer.parseInt(input2[i]);
			if (tmp < x) {
				result.add(tmp);
			}
		}
		
		for (int i=0; i<result.size()-1; i++) {
			bw.write(String.valueOf(result.get(i)));
			bw.write(" ");
		}
		bw.write(String.valueOf(result.get(result.size()-1)));
		bw.flush();
	}
}
