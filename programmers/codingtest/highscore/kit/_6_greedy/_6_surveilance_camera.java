package codingtest.highscore.kit._6_greedy;

import java.util.Arrays;

/**
 * @참고: https://programmers.co.kr/questions/27135
 * 
 * 정확성  테스트
테스트 1 〉	통과 (0.72ms, 82.7MB)
테스트 2 〉	통과 (0.66ms, 72.1MB)
테스트 3 〉	통과 (0.75ms, 76.7MB)
테스트 4 〉	통과 (0.49ms, 74.7MB)
테스트 5 〉	통과 (0.50ms, 73.1MB)
효율성  테스트
테스트 1 〉	통과 (4.15ms, 52.7MB)
테스트 2 〉	통과 (2.25ms, 52.6MB)
테스트 3 〉	통과 (6.90ms, 69.1MB)
테스트 4 〉	통과 (0.94ms, 52.6MB)
테스트 5 〉	통과 (13.68ms, 58.4MB)
 * @author CMN
 * @date 2022-04-06
 */
public class _6_surveilance_camera {
	public static void main(String[] args) {
//		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}; //2
//		int[][] routes = {{-20,-14}, {-14,-5}, {-18,-13}, {-5,-3}}; //2
		int[][] routes = {{-20,-15}, {-14,-5}, {-6,-5}, {-18,-13}, {-14,-13}, {-5,-3}, {-4,-3}, {-4,-3}, {-4,-3}}; //4
		int answer = solution(routes);
		System.out.println("answer: " + answer);
	}
	
	public static int solution(int[][] routes) {
		int total = 0;
		// 진출 오름차순으로 정렬
        Arrays.sort(routes, (route1, route2) -> route1[1] - route2[1]);
        int end = -30001;
        int start = 0;
        for (int i=0; i<routes.length; i++) {
        	start = routes[i][0];
        	if (start > end) {
        		end = routes[i][1];
        		//System.out.println("end: " + end);
        		total++;
        	}
        }
        return total;
    }
}
