package codingtest.highscore.kit._4_sort;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.31ms, 76MB)
테스트 2 〉	통과 (0.35ms, 74.6MB)
테스트 3 〉	통과 (0.32ms, 78.1MB)
테스트 4 〉	통과 (0.34ms, 75.8MB)
테스트 5 〉	통과 (0.52ms, 78.6MB)
테스트 6 〉	통과 (0.54ms, 78.2MB)
테스트 7 〉	통과 (0.32ms, 75MB)
 * @author CMN
 * @date 2022-02-09
 */
public class _1_kth_num2_practice {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println("answer: " + Arrays.toString(solution(array, commands)));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i=0; i<commands.length; i++) {
			//1. 배열을 자른다.
			int[] subarray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			//2. 오른차순으로 정렬한다.
			Arrays.sort(subarray);
			//3. 원하는 자리의 수를 정답에 담는다.
			answer[i] = subarray[commands[i][2]-1];
		}
		return answer;
	}
}
