package codingtest.highscore.kit._4_sort;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (1746.67ms, 393MB)
테스트 2 〉	통과 (622.09ms, 395MB)
테스트 3 〉	통과 (2828.04ms, 406MB)
테스트 4 〉	통과 (15.55ms, 89.9MB)
테스트 5 〉	통과 (1375.79ms, 392MB)
테스트 6 〉	통과 (1080.51ms, 381MB)
테스트 7 〉	통과 (3.04ms, 68.7MB)
테스트 8 〉	통과 (2.94ms, 74.5MB)
테스트 9 〉	통과 (2.99ms, 75MB)
테스트 10 〉	통과 (2.92ms, 74MB)
테스트 11 〉	통과 (3.25ms, 76.7MB)
테스트 12 〉	통과 (2.67ms, 70.3MB)
테스트 13 〉	통과 (2.73ms, 73.6MB)
테스트 14 〉	통과 (2.97ms, 76.4MB)
테스트 15 〉	통과 (3.15ms, 73.1MB)
 * @author CMN
 * @date 2022-02-09
 */
public class _2_biggest_num3_practice {
	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2}; //"6210"
//		int[] numbers = {3, 30, 34, 5, 9}; //
		int[] numbers = {0, 0, 0}; //"0"
		String answer = solution(numbers); //"9534330"
		System.out.println("answer: " + answer);
	}
	
	public static String solution(int[] numbers) {
		String answer = Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.sorted((n1, n2) -> (n2+n1).compareTo(n1+n2))
			.reduce("", (n1, n2) -> n1.equals("0") ? "0" : n1.concat(n2));
		return answer;
    }
}
