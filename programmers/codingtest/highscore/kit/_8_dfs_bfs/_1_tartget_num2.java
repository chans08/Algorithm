package codingtest.hightscore.kit._8_dfs_bfs;

/**
 * 
테스트 1 〉	통과 (4.61ms, 76.6MB)
테스트 2 〉	통과 (7.07ms, 74.7MB)
테스트 3 〉	통과 (0.19ms, 73.8MB)
테스트 4 〉	통과 (0.39ms, 71.5MB)
테스트 5 〉	통과 (0.51ms, 74.1MB)
테스트 6 〉	통과 (0.28ms, 79.5MB)
테스트 7 〉	통과 (0.20ms, 80.9MB)
테스트 8 〉	통과 (0.43ms, 72.8MB)
 * @author CMN
 *
 */
public class _1_tartget_num2 {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		int answer = solution(numbers, target); //5
		System.out.println("answer: " + answer);
	}
	
	/**
	 * 
	 * @param numbers 사용할 수 있는 숫자가 담긴 배열
	 * @param target 타겟 넘버 
	 * @return 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수
	 */
	public static int solution(int[] numbers, int target) {
		int answer = dfs(numbers, target, 0, numbers.length, 0);
		
        return answer;
    }
	
	private static int dfs(int[] numbers, int target, int sum, int n, int idx) {
		if (idx == n) {
			if (sum == target) {
				return 1;
			} else {
				return 0;
			}
		}
		
		return dfs(numbers, target, sum + numbers[idx], n, idx + 1) + dfs(numbers, target, sum - numbers[idx], n, idx + 1);
	}
}
