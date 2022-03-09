package codingtest.highscore.kit._2_stack_queue;

import java.util.Arrays;
import java.util.Stack;

/**
정확성  테스트
테스트 1 〉	통과 (0.10ms, 75MB)
테스트 2 〉	통과 (0.32ms, 77.5MB)
테스트 3 〉	통과 (1.12ms, 73.1MB)
테스트 4 〉	통과 (1.09ms, 76.5MB)
테스트 5 〉	통과 (1.10ms, 77.6MB)
테스트 6 〉	통과 (0.23ms, 76MB)
테스트 7 〉	통과 (1.01ms, 78.1MB)
테스트 8 〉	통과 (0.99ms, 74.6MB)
테스트 9 〉	통과 (0.17ms, 77.1MB)
테스트 10 〉	통과 (1.44ms, 73.9MB)
효율성  테스트
테스트 1 〉	통과 (28.90ms, 69.2MB)
테스트 2 〉	통과 (23.70ms, 69.1MB)
테스트 3 〉	통과 (34.63ms, 71.9MB)
테스트 4 〉	통과 (27.49ms, 71.6MB)
테스트 5 〉	통과 (26.76ms, 67.3MB)
 */
public class _4_stock_price3 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3}; //[4, 3, 1, 1, 0]
		int[] answer = solution(prices);
		System.out.println("answer: " + Arrays.toString(answer));
	}
	
	/**
	 * stack을 이용한 풀이 -> 최악의 경우에도 O(n) 이다...
	 * @param prices 초 단위로 기록된 주식가격이 담긴 배열
	 * @return 가격을 유지한 최대 기간 배열
	 */
	public static int[] solution(int[] prices) {
		//1. 필요한 자료 구조 초기화
		int[] maxSecToLowers = new int[prices.length];
		Stack<Integer> pricesIdxStack = new Stack<>();
		int currIdx = -1;
		for (int i=0; i<prices.length; i++) {
			//2. 가격이 떨어진 경우 stack에서 제거하며 최대 기간 기록
			while(!pricesIdxStack.isEmpty()
					&& prices[pricesIdxStack.peek()] > prices[i]) {
				currIdx = pricesIdxStack.pop();
				maxSecToLowers[currIdx] = i - currIdx;
			}
			//3. prices 차례로 stack에 입력(2.를 판단하기 위해)
			pricesIdxStack.push(i);
		}
		//4. 가격이 떨어지지 않아 stack에 남아있는 idx에 대하여 최대 기간 계산해서 기록
		while(!pricesIdxStack.isEmpty()) {
			currIdx = pricesIdxStack.pop();
			maxSecToLowers[currIdx] = prices.length - 1 - currIdx;
		}
		return maxSecToLowers;
    }
}
