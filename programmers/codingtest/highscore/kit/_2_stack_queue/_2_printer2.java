package codingtest.highscore.kit._2_stack_queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ** idxQueue를 만들어 location인지 알수있게 한다.!!
 * 
정확성  테스트
테스트 1 〉	통과 (0.72ms, 78MB)
테스트 2 〉	통과 (1.67ms, 82.2MB)
테스트 3 〉	통과 (0.82ms, 76.4MB)
테스트 4 〉	통과 (1.07ms, 86.6MB)
테스트 5 〉	통과 (0.46ms, 73.1MB)
테스트 6 〉	통과 (0.64ms, 72.4MB)
테스트 7 〉	통과 (0.59ms, 75.7MB)
테스트 8 〉	통과 (1.29ms, 71.2MB)
테스트 9 〉	통과 (0.56ms, 75MB)
테스트 10 〉	통과 (0.68ms, 73.6MB)
테스트 11 〉	통과 (1.05ms, 73.3MB)
테스트 12 〉	통과 (0.49ms, 77.3MB)
테스트 13 〉	통과 (1.17ms, 76.3MB)
테스트 14 〉	통과 (0.50ms, 74.8MB)
테스트 15 〉	통과 (0.47ms, 73.7MB)
테스트 16 〉	통과 (0.59ms, 73.1MB)
테스트 17 〉	통과 (1.08ms, 71.8MB)
테스트 18 〉	통과 (0.55ms, 75.4MB)
테스트 19 〉	통과 (1.18ms, 64.7MB)
테스트 20 〉	통과 (0.67ms, 72.7MB)
 * @author CMN
 * @date 2022-02-22
 */
public class _2_printer2 {
	public static void main(String[] args) {
//		int[] priorities = {2, 1, 3, 2};
//		int location = 2; //1
		
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0; //5
		
//		int[] priorities = {1, 1, 7, 1, 9, 1, 1};
//		int location = 1;
		int answer = solution(priorities, location); 
		System.out.println("answer: " + answer);
	}
	
	/**
	 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
	 * @param priorities 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열
	 * @param location 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지(zero-index)
	 * @return 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지
	 */
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        //1. 조건에 맞는 자료구조 초기화(descPriorityQueue, idxQueue)
        Queue<Integer> descPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> idxQueue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
        	descPriorityQueue.offer(priorities[i]);
        	idxQueue.offer(i);
        }
        //2. idxQueue가 빌떄까지 while문을 돌며,
        // 찾고자하는 위치의 중요도가 나올 떄까지 규칙에 따라 뒤로 넣거나 출력하기
        while(!idxQueue.isEmpty()) {
        	int currIdx = idxQueue.poll();
        	int currValue = priorities[currIdx];
        	if (currValue >= descPriorityQueue.peek()) {
        		//2-1. 현재 중요도가 최대 중요도인 경우 -> 출력
        		descPriorityQueue.poll();
        		answer++;
        		//2-3. 찾고자 하는 위치를 출력한 경우 종료
        		if (currIdx == location) {
        			break;
        		}
        	} else {
        		//2-2. 그렇지 않으면 -> 뒤로 넣기
        		idxQueue.offer(currIdx);
        	}
        }
        return answer;
    }
}
