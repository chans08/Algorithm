package step._7.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8_5622_dial {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static String word;
	public static int time = 0;
	public static int[] cnts = new int[] {3, 3, 3, 3, 3, 4, 3, 4};
	public static int[] dialToTime = new int[(int)'Z'+1];
	public static int startChar = (int)'A';
	
	public static void main(String[] args) throws IOException {
		word = br.readLine();
		initDialToTime(dialToTime);
		
		for (int i=0; i<word.length(); i++) {
			time += dialToTime[word.charAt(i)];
		}
		
		System.out.println(time);
	}

	private static void initDialToTime(int[] dialToTime) {
		for (int i=0; i<cnts.length; i++) {
			for (int j=0; j<cnts[i]; j++) {
				dialToTime[startChar + j] = i + 3;
			}
			startChar += cnts[i];
		}
	}
}
