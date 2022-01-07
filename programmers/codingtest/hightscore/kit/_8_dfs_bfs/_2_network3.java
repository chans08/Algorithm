package codingtest.hightscore.kit._8_dfs_bfs;

/**
 * @참고: https://velog.io/@ming/DFS-vs-BFS-%ED%83%90%EC%83%89
 * - dfs(depth first search): 깊이(자식노드)를 우선적으로 탐색하는 방법
 * -> 백트래킹(backtracking): 한 노드에서 제일 마지막 자식까지 탐색하고 돌아오는 과정
 * -> stack, recursion(간결) 이용
 * - bfs(breadth first search): 너비(인접노드)를 우선적으로 탐색하는 방법
 * -> queue 이용
 * * 속도: dfs < bfs(good) -> dfs는 모든 노드를 방문하므로  
 * 
테스트 1 〉	통과 (0.02ms, 75.9MB)
테스트 2 〉	통과 (0.03ms, 72.7MB)
테스트 3 〉	통과 (0.06ms, 72.5MB)
테스트 4 〉	통과 (0.03ms, 77MB)
테스트 5 〉	통과 (0.02ms, 78.8MB)
테스트 6 〉	통과 (0.10ms, 71.2MB)
테스트 7 〉	통과 (0.02ms, 77.6MB)
테스트 8 〉	통과 (0.06ms, 73.1MB)
테스트 9 〉	통과 (0.04ms, 67.1MB)
테스트 10 〉	통과 (0.06ms, 78.6MB)
테스트 11 〉	통과 (0.16ms, 74.9MB)
테스트 12 〉	통과 (0.14ms, 78.9MB)
테스트 13 〉	통과 (0.14ms, 76.6MB)
 * @author CMN
 *
 */
public class _2_network3 {
	public static void main(String[] args) {
		//int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		//int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		//int[][] computers = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}; //3
		//int[][] computers = {{1, 0, 0}, {0, 1, 1}, {0, 1, 0}};
		//int[][] computers = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
//		int[][] computers = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 1}};
//		int[][] computers = {{1}};
//		int[][] computers = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 1}, {0, 0, 1, 1}};
//		int[][] computers = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
		int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
		int n = computers.length;
		int answer = solution(n, computers);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * n개의 노드가 있으므로 방문은 n개만 체크하면 된다.
	 * @param n
	 * @param computers
	 * @return
	 */
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
        //1. 노드를 순차적으로 따로 떨어져 있을 때마다 센다.
        for (int i=0; i<n; i++) {
        	//2. 시작 노드로부터 연결된 노드를 모두 방문체크한다.
        	if (!visited[i]) {
        		dfsR(n, computers, i, visited);
        		//3. 방문 체크가 모두 끝나면 한 덩이를 올려준다.
        		answer++;
        	}
        }
        return answer;
    }

	private static void dfsR(int n, int[][] computers, int start, boolean[] visited) {
		visited[start] = true;
		for (int i=0; i<n; i++) {
			if (!visited[i] && computers[start][i] == 1) {
				dfsR(n, computers, i, visited);
			}
		}
	}
}
