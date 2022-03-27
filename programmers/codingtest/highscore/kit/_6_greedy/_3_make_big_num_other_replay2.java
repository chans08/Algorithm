package codingtest.highscore.kit._6_greedy;

import java.util.Stack;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.20ms, 73.4MB)
테스트 2 〉	통과 (0.21ms, 81.4MB)
테스트 3 〉	통과 (0.36ms, 77.3MB)
테스트 4 〉	통과 (0.88ms, 77.1MB)
테스트 5 〉	통과 (1.22ms, 73.6MB)
테스트 6 〉	통과 (7.25ms, 76.8MB)
테스트 7 〉	통과 (18.26ms, 77.9MB)
테스트 8 〉	통과 (21.14ms, 78.9MB)
테스트 9 〉	통과 (28.47ms, 95.6MB)
테스트 10 〉	통과 (72.57ms, 91.9MB)
테스트 11 〉	통과 (0.22ms, 79MB)
테스트 12 〉	통과 (0.19ms, 80.8MB)
 * @author CMN
 * @date 2022-03-27
 */
public class _3_make_big_num_other_replay2 {
	public static void main(String[] args) {
//		String number = "1924";
//		int k = 2; //"94"
//		String number = "1231234";
//		int k = 3; //"3234"
//		String number = "4177252841";
//		int k = 4; //"775841"
//		String number = "6617423282157290684025607883097699259905250470744165128706131448395502185407310941966307933122347117";
//        int k = 61; //answer: 999999955285407310941966307933122347117
		String number = "654321";
        int k = 5; //6
		String answer = solution(number, k);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * * stack으로 풀기
	 * * 앞의 수가 현재 수보다 작으면 앞의 수를 제거해준다.
	 * 
	 * - 제한 조건
		- number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
		- k는 1 이상 number의 자릿수 미만인 자연수입니다.
	 * @param number 문자열 형식으로 숫자
	 * @param k 제거할 수의 개수
	 * @return number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자
	 */
	//1924
	public static String solution(String number, int k) {
		char[] _answer = new char[number.length()-k];
		//1. 필요한 자료구조 세팅
		Stack<Character> numberStack = new Stack<>();
		//2. 마지막으로 담은 수보다 현재 담으려는 number가 크면 제거하고 담는다.
		for (int i=0; i<number.length(); i++) {
			while(!numberStack.isEmpty() && k > 0 && numberStack.peek() < number.charAt(i)) {
				k--;
				numberStack.pop();
			}
			numberStack.push(number.charAt(i));
		}
		//3. answer로 형식 변형
		for (int i=0; i<_answer.length; i++) {
			_answer[i] = numberStack.get(i);
		}
		return new String(_answer);
    }
}
