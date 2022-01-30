package codingtest.highscore.kit._1_hash;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 정확성  테스트
테스트 1 〉	통과 (7.07ms, 71MB)
테스트 2 〉	통과 (6.12ms, 73MB)
테스트 3 〉	통과 (5.79ms, 82.1MB)
테스트 4 〉	통과 (5.42ms, 78.9MB)
테스트 5 〉	통과 (5.32ms, 85.4MB)
테스트 6 〉	통과 (5.27ms, 89.4MB)
테스트 7 〉	통과 (4.98ms, 77.4MB)
테스트 8 〉	통과 (5.41ms, 81.2MB)
테스트 9 〉	통과 (4.74ms, 73MB)
테스트 10 〉	통과 (6.98ms, 73.5MB)
테스트 11 〉	통과 (5.76ms, 77.4MB)
테스트 12 〉	통과 (5.02ms, 74.3MB)
테스트 13 〉	통과 (7.10ms, 74.9MB)
테스트 14 〉	통과 (5.10ms, 73.2MB)
테스트 15 〉	통과 (7.16ms, 73.8MB)
테스트 16 〉	통과 (5.17ms, 83MB)
테스트 17 〉	통과 (7.52ms, 79.9MB)
테스트 18 〉	통과 (5.80ms, 72.8MB)
테스트 19 〉	통과 (5.42ms, 76.9MB)
테스트 20 〉	통과 (4.83ms, 85.8MB)
테스트 21 〉	통과 (5.72ms, 81.4MB)
테스트 22 〉	통과 (5.84ms, 71.3MB)
테스트 23 〉	통과 (5.24ms, 81.3MB)
테스트 24 〉	통과 (4.77ms, 75.2MB)
테스트 25 〉	통과 (6.61ms, 80.9MB)
테스트 26 〉	통과 (6.62ms, 76.6MB)
테스트 27 〉	통과 (4.78ms, 84.2MB)
테스트 28 〉	통과 (6.07ms, 78MB)
 * @author CMN
 *
 */
public class _3_camouflage5_just_practice {
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}; //5
		int answer = solution(clothes);
		System.out.println("answer: " + answer);
	}
	
	public static int solution(String[][] clothes) {
		int answer = Arrays.stream(clothes)
			.collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting())))
			.values()
			.stream()
			.reduce(1L, (a, b) -> a * (b + 1))
			.intValue() - 1;
		return answer;
    }
}
