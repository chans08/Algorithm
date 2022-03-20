package codingtest.highscore.kit._3_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
정확성  테스트
테스트 1 〉	통과 (0.68ms, 70.4MB)
테스트 2 〉	통과 (0.73ms, 75.6MB)
테스트 3 〉	통과 (0.95ms, 78.1MB)
테스트 4 〉	통과 (0.73ms, 79.7MB)
테스트 5 〉	통과 (0.70ms, 72.2MB)
테스트 6 〉	통과 (0.76ms, 75MB)
 * @author CMN
 * @date 2022-03-15
 */
public class _3_double_priority_queue {
	public static void main(String[] args) {
		//String[] operations = {"I 16","D 1"}; // {0,0}
//		String[] operations = {"I 7","I 5","I -5","D -1"}; // {7,5}
//		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // {0, 0}
//		String[] operations = {"D -1"}; // {0, 0}
		String[] operations = {"I 16", "I 16", "D -1", "D 1", "D 1", "I 16", "D -1"}; // {0, 0}
		int[] answer = solution(operations);
		System.out.println("answer: " + Arrays.toString(answer));
	}
	
	/**
	 * - 조건
	 * 	명령어	수신 탑(높이)
		I 숫자	큐에 주어진 숫자를 삽입합니다.
		D 1		큐에서 최댓값을 삭제합니다.
		D -1	큐에서 최솟값을 삭제합니다.
		
		- 제한사항
			- operations는 길이가 1 이상 1,000,000 이하인 문자열 배열
			- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시
		
	 * @param operations 이중 우선순위 큐가 할 연산
	 * @return 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return
	 */
	public static final String I = "I";
	public static final String D = "D";
	public static int[] solution(String[] operations) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        String[] operationArr;
        String instructionKey;
        int instructionValue;
        for (int i=0; i<operations.length; i++) {
        	//1. operation 에 해당하는 명령을 시행하기
        	//1-1. 주어진 자료 초기화
        	operationArr = operations[i].split(" ");
        	instructionKey = operationArr[0];
        	instructionValue = Integer.parseInt(operationArr[1]);
        	//1-2. I 명령의 경우 주어진 값 삽입 
        	if (instructionKey.equals(I)) {
        		maxHeap.offer(instructionValue);
        		minHeap.offer(instructionValue);
        		continue;
        	}
        	//1-3. D 명령의 경우 주어진 값에 따라 최대 또는 최소값 삭제
        	//	이 때, 비어있는 heap에 대하여 동기화
        	int polledValue;
        	if (instructionKey.equals(D)
        			&& !maxHeap.isEmpty()) {
        		if (instructionValue == 1) {
        			polledValue = maxHeap.poll();
        			minHeap.remove(polledValue);
        		} else {
        			polledValue = minHeap.poll();
        			maxHeap.remove(polledValue);
        		}
        	}
        }
        //2. 원하는 답 구하기
        if (maxHeap.isEmpty()) {
        	return new int[]{0, 0};
        } else {
        	return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}
