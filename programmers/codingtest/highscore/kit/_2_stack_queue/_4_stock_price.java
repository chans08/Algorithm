package codingtest.highscore.kit._2_stack_queue;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.01ms, 71.2MB)
테스트 2 〉	통과 (0.02ms, 74.6MB)
테스트 3 〉	통과 (0.13ms, 73.4MB)
테스트 4 〉	통과 (0.13ms, 84.4MB)
테스트 5 〉	통과 (0.16ms, 77.8MB)
테스트 6 〉	통과 (0.02ms, 73.9MB)
테스트 7 〉	통과 (0.08ms, 75.5MB)
테스트 8 〉	통과 (0.10ms, 77.8MB)
테스트 9 〉	통과 (0.02ms, 79.7MB)
테스트 10 〉	통과 (0.16ms, 75.4MB)
효율성  테스트
테스트 1 〉	통과 (15.96ms, 70MB)
테스트 2 〉	통과 (11.40ms, 68.6MB)
테스트 3 〉	통과 (12.56ms, 70.4MB)
테스트 4 〉	통과 (13.71ms, 70MB)
테스트 5 〉	통과 (9.81ms, 67MB)
 * @author CMN
 * @date 2022-03-02
 */
public class _4_stock_price {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3}; //[4, 3, 1, 1, 0]
		int[] answer = solution(prices);
		System.out.println("answer: " + Arrays.toString(answer));
	}
	
	/**
	 * @param prices 초 단위로 기록된 주식가격이 담긴 배열
	 * @return 가격을 유지한 최대 기간 배열
	 */
	public static int[] solution(int[] prices) {
		//1. 리턴할 답 배열 초기화
        int[] answer = new int[prices.length];
        //2. 주식 가격 배열을 돌며 최대로 가격을 유지한 시간을 잰다.
        for (int i=0; i<prices.length; i++) {
        	int notLowSec = 0;
        	for (int j=i+1; j<prices.length; j++) {
        		notLowSec++;
        		if (prices[j] < prices[i]) {
        			break;
        		}
        	}
        	answer[i] = notLowSec;
        }
        return answer;
    }
}
