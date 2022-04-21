package codingtest.highscore.kit._7_dp;

import java.util.Arrays;

/**
 * @참고: https://codedrive.tistory.com/49
 * 
 * 방법1: 각 층에서 값을 구할 때마다 최댓값을 갱신하는 경우(방법2보다 더 좋음)
 * 정확성  테스트
테스트 1 〉	통과 (0.04ms, 67.5MB)
테스트 2 〉	통과 (0.03ms, 72.4MB)
테스트 3 〉	통과 (0.06ms, 76.9MB)
테스트 4 〉	통과 (0.07ms, 75MB)
테스트 5 〉	통과 (0.37ms, 71.7MB)
테스트 6 〉	통과 (0.11ms, 74.6MB)
테스트 7 〉	통과 (0.34ms, 84.3MB)
테스트 8 〉	통과 (0.09ms, 76.9MB)
테스트 9 〉	통과 (0.03ms, 72.9MB)
테스트 10 〉	통과 (0.07ms, 78.2MB)
효율성  테스트
테스트 1 〉	통과 (9.13ms, 57.1MB)
테스트 2 〉	통과 (9.46ms, 56.2MB)
테스트 3 〉	통과 (10.75ms, 61.4MB)
테스트 4 〉	통과 (10.63ms, 60MB)
테스트 5 〉	통과 (9.54ms, 60MB)
테스트 6 〉	통과 (9.59ms, 57.8MB)
테스트 7 〉	통과 (9.80ms, 58MB)
테스트 8 〉	통과 (10.32ms, 59.7MB)
테스트 9 〉	통과 (10.00ms, 60.1MB)
테스트 10 〉	통과 (10.82ms, 60.6MB)

//방법2. 마지막  층에서 최댓값을 구한 경우
정확성  테스트
테스트 1 〉	통과 (0.40ms, 70.7MB)
테스트 2 〉	통과 (0.35ms, 75.3MB)
테스트 3 〉	통과 (0.35ms, 77.2MB)
테스트 4 〉	통과 (0.56ms, 78.7MB)
테스트 5 〉	통과 (0.76ms, 82.3MB)
테스트 6 〉	통과 (0.44ms, 76.1MB)
테스트 7 〉	통과 (0.63ms, 76.2MB)
테스트 8 〉	통과 (0.37ms, 73.4MB)
테스트 9 〉	통과 (0.36ms, 73.1MB)
테스트 10 〉	통과 (0.37ms, 75.9MB)
효율성  테스트
테스트 1 〉	통과 (10.81ms, 60.4MB)
테스트 2 〉	통과 (5.60ms, 56.4MB)
테스트 3 〉	통과 (10.12ms, 61.2MB)
테스트 4 〉	통과 (7.50ms, 60.6MB)
테스트 5 〉	통과 (10.42ms, 60MB)
테스트 6 〉	통과 (8.76ms, 61.7MB)
테스트 7 〉	통과 (6.60ms, 57.5MB)
테스트 8 〉	통과 (7.95ms, 56.4MB)
테스트 9 〉	통과 (8.05ms, 59.1MB)
테스트 10 〉	통과 (8.17ms, 57.8MB)
 * @author CMN
 * @date 2022-04-22
 */
public class _2_integer_triangle2 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; //30
		int answer = solution(triangle);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * i번째 층에 k번째 노드 위치에 올 수 있는 최대값을 구해간다.
	 * @param triangle
	 * @return 삼각형을 거쳐간 숫자 합의 최댓값
	 */
	public static int solution(int[][] triangle) {
        int max = 0;
        for (int i=1; i<triangle.length; i++) { //i는 층수(0층, 1층, 2층 ...)
        	for (int k=0; k<triangle[i].length; k++) {
        		//1. 첫번째 값과 끝값은 이전층의 첫번째 값을 더하거나 끝값을 더한 값이다.
        		if (k == 0) {
        			triangle[i][k] += triangle[i-1][k];
        			max = Math.max(max, triangle[i][k]);
        			continue;
        		}
        		if (k == triangle[i].length-1) {
        			triangle[i][k] += triangle[i-1][triangle[i-1].length-1];
        			max = Math.max(max, triangle[i][k]);
        			continue;
        		}
        		//2. 2번째 값부터 마지막 전값은 이전층의 '같은 위치 이전값' 또는 '바로 같은 위치의 값' 중 큰값을 더한 값이다.
        		triangle[i][k] += Math.max(triangle[i-1][k-1], triangle[i-1][k]);
        		max = Math.max(max, triangle[i][k]);
        	}
        }
        return max;
    }
	
	/**
	 * i번째 층에 k번째 노드 위치에 올 수 있는 최대값을 구해간다.
	 * @param triangle
	 * @return 삼각형을 거쳐간 숫자 합의 최댓값
	 */
	public static int solution2(int[][] triangle) {
        for (int i=1; i<triangle.length; i++) { //i는 층수(0층, 1층, 2층 ...)
        	for (int k=0; k<triangle[i].length; k++) {
        		//1. 첫번째 값과 끝값은 이전층의 첫번째 값을 더하거나 끝값을 더한 값이다.
        		if (k == 0) {
        			triangle[i][k] += triangle[i-1][k];
        			continue;
        		}
        		if (k == triangle[i].length-1) {
        			triangle[i][k] += triangle[i-1][triangle[i-1].length-1];
        			continue;
        		}
        		//2. 2번째 값부터 마지막 전값은 이전층의 '같은 위치 이전값' 또는 '바로 같은 위치의 값' 중 큰값을 더한 값이다.
        		triangle[i][k] += Math.max(triangle[i-1][k-1], triangle[i-1][k]);
        	}
        }
        //3. 마지막 층에서 최댓값을 구해서 return 해준다.
        int[] lastFloor = triangle[triangle.length-1];
        Arrays.sort(lastFloor);
        return lastFloor[lastFloor.length-1];
    }
}
