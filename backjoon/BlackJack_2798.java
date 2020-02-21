import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BlackJack_2798 {
	
	static BufferedReader br;

	static int n;
	static int m;
	static String[] strArray;
	
	public static void main(String[] args) throws IOException {
//		5 21
//		5 6 7 8 9
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] condition = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = condition[0];
		int m = condition[1];
		
		int sum = 0;
		int max = 0;
		
		int[] cardNums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		boolean breakFlag = false;
		
		Arrays.sort(cardNums);
		
		for (int i=0; i<n-2; i++) {
			for (int j=i+1; j<n-1; j++) {
				for (int k=j+1; k<n; k++) {
					sum = cardNums[i] + cardNums[j] + cardNums[k];
					if (sum == m) {
						max = sum;
						breakFlag = true;
						break;
					} else if (sum > max && sum < m) {
						max = sum;
					}
				}
				if (breakFlag == true) {
					break;
				}
			}
			if (breakFlag == true) {
				break;
			}
		}
		
		System.out.println(max);
		

	}

}
