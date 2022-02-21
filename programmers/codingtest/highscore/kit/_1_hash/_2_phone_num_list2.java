package codingtest.highscore.kit._1_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.11ms, 67.1MB)
테스트 2 〉	통과 (0.12ms, 78MB)
테스트 3 〉	통과 (0.11ms, 77.9MB)
테스트 4 〉	통과 (0.18ms, 73.8MB)
테스트 5 〉	통과 (0.12ms, 73.2MB)
테스트 6 〉	통과 (0.11ms, 73.2MB)
테스트 7 〉	통과 (0.12ms, 74.9MB)
테스트 8 〉	통과 (0.23ms, 78.7MB)
테스트 9 〉	통과 (0.17ms, 72.2MB)
테스트 10 〉	통과 (0.14ms, 71.3MB)
테스트 11 〉	통과 (0.12ms, 73.7MB)
테스트 12 〉	통과 (0.12ms, 73.4MB)
테스트 13 〉	통과 (0.14ms, 72.5MB)
테스트 14 〉	통과 (1.44ms, 86.5MB)
테스트 15 〉	통과 (1.91ms, 77.1MB)
테스트 16 〉	통과 (6.97ms, 89MB)
테스트 17 〉	통과 (4.77ms, 82.7MB)
테스트 18 〉	통과 (7.65ms, 78.5MB)
테스트 19 〉	통과 (5.08ms, 79.2MB)
테스트 20 〉	통과 (4.60ms, 84.8MB)
효율성  테스트
테스트 1 〉	통과 (4.93ms, 56.2MB)
테스트 2 〉	통과 (3.32ms, 56.4MB)
테스트 3 〉	통과 (263.30ms, 244MB)
테스트 4 〉	통과 (323.14ms, 192MB)
 * @author CMN
 *
 */
public class _2_phone_num_list2 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"}; //false
		boolean answer = solution(phone_book);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * 단어의 접두어에 초점을 두고 찾는다.
	 * @param phone_book
	 * @return
	 */
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		//1. phoneNum를 담은 set을 만든다.
		Set<String> phoneNumSet = new HashSet<String>(Arrays.asList(phone_book));
		//2. set에서 자기자신의 접두어를 갖는 phoneNum를 찾는다.
		for (String phoneNum : phoneNumSet) {
			for (int i=1; i<phoneNum.length(); i++) {
				if (phoneNumSet.contains(phoneNum.substring(0, i))) {
					return false;
				}
			}
		}
		return answer;
	}
}
