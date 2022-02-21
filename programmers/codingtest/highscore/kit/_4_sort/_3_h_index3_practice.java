package codingtest.highscore.kit._4_sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 정확성  테스트
테스트 1 〉	통과 (3.72ms, 73.4MB)
테스트 2 〉	통과 (3.82ms, 75MB)
테스트 3 〉	통과 (3.86ms, 77.4MB)
테스트 4 〉	통과 (3.94ms, 77.5MB)
테스트 5 〉	통과 (3.81ms, 78.4MB)
테스트 6 〉	통과 (4.09ms, 80.5MB)
테스트 7 〉	통과 (3.50ms, 77.7MB)
테스트 8 〉	통과 (2.81ms, 83.5MB)
테스트 9 〉	통과 (3.01ms, 74.4MB)
테스트 10 〉	통과 (3.42ms, 79MB)
테스트 11 〉	통과 (4.11ms, 79.3MB)
테스트 12 〉	통과 (3.03ms, 77.1MB)
테스트 13 〉	통과 (4.08ms, 78.3MB)
테스트 14 〉	통과 (4.05ms, 78.8MB)
테스트 15 〉	통과 (4.26ms, 76.3MB)
테스트 16 〉	통과 (2.63ms, 78.7MB)
 * @author CMN
 * @date 2022-02-15
 */
public class _3_h_index3_practice {
	public static void main(String[] args) {
//		int[] citations = {3, 0, 6, 1, 5}; //{6, 5, 3, 1, 0}
//		int[] citations = {3, 3, 3, 2, 2, 2, 2};
//		int[] citations = {6, 5, 4, 1, 0}; //3
		int[] citations = {6, 6, 6, 6, 2, 2}; //4
		int answer = solution(citations);
		System.out.println("answer: " + answer);
	}
	
	public static int solution(int[] citations) {
		int hIdx = citations.length;
		//1. 인용수 내림차순으로 정렬
		citations = Arrays.stream(citations)
						.boxed()
						.sorted(Collections.reverseOrder())
						.mapToInt(Integer::intValue)
						.toArray();
		System.out.println("citations: " + Arrays.toString(citations));
		//2. h이상 인용수가 h편 이상인 논문 찾기
		for (int i=0; i<citations.length; i++) {
			if (citations[i] <= i) {
				return i;
			}
		}
		return hIdx;
	}
}
