package step._5.one_dimensional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3_2577_number_of_numbers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = 0, b = 0, c = 0, multiply;
		int[] numOfNums = new int[10];
		String multiplyStr;
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		
		multiply = a * b * c;
		multiplyStr = String.valueOf(multiply);
		
		char temp;
		for (int i=0; i<multiplyStr.length(); i++) {
			temp = multiplyStr.charAt(i);
			numOfNums[convertToInt(temp)]++;
		}
		
		for (int i=0; i<numOfNums.length; i++) {
			System.out.println(numOfNums[i]);
		}
	}
	
	public static int convertToInt(char c) {
		return c - (int)'0';
	}
}
