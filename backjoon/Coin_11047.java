import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Coin_11047 {
	
	static BufferedReader br;
	
	//(1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
	static int n;
	static int k;
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] condition = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = condition[0];
		k = condition[1];
		
		int[] coins = new int[n+1];
		
		int maxIdx = 0;
		
		for (int i=1; i<=n; i++) {
			int coin = Integer.parseInt(br.readLine());
			if (coin <= k) maxIdx++; 
			coins[i] = coin;
		}
		
		for (int i=maxIdx; i>0; i--) {
			answer += getCount(k, coins[i]);
			if (k <=0) break;
		}
		
		System.out.println(answer);
	}
	
	static int getCount(int money, int kind) {
		
		k = money%kind;
		
		return money/kind;
	}
}
