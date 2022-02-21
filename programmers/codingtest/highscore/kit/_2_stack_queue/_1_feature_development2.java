package codingtest.highscore.kit._2_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.34ms, 77.6MB)
테스트 2 〉	통과 (0.48ms, 74.3MB)
테스트 3 〉	통과 (0.36ms, 73.7MB)
테스트 4 〉	통과 (0.33ms, 70.9MB)
테스트 5 〉	통과 (0.32ms, 71MB)
테스트 6 〉	통과 (0.31ms, 75.3MB)
테스트 7 〉	통과 (0.45ms, 73.2MB)
테스트 8 〉	통과 (0.32ms, 77.1MB)
테스트 9 〉	통과 (0.36ms, 76.8MB)
테스트 10 〉	통과 (0.39ms, 76.5MB)
테스트 11 〉	통과 (0.37ms, 72.3MB)
 * 
 * **정답 변형에서 stream을 사용했을 경우 for문으로 도는것보다 훨씬 느리다.
정확성  테스트
테스트 1 〉	통과 (2.23ms, 73.2MB)
테스트 2 〉	통과 (3.87ms, 91.6MB)
테스트 3 〉	통과 (2.23ms, 74.6MB)
테스트 4 〉	통과 (2.36ms, 80.7MB)
테스트 5 〉	통과 (3.13ms, 81.1MB)
테스트 6 〉	통과 (2.22ms, 72.6MB)
테스트 7 〉	통과 (2.24ms, 77.9MB)
테스트 8 〉	통과 (2.74ms, 75.4MB)
테스트 9 〉	통과 (2.75ms, 78.4MB)
테스트 10 〉	통과 (2.68ms, 75.7MB)
테스트 11 〉	통과 (3.34ms, 77.7MB)
 * 
 * queue의 size, clear를 이용한 풀이
 * @author CMN
 * @date 2022-02-21
 */
public class _1_feature_development2 {
	public static void main(String[] args) {
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		int[] answer = solution(progresses, speeds);
		System.out.println("answer: " + Arrays.toString(answer));
	}
	
	/**
	 * @param progresses 배포되어야 하는 순서대로 작업의 진도율
	 * @param speeds 작업의 개발 속도
	 * @return 각 배포마다 몇 개의 기능이 배포되는지
	 */
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        //1. 필요한 자료구조 세팅(정답을 담을 featureNumList, 잔여일을 담아서 기능을 셀 때 사용할 remainDaysQueue)
        List<Integer> featureNumList = new ArrayList<>();
        Queue<Integer> remainDaysQueue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
        	//2. 잔여일 구하여 queue에 담고 그보다 작은 잔여일들을 가진 잔여일 수를 센다.(queue에 담아 size 찾기)
        	int remainDay = (int)Math.ceil((double)(100-progresses[i]) / speeds[i]);
        	if (!remainDaysQueue.isEmpty() && remainDaysQueue.peek() < remainDay) {
        		featureNumList.add(remainDaysQueue.size());
        		remainDaysQueue.clear();
        	}
        	remainDaysQueue.offer(remainDay);
        }
        featureNumList.add(remainDaysQueue.size());
        //3. 정답 형식에 맞추어 변형한다.
        //answer = featureNumList.stream().mapToInt(Integer::intValue).toArray();
        answer = new int[featureNumList.size()];
        for (int i=0; i<featureNumList.size(); i++) {
        	answer[i] = featureNumList.get(i);
        }
        return answer;
    }
}
