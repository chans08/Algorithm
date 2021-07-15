package step._3.for_statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10_2439_print_star {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static StringBuffer sb_star = new StringBuffer();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		
		//sol1();
		sol2(); //출력 형식이 잘못되었습니다
	}
	
	public static void sol2() throws IOException {
		for (int i=0; i<n; i++) {
			sb_star.append("*");
			bw.write(String.format("%5s\n", sb_star.toString()));
		}
		
		bw.flush();
	}
	
	public static void sol1() throws IOException {
		StringBuffer sb_space;
		for (int i=1; i<=n; i++) {
			sb_space = new StringBuffer();
			for (int j=n-i; j>0; j--) {
				sb_space.append(" ");
			}
			sb_star.append("*");
			bw.write(sb_space.toString());
			bw.write(sb_star.toString());
			bw.newLine();
		}
		bw.flush();
	}
}
