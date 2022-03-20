package codingtest.highscore.kit._6_greedy;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (2.45ms, 79.3MB)
테스트 2 〉	통과 (3.08ms, 73.4MB)
테스트 3 〉	통과 (2.30ms, 75.6MB)
테스트 4 〉	통과 (2.12ms, 75.3MB)
테스트 5 〉	통과 (2.36ms, 72.7MB)
테스트 6 〉	통과 (3.13ms, 79.6MB)
테스트 7 〉	통과 (2.11ms, 79.7MB)
테스트 8 〉	통과 (3.04ms, 69.4MB)
테스트 9 〉	통과 (2.70ms, 72.7MB)
테스트 10 〉	통과 (2.33ms, 75.2MB)
테스트 11 〉	통과 (2.17ms, 71.9MB)
테스트 12 〉	통과 (2.27ms, 71.6MB)
테스트 13 〉	통과 (2.90ms, 76.6MB)
테스트 14 〉	통과 (2.35ms, 72.3MB)
테스트 15 〉	통과 (2.26ms, 85.7MB)
테스트 16 〉	통과 (2.09ms, 76.1MB)
테스트 17 〉	통과 (2.28ms, 75.5MB)
테스트 18 〉	통과 (2.11ms, 75.1MB)
테스트 19 〉	통과 (2.59ms, 78.6MB)
테스트 20 〉	통과 (3.37ms, 78.5MB)
 * @author CMN
 * @date 2022-03-20
 */
public class _1_gym_suit2 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5}; // 5
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {3}; // 4
//		int n = 7; 
//	    int[] lost = {2, 3, 4};
//	    int[] reserve = {1, 2, 3, 6}; //6
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {3, 1}; //5
//		int n = 5;
//		int[] lost = {1, 3, 5};
//		int[] reserve = {2, 4}; //4
//		int n = 1;
//		int[] lost = {1};
//		int[] reserve = {1}; //1
		int answer = solution(n, lost, reserve);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * - 제한사항
	 * 	- 전체 학생의 수는 2명 이상 30명 이하
	 *  - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
	 * @param n 전체 학생의 수
	 * @param lost 체육복을 도난당한 학생들의 번호가 담긴 배열
	 * @param reserve 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
	 * @return 체육수업을 들을 수 있는 학생의 최댓값
	 */
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		//1. 주어진 자료 구조 초기화(gymSuitCnt)
		int[] gymSuitCntArr = new int[n];
		Arrays.fill(gymSuitCntArr, 1);
		for (int studentNum : lost) {
			gymSuitCntArr[studentNum-1] -= 1;
		}
		for (int studentNum : reserve) {
			gymSuitCntArr[studentNum-1] += 1;
		}
		System.out.println("gymSuitCntArr: " + Arrays.toString(gymSuitCntArr));
		//2. 없는 친구에게 체육복 빌려주기
		for (int i=0; i<n; i++) {
			if (gymSuitCntArr[i] == 0 && (i > 0 && gymSuitCntArr[i-1] > 1)) {
				gymSuitCntArr[i] = 1;
				gymSuitCntArr[i-1] -= 1;
			}
			if (gymSuitCntArr[i] == 0 && (i < n-1 && gymSuitCntArr[i+1] > 1)) {
				gymSuitCntArr[i] = 1;
				gymSuitCntArr[i+1] -= 1;
			}
		}
		//3. 체육복 갖고 있는 학생의 수 구하기
		for (int i=0; i<n; i++) {
			if (gymSuitCntArr[i] >= 1) {
				answer++;
			}
		}
		return answer;
	}
}
