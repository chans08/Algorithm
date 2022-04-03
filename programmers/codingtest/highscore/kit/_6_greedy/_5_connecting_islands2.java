package codingtest.highscore.kit._6_greedy;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.43ms, 76.8MB)
테스트 2 〉	통과 (0.42ms, 75MB)
테스트 3 〉	통과 (0.44ms, 77MB)
테스트 4 〉	통과 (0.48ms, 75.4MB)
테스트 5 〉	통과 (0.52ms, 67.4MB)
테스트 6 〉	통과 (0.75ms, 72.3MB)
테스트 7 〉	통과 (0.59ms, 76.2MB)
테스트 8 〉	통과 (0.44ms, 76MB)
 * 
 * @참고: https://maetdori.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%84%AC-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0 
 * @author CMN
 * @date 2022-04-03
 */
public class _5_connecting_islands2 {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}; //4
//		int[][] costs = {{1,0,1},{2,0,2},{2,1,5},{3,1,1},{3,2,8}}; //4
//		int n = 5;
//		int[][] costs = {{0,1,1},{1,4,5},{4,2,5},{2,3,1}}; //12
//		int n = 5;
//		int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}; //15
//		int n = 5;
//		int[][] costs = {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}}; //8
//		int n = 4;
//		int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {1, 3, 2}, {0, 3, 4}}; //9
//		int n = 5;
//		int[][] costs = {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}}; //104
//		int n = 6;
//		int[][] costs = {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}}; //11
//		int n = 5;
//		int[][] costs = {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}}; //6
//		int n = 5;
//		int[][] costs = {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}}; //8
//		int n = 5;
//		int[][] costs = {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4}, {1, 3, 1}}; //8
		
		int answer = solution(n, costs);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * - 제한사항
		- 섬의 개수 n은 1 이상 100 이하입니다.
		- costs의 길이는 ((n-1) * n) / 2이하입니다.
		- 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
		- 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
		- 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다. ???
		- 연결할 수 없는 섬은 주어지지 않습니다.
	 * @param n 섬의 개수
	 * @param costs costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용
	 * @return 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용
	 */
	public static int solution(int n, int[][] costs) {
		int total = 0;
		//크루스칼 알고리즘을 사용하기 위해 가중치 기준 오름차순 정렬
		//크루스칼 알고리즘: 비용이 작은 순으로 섬을 연결해 간다.
		Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
		
		//Union find를 사용하기 위해 parent 배열 선언
		//Union find: 각 노드의 부모노드를 기록한다. 이미 연결된 섬은 연결하지 않기 위한 체크 용도
		int[] parent = new int[n];
		for (int i=0; i<n; i++) {
			parent[i] = i; // 자기 자신으로 부모를 초기화
		}
		
		for (int[] info : costs) {
			int from = info[0];
			int to = info[1];
			int cost = info[2];
			
			int fromParent = findParent(parent, from);
			int toParent = findParent(parent, to);
			
			//부모노드가 같으면 이미 연결된 섬이므로 해당 간선을 연결하지 않는다.
			if (fromParent == toParent) {
				continue;
			}
			
			total += cost;
			parent[toParent] = fromParent; //간선을 연결하였으므로 두 부모노드를 같은 부모노드를 갖게 갱신한다.
		}
		return total;
    }

	//부모 노드(=부모노드가 자기 자신과 같은 노드) 찾기
	private static int findParent(int[] parent, int node) {
		if (parent[node] == node) return node;
		return findParent(parent, parent[node]);
	}
}
