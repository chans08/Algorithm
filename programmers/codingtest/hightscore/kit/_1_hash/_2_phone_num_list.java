package codingtest.highscore.kit._1_hash;

import java.util.Arrays;

/**
정확성  테스트
테스트 1 〉	통과 (0.24ms, 74.5MB)
테스트 2 〉	통과 (0.21ms, 67.5MB)
테스트 3 〉	통과 (0.27ms, 75.7MB)
테스트 4 〉	통과 (0.30ms, 76.7MB)
테스트 5 〉	통과 (0.24ms, 72.2MB)
테스트 6 〉	통과 (0.32ms, 70.9MB)
테스트 7 〉	통과 (0.34ms, 74.9MB)
테스트 8 〉	통과 (0.22ms, 71.4MB)
테스트 9 〉	통과 (0.27ms, 72.6MB)
테스트 10 〉	통과 (0.32ms, 75.3MB)
테스트 11 〉	통과 (0.34ms, 73.9MB)
테스트 12 〉	통과 (0.27ms, 75.1MB)
테스트 13 〉	통과 (0.19ms, 78MB)
테스트 14 〉	통과 (2.55ms, 79.2MB)
테스트 15 〉	통과 (2.54ms, 75.9MB)
테스트 16 〉	통과 (3.88ms, 74.6MB)
테스트 17 〉	통과 (4.62ms, 72.8MB)
테스트 18 〉	통과 (5.56ms, 69.5MB)
테스트 19 〉	통과 (6.07ms, 79.6MB)
테스트 20 〉	통과 (4.32ms, 79MB)
효율성  테스트
테스트 1 〉	통과 (22.73ms, 56.3MB)
테스트 2 〉	통과 (20.78ms, 56.4MB)
테스트 3 〉	통과 (338.07ms, 98.7MB)
테스트 4 〉	통과 (240.65ms, 97.3MB)
 * @author CMN
 *
 */
public class _2_phone_num_list {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"}; //false
		boolean answer = solution(phone_book);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * 단어에 초점을 두고 찾는다.
	 * @param phone_book
	 * @return
	 */
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		//1. 정렬한다.
		Arrays.sort(phone_book);
		//2. 앞의 단어가 뒤의 단어의 접두사가 되는지 확인한다.
		for (int i=0; i<phone_book.length-1; i++) {
			if (phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}
		return answer;
	}
}
