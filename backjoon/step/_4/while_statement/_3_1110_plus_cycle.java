package step._4.while_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3_1110_plus_cycle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static String n, newNum;
	static int a, b, cycle = 1, nInt, newNumInt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = br.readLine();
		System.out.println(n);
		nInt = Integer.parseInt(n);
		
		//sol1();
		sol2();
	}
	
	public static void sol2() {
		newNumInt = nInt;
		while (true) {
			a = newNumInt / 10;
			b = newNumInt % 10;
			
			newNum = String.format("%d%d", b, (a+b)%10);
			newNumInt = Integer.parseInt(newNum);
			if (nInt == newNumInt) break;
			cycle++;
		}
		System.out.println(cycle);
	}
	
	public static void sol1() {
		newNum = n;
		while (true) {
			newNum = getTwoPlace(newNum);
			
			a = get10sPlace(newNum);
			b = get1sPlace(newNum);
			
			newNum = String.format("%d%d", b, get1sPlace(getTwoPlace(String.valueOf(a+b))));
			newNumInt = Integer.parseInt(newNum);
			if (nInt == newNumInt) break;
			cycle++;
		}
		System.out.println(cycle);
	}
	
	public static String getTwoPlace(String n) {
		if (n.length() == 1) return "0" + n;
		return n;
	}
	
	public static int get10sPlace(String n) {
		return n.charAt(0) - (int)'0';
	}
	
	public static int get1sPlace(String n) {
		return n.charAt(1) - (int)'0';
	}
}
