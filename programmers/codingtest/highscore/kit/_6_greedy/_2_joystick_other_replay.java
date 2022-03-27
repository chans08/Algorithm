package codingtest.highscore.kit._6_greedy;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.04ms, 68.6MB)
테스트 2 〉	통과 (0.03ms, 74.5MB)
테스트 3 〉	통과 (0.02ms, 74.1MB)
테스트 4 〉	통과 (0.04ms, 75.1MB)
테스트 5 〉	통과 (0.06ms, 75.1MB)
테스트 6 〉	통과 (0.04ms, 78.6MB)
테스트 7 〉	통과 (0.04ms, 78.5MB)
테스트 8 〉	통과 (0.03ms, 76.1MB)
테스트 9 〉	통과 (0.03ms, 78.1MB)
테스트 10 〉	통과 (0.06ms, 76.4MB)
테스트 11 〉	통과 (0.03ms, 74.7MB)
테스트 12 〉	통과 (0.05ms, 82.3MB)
테스트 13 〉	통과 (0.03ms, 73.5MB)
테스트 14 〉	통과 (0.03ms, 72.8MB)
테스트 15 〉	통과 (0.04ms, 77MB)
테스트 16 〉	통과 (0.03ms, 78.4MB)
테스트 17 〉	통과 (0.03ms, 78.2MB)
테스트 18 〉	통과 (0.05ms, 77.2MB)
테스트 19 〉	통과 (0.03ms, 72.7MB)
테스트 20 〉	통과 (0.04ms, 78.1MB)
테스트 21 〉	통과 (0.04ms, 73MB)
테스트 22 〉	통과 (0.05ms, 72.7MB)
테스트 23 〉	통과 (0.03ms, 78MB)
테스트 24 〉	통과 (0.04ms, 73.9MB)
테스트 25 〉	통과 (0.05ms, 75.2MB)
테스트 26 〉	통과 (0.03ms, 71.5MB)
테스트 27 〉	통과 (0.05ms, 78.9MB)
 * @author CMN
 * @date 2022-03-28
 */
public class _2_joystick_other_replay {
	public static void main(String[] args) {
//		String name = "JEROEN"; //56
//		String name = "JAN"; //23
//		String name = "A"; //0
//		String name = "JAZ"; //11(10 + 1)
//		String name = "BBBBAAAABA"; //12(5+7)
		String name = "BBAA"; //3(2+1)
		int answer = solution(name);
		System.out.println("answer: "+ answer);
	}
	
	/**
	 * ** 깔끔한 풀이!!
	 * @참고: https://programmers.co.kr/learn/courses/30/lessons/42860/solution_groups?language=java
	 * 
	 * - 맨 처음엔 A로만 이루어져
	 * - 조이스틱 이동
	 	▲ - 다음 알파벳
		▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
		◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
	 - 제한 사항
		name은 알파벳 대문자로만 이루어져 있습니다.
		name의 길이는 1 이상 20 이하입니다.
	 * @param name 만들고자 하는 이름
	 * @return 조이스틱 조작 횟수의 최솟값
	 */
	//JAZ
	//BBAA
	public static int solution(String name) {
		int answer = 0;
		int nameLength = name.length();
		//0. 각 알파벳의 조작 cnt 담기
		int[] alphabetMoveCnt = new int[26];
		for (int i=0; i<26; i++) {
			alphabetMoveCnt[i] = Math.min(i, 26-i);
		}
		//1. 알파벳 움직임 세기
		for (char alphabet : name.toCharArray()) {
			answer += alphabetMoveCnt[alphabet-'A'];
		}
		//System.out.println("answer: " + answer);
		//2. 최소 커서 이동 찾기
		int minCursorMoveCnt = nameLength-1;
		for (int i=0; i<nameLength; i++) {
			int j = i+1;
			while (j < nameLength && name.charAt(j) == 'A') {
				j++;
			}
			minCursorMoveCnt = Math.min(minCursorMoveCnt,
					nameLength - (j - i) + Math.min(i, nameLength - j));
		}
		//System.out.println("minCursorMoveCnt: " + minCursorMoveCnt);
        return answer + minCursorMoveCnt;
    }
}
