package codingtest.highscore.kit._7_dp;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.03ms, 73.2MB)
테스트 2 〉	통과 (0.02ms, 75.8MB)
테스트 3 〉	통과 (0.04ms, 70.5MB)
테스트 4 〉	통과 (0.03ms, 75.5MB)
테스트 5 〉	통과 (0.05ms, 74MB)
테스트 6 〉	통과 (0.03ms, 75.5MB)
테스트 7 〉	통과 (0.03ms, 75MB)
테스트 8 〉	통과 (0.03ms, 74.3MB)
테스트 9 〉	통과 (0.02ms, 74.1MB)
테스트 10 〉	통과 (0.03ms, 75.2MB)
효율성  테스트
테스트 1 〉	통과 (0.75ms, 52.6MB)
테스트 2 〉	통과 (0.31ms, 52.3MB)
테스트 3 〉	통과 (0.42ms, 52MB)
테스트 4 〉	통과 (0.56ms, 52.1MB)
테스트 5 〉	통과 (0.45ms, 52MB)
테스트 6 〉	통과 (0.78ms, 67.3MB)
테스트 7 〉	통과 (0.38ms, 53MB)
테스트 8 〉	통과 (0.60ms, 52.2MB)
테스트 9 〉	통과 (0.48ms, 52.6MB)
테스트 10 〉	통과 (0.58ms, 51.9MB)
 * @author CMN
 * @date 2022-04-22
 */
public class _3_road_to_school2 {
	public static void main(String[] args) {
//		int m = 4;
//		int n = 3;
//		int[][] puddles = {{2,2}}; //4
//		int m = 1;
//		int n = 2;
//		int[][] puddles = {}; //1
//		int m = 2;
//		int n = 3;
//		int[][] puddles = {{2,1}, {2,2}}; //1
		int m = 3;
		int n = 4;
		int[][] puddles = {{1,3}, {2,1}}; //3 -> 5!!!!
		int answer = solution(m, n, puddles);
		System.out.println("answer: " + answer);
	}
	
	private static final int MOD = 1_000_000_007;
	/**
	 * caseNums[0][0]을 1로 초기화해두고 계산하는 방법!
	 * @param m
	 * @param n
	 * @param puddles
	 * @return
	 */
	public static int solution(int m, int n, int[][] puddles) {
        //1. 각 경로의 노드의 경우의 수을 표현하는 배열 선언
        long[][] caseNums = new long[m+1][n+1]; //(1,...,m) * (1,...,n)
        //2. 웅덩이를 caseNums에 -1로 표시
        for (int i=0; i<puddles.length; i++) {
        	caseNums[puddles[i][0]][puddles[i][1]] = -1;
        }
        //3. 오른쪽으로, 한층씩 아래로 늘려가면서 경우의 수 채우기
        //	만약 웅덩이를 만나면 0으로 초기화된다.
        caseNums[1][1] = 1;
        for (int i=1; i<=m; i++) {
        	for (int j=1; j<=n; j++) {
        		//3-1. 웅덩이를 만나면 0으로 초기화
        		if (caseNums[i][j] == -1) {
        			caseNums[i][j] = 0;
        			continue;
        		}
        		caseNums[i][j] += (caseNums[i][j-1] + caseNums[i-1][j]) % MOD;
        	}
        }
        return (int)caseNums[m][n];
    }
}
