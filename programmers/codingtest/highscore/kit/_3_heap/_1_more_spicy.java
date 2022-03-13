package codingtest.highscore.kit._3_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * *** scoville을 섞을 때마다 줄어들어서 2개가 안남을 수도 있기 때문에 queue 사이즈에 주의해야 한다!!
정확성  테스트
테스트 1 〉	통과 (1.14ms, 77MB)
테스트 2 〉	통과 (0.65ms, 73.9MB)
테스트 3 〉	통과 (1.31ms, 77.1MB)
테스트 4 〉	통과 (1.13ms, 75.9MB)
테스트 5 〉	통과 (0.63ms, 80.5MB)
테스트 6 〉	통과 (2.32ms, 78.6MB)
테스트 7 〉	통과 (2.17ms, 75.1MB)
테스트 8 〉	통과 (1.07ms, 79.9MB)
테스트 9 〉	통과 (1.31ms, 77.7MB)
테스트 10 〉	통과 (3.37ms, 74.8MB)
테스트 11 〉	통과 (2.27ms, 76.2MB)
테스트 12 〉	통과 (3.39ms, 71.8MB)
테스트 13 〉	통과 (2.28ms, 75.8MB)
테스트 14 〉	통과 (0.72ms, 75MB)
테스트 15 〉	통과 (2.50ms, 74.2MB)
테스트 16 〉	통과 (0.65ms, 78.1MB)
효율성  테스트
테스트 1 〉	통과 (244.86ms, 68.6MB)
테스트 2 〉	통과 (410.34ms, 90MB)
테스트 3 〉	통과 (956.06ms, 125MB)
테스트 4 〉	통과 (182.29ms, 81.5MB)
테스트 5 〉	통과 (1105.50ms, 129MB)
 * @author CMN
 * @date 2022-03-09
 */
public class _1_more_spicy {
	public static void main(String[] args) {
//		int[] scoville = {1, 2, 3, 9, 10, 12};
//		int K = 7;
		int[] scoville = {1, 2};
		int K = 7;
		
		int answer = solution(scoville, K);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * - 조건
	 * 	- scoville의 길이는 2 이상 1,000,000 이하
	 * 	- K는 0 이상 1,000,000,000 이하
	 * 	- scoville의 원소는 각각 0 이상 1,000,000 이하
	 * 
	 * @param scoville
	 * @param K
	 * @return
	 */
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        //1. 필요한 자료구조 초기화한다.
        Arrays.sort(scoville);
        Queue<Integer> scovillePQueue = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
        	scovillePQueue.offer(scoville[i]);
        }
        //2. 모든 값이 0일 경우에는 scoville을 K 이상으로 만들 수 없으므로 -1을 리턴한다.
        if (scoville[scoville.length-1] == 0) {
        	return -1;
        }
        //3. scoville 지수가 k 이상인지 확인한다.
        if (scoville[0] >= K) {
        	return answer;
        }
        //4. mix 하여 scoville 지수를 크게 한다.
        int smallest = 0;
        int sndSmallest = 0;
        while (scovillePQueue.peek() < K) {
        	if (scovillePQueue.size() < 2) {
        		return -1;
        	}
        	smallest = scovillePQueue.poll();
        	sndSmallest = scovillePQueue.poll();
        	scovillePQueue.offer(smallest + sndSmallest * 2);
        	answer++;
        }
        
        return answer;
    }
}
