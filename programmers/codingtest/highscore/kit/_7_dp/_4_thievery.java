package codingtest.highscore.kit._7_dp;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.15ms, 87.9MB)
테스트 2 〉	통과 (0.26ms, 79.6MB)
테스트 3 〉	통과 (0.19ms, 78.7MB)
테스트 4 〉	통과 (0.04ms, 83.4MB)
테스트 5 〉	통과 (0.15ms, 73.1MB)
테스트 6 〉	통과 (0.17ms, 73.5MB)
테스트 7 〉	통과 (0.15ms, 73.6MB)
테스트 8 〉	통과 (0.13ms, 71.6MB)
테스트 9 〉	통과 (0.25ms, 63MB)
테스트 10 〉	통과 (0.11ms, 76.2MB)
효율성  테스트
테스트 1 〉	통과 (23.17ms, 110MB)
테스트 2 〉	통과 (21.31ms, 108MB)
테스트 3 〉	통과 (22.01ms, 110MB)
테스트 4 〉	통과 (23.07ms, 108MB)
테스트 5 〉	통과 (20.46ms, 104MB)
테스트 6 〉	통과 (22.11ms, 108MB)
테스트 7 〉	통과 (18.42ms, 92.7MB)
테스트 8 〉	통과 (17.93ms, 94MB)
테스트 9 〉	통과 (21.19ms, 99.3MB)
테스트 10 〉	통과 (22.02ms, 108MB)
 * @author CMN
 * @date 2022-04-24
 */
public class _4_thievery {
	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1}; //4
		int answer = solution(money);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * @참고: https://velog.io/@imacoolgirlyo/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8F%84%EB%91%91%EC%A7%88-%ED%8C%8C%EC%9D%B4%EC%8D%AC
	 * @참고2: https://beenii.tistory.com/164
	 * 
	 * 1. 점화식
	 * dp[0] = money[0]
	 * dp[1] = max(money[0], money[1])
	 * dp[2] = max(dp[0]+money[2], dp[1])
	 * -> dp[i] = max(현재집을 털기, 현재집을 털지 않기)
	 *  		= max(dp[i-2]+money[i], dp[i-1])
	 * 2. 원형의 마을이므로 첫집과 끝집은 
	 * 	2-1. T F
	 * 	2-2. F ?
	 * 
	 * @param money
	 * @return 도둑이 훔칠 수 있는 돈의 최댓값
	 */
	public static int solution(int[] money) {
        //1. dp 선언
        long[] dpStolenFst = new long[money.length];
        long[] dpNotStolenFst = new long[money.length];
        //2. 초기화
        dpStolenFst[0] = dpStolenFst[1] = money[0];
        dpNotStolenFst[0] = 0; dpNotStolenFst[1] = money[1];
        //3. 점화식 적용
        for (int i=2; i<money.length; i++) {
        	dpStolenFst[i] = Math.max(dpStolenFst[i-2] + money[i], dpStolenFst[i-1]);
        	dpNotStolenFst[i] = Math.max(dpNotStolenFst[i-2] + money[i], dpNotStolenFst[i-1]);
        }
        return (int)Math.max(dpStolenFst[money.length-2], dpNotStolenFst[money.length-1]);
    }
}
