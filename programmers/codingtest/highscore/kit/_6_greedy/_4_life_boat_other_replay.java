package codingtest.highscore.kit._6_greedy;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (1.29ms, 73.5MB)
테스트 2 〉	통과 (0.84ms, 76.4MB)
테스트 3 〉	통과 (1.28ms, 84.5MB)
테스트 4 〉	통과 (1.16ms, 77.9MB)
테스트 5 〉	통과 (0.81ms, 76.6MB)
테스트 6 〉	통과 (0.61ms, 74.9MB)
테스트 7 〉	통과 (0.71ms, 73.2MB)
테스트 8 〉	통과 (0.34ms, 77.1MB)
테스트 9 〉	통과 (0.44ms, 78.3MB)
테스트 10 〉	통과 (1.57ms, 90.6MB)
테스트 11 〉	통과 (1.28ms, 77MB)
테스트 12 〉	통과 (0.98ms, 80.1MB)
테스트 13 〉	통과 (1.03ms, 78MB)
테스트 14 〉	통과 (0.97ms, 75.6MB)
테스트 15 〉	통과 (0.58ms, 73MB)
효율성  테스트
테스트 1 〉	통과 (11.21ms, 56.3MB)
테스트 2 〉	통과 (9.70ms, 53.6MB)
테스트 3 〉	통과 (10.72ms, 55.8MB)
테스트 4 〉	통과 (7.90ms, 53.5MB)
테스트 5 〉	통과 (9.60ms, 53.4MB)
 * @author CMN
 * @date 2022-03-28
 */
public class _4_life_boat_other_replay {
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100; //3
//		int[] people = {70, 80, 50};
//		int limit = 100; //3
		int answer = solution(people, limit);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * - 제한사항
		- 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
		- 각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
		- 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
		- 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
	 * @param people 사람들의 몸무게를 담은 배열
	 * @param limit 구명보트의 무게 제한
	 * @return 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값
	 */
//	50 50 70 80
//	60 70 80
	public static int solution(int[] people, int limit) {
		//0. 몸무게 오름차순으로 정렬
		Arrays.sort(people);
		//1. 둘이서 타는 개수 세기
		int i = 0;
		for (int j=people.length-1; i<j; j--) {
			if (people[i] + people[j] <= limit) {
				i++;
			}
		}
		//2. 전체 개수에서 둘이서 타는 개수 빼기
		return people.length - i;
    }
}
