package codingtest.highscore.kit._2_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.75ms, 72.3MB)
테스트 2 〉	통과 (6.99ms, 80MB)
테스트 3 〉	통과 (0.12ms, 83.7MB)
테스트 4 〉	통과 (6.75ms, 75.3MB)
테스트 5 〉	통과 (26.32ms, 85.9MB)
테스트 6 〉	통과 (13.56ms, 82MB)
테스트 7 〉	통과 (1.27ms, 78.7MB)
테스트 8 〉	통과 (0.56ms, 78MB)
테스트 9 〉	통과 (2.47ms, 77.5MB)
테스트 10 〉	통과 (0.78ms, 79.7MB)
테스트 11 〉	통과 (0.21ms, 75.8MB)
테스트 12 〉	통과 (0.93ms, 75.5MB)
테스트 13 〉	통과 (1.58ms, 77.9MB)
테스트 14 〉	통과 (0.12ms, 75.9MB)
 * @author CMN
 * @date 2022-03-02
 */
public class _3_truck_crossing_the_bridge {
	public static void main(String[] args) {
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6}; //8
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10}; //101
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; //110
		int answer = solution(bridge_length, weight, truck_weights);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * while문을 돌면서 경과시간에 따라 다리를 건너는 트럭이 빈 큐가 되는 시점을 출력한다.
	 * @param bridge_length 다리 길이
	 * @param weight 다리의 견딜 수 있는 최대 하중
	 * @param truck_weights 트럭의 무게 배열
	 * @return 모든 트럭이 다리를 건너려면 최소 몇 초인지
	 */
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //1. 필요한 자료 구조 초기화(다리를 건너는 트럭 큐, 트럭의 다리 위에서의 시간(간거리와도 같음) 맵, 다리위 하중 sum 값)
        Queue<Integer> crossingBridgeTruckQueue = new LinkedList<>();
        int weightOnBridge = 0;
        int truckWeightsIdx = 0;
        int truckWeight = 0;
        int outTruckIdx = -1;
        //2. truck_weights를 돌면서 조건에 따라 다리에 트럭을 보내며 시간을 잰다.
        //	이때, 트럭이 들어갈 수 없을 때에는 -1 truckIdx를 넣어주어 시간을 QueueSize로 관리한다.
        while (truckWeightsIdx < truck_weights.length) {
        	//2-3. bridge_length초가 지나면 트럭은 다리를 통과한다.
        	if (crossingBridgeTruckQueue.size() == bridge_length) {
        		outTruckIdx = crossingBridgeTruckQueue.poll();
        		weightOnBridge -= outTruckIdx == -1 ? 0 : truck_weights[outTruckIdx];
        	}
        	//2-1. 다음 출발할 트럭의 무게를 현재 다리의 트럭 무게와 합하여 총 부하량보다 작은지 조사하여 다리에 트럭을 보내던지 안보내던지 결정한다.
        	truckWeight =  truck_weights[truckWeightsIdx];
        	if (weightOnBridge + truckWeight <= weight) {
        		//다리에 트럭을 보낸다.
        		crossingBridgeTruckQueue.offer(truckWeightsIdx);
        		weightOnBridge += truckWeight;
        		truckWeightsIdx++;
        	} else {
        		//다리에 트럭을 보내지 않는다.
        		crossingBridgeTruckQueue.offer(-1);
        	}
        	//2-2. 경과 시간을 기록한다.
        	answer++;
        }
        //2-4. 마지막 트럭이 다리를 모두 지나갈 때까지의 경과 시간인 bridge_length를 더한다.
        return answer + bridge_length;
    }
}
