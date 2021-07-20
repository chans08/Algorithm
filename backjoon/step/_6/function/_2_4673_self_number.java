package step._6.function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2_4673_self_number {
	public static int arrayLength = 10000;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int[] numBox = new int[arrayLength+1];
		for (int i=1; i<=arrayLength; i++) {
			int temp = i;
			while (true) {
				temp = d(temp);
				if (temp > arrayLength) break;
				if (numBox[temp] >= 1) break;
				numBox[temp]++;
			}
		}
		for (int i=1; i<=arrayLength; i++) {
			if (numBox[i] == 0)	{
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}
		bw.flush();
	}
	
	public static int d(int n) {
		int rtnVal = n;
		String nStr = String.valueOf(n);
		for (int i=0; i<nStr.length(); i++) {
			rtnVal += nStr.charAt(i) - (int)'0'; 
		}
		return rtnVal;
	}
}
