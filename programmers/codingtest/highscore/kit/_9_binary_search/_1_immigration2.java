package codingtest.highscore.kit._9_binary_search;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.41ms, 77.1MB)
테스트 2 〉	통과 (0.49ms, 73MB)
테스트 3 〉	통과 (1.70ms, 72.5MB)
테스트 4 〉	통과 (93.33ms, 103MB)
테스트 5 〉	통과 (84.47ms, 109MB)
테스트 6 〉	통과 (85.09ms, 92.2MB)
테스트 7 〉	통과 (93.22ms, 100MB)
테스트 8 〉	통과 (91.25ms, 113MB)
테스트 9 〉	통과 (0.38ms, 70.8MB)
 * @author CMN
 * @date 2022-05-01
 */
public class _1_immigration2 {
	public static void main(String[] args) {
//		int n = 6;
//		int[] times = {7, 10}; //28
//		int n = 1;
//		int[] times = {7, 10}; //7
//		int n = 3;
//		int[] times = {1, 99, 99}; //3
		int n = 1_000_000_000;
		int[] times = {1_000_000_000}; // ??? long 인 asnwer로 감당할 수 없을 텐데...??
		long answer = solution(n, times);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * @참고: https://suhyeokeee.tistory.com/183
	 * 메모리 초과가 나지 않게 결과를 계산해서 return 해야 함..
	 * @param n
	 * @param times
	 * @return
	 */
	public static long solution(int n, int[] times) {
		long answer = 0;
		//1. 검사 시간에 대하여 binary search를 적용한다.
		Arrays.sort(times);
		//1-1. binary search 시작 시간은 최소 값, 끝값은 최댓값
		long start = times[0];
		long end = ((long)times[times.length-1]) * n;
		while (start <= end) {
			long mid = (start + end)/2;
			//2. 입국심사를 마친 사람 수를 체크하면서 정답값을 좁혀나간다.
			long finishedN = 0;
			for (int i=0; i<times.length; i++) {
				finishedN += mid / times[i];
			}
			if (finishedN >= n) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return answer;
    }
}
