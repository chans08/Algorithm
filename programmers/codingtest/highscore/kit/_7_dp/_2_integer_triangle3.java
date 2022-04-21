package codingtest.highscore.kit._7_dp;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.02ms, 76.6MB)
테스트 2 〉	통과 (0.02ms, 73.6MB)
테스트 3 〉	통과 (0.03ms, 75.6MB)
테스트 4 〉	통과 (0.05ms, 75.7MB)
테스트 5 〉	통과 (0.19ms, 80.8MB)
테스트 6 〉	통과 (0.07ms, 75.6MB)
테스트 7 〉	통과 (0.19ms, 75.5MB)
테스트 8 〉	통과 (0.07ms, 71.8MB)
테스트 9 〉	통과 (0.03ms, 72.5MB)
테스트 10 〉	통과 (0.05ms, 71.6MB)
효율성  테스트
테스트 1 〉	통과 (6.03ms, 60.7MB)
테스트 2 〉	통과 (5.69ms, 59.4MB)
테스트 3 〉	통과 (7.99ms, 59.6MB)
테스트 4 〉	통과 (7.60ms, 60.6MB)
테스트 5 〉	통과 (9.06ms, 59.4MB)
테스트 6 〉	통과 (9.39ms, 61.1MB)
테스트 7 〉	통과 (7.56ms, 60.7MB)
테스트 8 〉	통과 (5.21ms, 58.7MB)
테스트 9 〉	통과 (5.50ms, 59.1MB)
테스트 10 〉	통과 (6.69ms, 61.5MB)
 * @author CMN
 * @date 2022-04-22
 */
public class _2_integer_triangle3 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; //30
		int answer = solution(triangle);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * i번째 층에 k번째 노드 위치에 올 수 있는 최대값을 마지막 층의 바로 위층부터 0번째 층까지 거꾸로 올라가며 구해간다.
	 * @param triangle
	 * @return 삼각형을 거쳐간 숫자 합의 최댓값
	 */
	public static int solution(int[][] triangle) {
        for (int i=triangle.length-2; i>=0; i--) {
        	//1. i번째 층에서 k번째 노드에 대하여 i+1번째 층의 연관 값 중 큰 값을 더하여 최대값을 더해간다.
        	for (int k=0; k<triangle[i].length; k++) {
        		triangle[i][k] += Math.max(triangle[i+1][k], triangle[i+1][k+1]);
        	}
        }
        //2. 0번째 층의 0번째 값이 최댓값이다.
        return triangle[0][0];
    }
}
