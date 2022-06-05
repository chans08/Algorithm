package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 24256KB	328ms
 */
public class _1260_dfs_bfs {
	static int[][] graph;
	static int vCnt;
	static int eCnt;
	static int start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vCnt = Integer.parseInt(st.nextToken());
		eCnt = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		//1. graph 선언
		graph = new int[vCnt+1][vCnt+1];
		for (int i=0; i<eCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		//2. dfs 출력
		System.out.println(dfs());
		//3. bfs 출력
		System.out.println(bfs());
	}
	
	public static String dfs() {
		StringBuffer sb = new StringBuffer();
		boolean[] visited = new boolean[vCnt+1];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			int v = stack.pop();
			if (visited[v]) {
				continue;
			}
			visited[v] = true;
			sb.append(v + " ");
			for (int i=vCnt; i>=1; i--) {
				if (!visited[i] && graph[v][i] == 1) {
					stack.push(i);
				}
			}
		}
		return sb.toString();
	}
	
	public static String bfs() {
		StringBuffer sb = new StringBuffer();
		boolean[] visited = new boolean[vCnt+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			sb.append(v + " ");
			for (int i=1; i<=vCnt; i++) {
				if (!visited[i] && graph[v][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		return sb.toString();
	}
}
