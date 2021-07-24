package step._7.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class _7_2908_sangsu {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringWriter sw;
	public static BufferedWriter bw;
	public static String[] inputs;
	public static void main(String[] args) throws IOException {
		
		inputs = br.readLine().split(" ");
		String a, b;
		int sangSuA, sangSuB, max;
		a = inputs[0];
		b = inputs[1];
		
		sangSuA = getSangsuNum(a);
		sangSuB= getSangsuNum(b);
		
		max = sangSuA > sangSuB ? sangSuA : sangSuB;
		System.out.println(max);
		
	}
	
	public static int getSangsuNum(String num) throws IOException {
		sw = new StringWriter();
		bw = new BufferedWriter(sw);
		int rtnVal;
		for (int i=inputs[0].length()-1; i>=0; i--) {
			bw.write(num.charAt(i));
		}
		bw.flush();
		return Integer.parseInt(sw.toString());
	}
}
