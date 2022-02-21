package codingtest.hightscore.kit._8_dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
테스트 1 〉	통과 (85.20ms, 134MB)
테스트 2 〉	통과 (12.22ms, 82MB)
테스트 3 〉	통과 (12.64ms, 82.7MB)
테스트 4 〉	통과 (10.50ms, 78.4MB)
 * @author CMN
 *
 */
public class _4_travel_route2 {
	public static void main(String[] args) {
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; //test1
		//test1: ["ICN", "JFK", "HND", "IAD"]
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}; //test2
		//test2: ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		//String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}; //test3
		//test3: ["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
		String[] answer = solution(tickets);
		System.out.println(Arrays.toString(answer));
	}

	public static String[] solution(String[][] tickets) {
        String[] answer = {};
        List<String> courses = new ArrayList<>();
        boolean[] isUsed = new boolean[tickets.length];
        //1. dfsR을 돌며 ICN으로 시작하는 티켓을 모두 사용하는 여행 경로를 courses에 담는다.
        dfsR(tickets, isUsed, "ICN", 0, "ICN", courses);
        
        //2. A,B,C  ... 와 같은 경로들을 사전 순으로 정렬하여 가장 첫번째 경로를 택한다.
        Collections.sort(courses);
        answer = courses.get(0).split(",");
        return answer;
    }

	/**
	 * 출발점에 초점을 맞춰 dfsR을 돈다.
	 * @param tickets
	 * @param isUsed
	 * @param from
	 * @param toCnt
	 * @param route
	 * @param courses
	 */
	private static void dfsR(String[][] tickets, boolean[] isUsed, String from, int toCnt, String route, List<String> courses) {
		//2-1. ticket을 모두 사용한 경로를 courses에 담는다.
		if (toCnt == tickets.length) {
			courses.add(route);
			return;
		}
		
		//2-2. ticket을 탐색하며 경로를 만들어나간다.
		for (int i=0; i<tickets.length; i++) {
			if (!isUsed[i] && tickets[i][0].equals(from)) {
				isUsed[i] = true;
				dfsR(tickets, isUsed, tickets[i][1], toCnt+1, route + "," + tickets[i][1], courses);
				isUsed[i] = false;
			}
		}
	}
}
