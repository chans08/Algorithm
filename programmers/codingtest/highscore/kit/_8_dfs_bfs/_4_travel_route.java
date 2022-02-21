package codingtest.hightscore.kit._8_dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
테스트 1 〉	통과 (30.94ms, 84.7MB)
테스트 2 〉	통과 (0.03ms, 75.2MB)
테스트 3 〉	통과 (0.05ms, 73.4MB)
테스트 4 〉	통과 (0.04ms, 76.2MB)
 */
public class _4_travel_route {
	public static void main(String[] args) {
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; //test1
		//test1: ["ICN", "JFK", "HND", "IAD"]
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}; //test2
		//test2: ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		//String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}; //test3
		//test3: ["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
		String[] answer = solution(tickets);
		System.out.println(Arrays.toString(answer)); //[ICN, SFO, ATL, ICN, ATL, null]
		//["ICN", "JFK", "HND", "IAD"]
		//["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		//isLexicogradicallyPreceedTest();
	}

	public static void isLexicogradicallyPreceedTest() {
		List<String> route = Arrays.asList("ICN", "ATL", "SFO", "ATL", "ICN", "SFO");
		String[] answer = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
		boolean isLexicogradicallyPreceed = isLexicogradicallyPreceed(route, answer);
		System.out.println("isLexicogradicallyPreceed: " + isLexicogradicallyPreceed);
	}
	
	private static final String START = "ICN";
	public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        //1. 모든 티켓 중 ICN 출발지를 시작점으로 돌아가며 조건에 맞는 경로를 찾는다.
        for (int i=0; i<tickets.length; i++) {
			if (tickets[i][0].equals(START)) {
				//System.out.println("i = " + i + " ======================================");
				boolean[] isUsed = new boolean[tickets.length];
				isUsed[i] = true;
				List<String> route = new ArrayList<>();
				route.add(tickets[i][0]);
				route.add(tickets[i][1]);
				//2. 경로 찾기
				dfsR(tickets, i, isUsed, route, answer);
			}
		}
        return answer;
    }
	
	private static void dfsR(String[][] tickets, int ticketIdx, boolean[] isUsed, List<String> route, String[] answer) {
		//2-1. 티켓을 모두 사용하여 만든 경로를 answer 에 담는다.
		if (route.size() == tickets.length+1) {
			//2-1-1. answer에 처음으로 만들어진 route를 넣는다.
			if (answer[tickets.length] == null) {
				copyList(answer, route);
				return;
			}
			//2-1-2. 기존 answer보다 route가 사전적으로 더 앞서면 answer를 route로 대체한다.
			if (isLexicogradicallyPreceed(route, answer)) {
				copyList(answer, route);
				//System.out.println("copiedAnswer: " + Arrays.toString(answer));
				return;
			}
			//2-1-3. 그렇지 않으면 answer를 그대로 리턴한다.
			return;
		}
		
		//2-2. 사용하지 않은 티켓 중 이어서 경로를 갈 수 있는 티켓을 dfs로 탐색한다.
		for (int i=0; i<tickets.length; i++) {
			if (!isUsed[i] && tickets[ticketIdx][1].equals(tickets[i][0])) {
				isUsed[i] = true;
				route.add(tickets[i][1]);
				dfsR(tickets, i, isUsed, route, answer);
				isUsed[i] = false;
				route.remove(route.size()-1);
			}
		}
	}

	private static boolean isLexicogradicallyPreceed(List<String> route, String[] answer) { 
		for (int i=0; i<answer.length; i++) {
			if (route.get(i).compareTo(answer[i]) == 0) {
				continue;
			}
			//System.out.println("route: " + route.get(i) + ", answer: " + answer[i] + " >>> " + route.get(i).compareTo(answer[i]));
			if (route.get(i).compareTo(answer[i]) < 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private static String[] copyList(String[] dest, List<String> src) {
		for (int i=0; i<src.size(); i++) {
			dest[i] = src.get(i);
		}
		return dest;
	}
}
