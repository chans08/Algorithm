package step._25.shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue를 사용한 다익스트라알고리즘 구현
 * @다익스트라 알고리즘 참고4(if (!v[j]).. 이부분을 이렇게 구현하는 것보다 앞에 두고 체크해서 continue 시키는게 조금 더 빠름): https://m.blog.naver.com/PostView.naver?blogId=ndb796&logNo=221234424646&referrerCode=0&searchKeyword=%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC
 * @author CMN
 * @date 2022-02-02
 */
public class ref_dijkstra {
	private static int INF = 100;//Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] graph = {
				{0, 2, 5, 1, INF, INF},
				{2, 0, 3, 2, INF, INF},
				{5, 3, 0, 3, 1, 5},
				{1, 2, 3, 0, 1, INF},
				{INF, INF, 1, 1, 0, 2},
				{INF, INF, 5, INF, 2, 0}
		};
		//0. 다익스트라알고리즘을 위한 데이터 초기화
		int[] dist = new int[graph.length]; //얻고자 하는 해당 노드까지의 최소 거리 배열
		Arrays.fill(dist, INF);
		dist[0] = 0; //시작 노드에 대한 최소 거리는 0!
		boolean[] isChecked = new boolean[graph.length]; //최소 거리에 대한 체크를 한 노드인지에 대한 배열
		dijkstra(graph, 0, isChecked, dist);
		System.out.println(Arrays.toString(dist));
		//[0, 2, 3, 1, 2, 4]
	}
	private static void dijkstra(int[][] graph, int start, boolean[] isChecked, int[] dist) {
		//1. 시작 node를 PriorityQueue에 담는다.
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		//2. queue가 빌때까지(모든 노드를 방문할 때까지) 가장 최소의 weight를 가진 인접노드를 꺼내어 dist를 갱신한다.
		while (!queue.isEmpty()) {
			Node currNode = queue.poll();
			if (isChecked[currNode.idx]) {
				continue;
			}
			isChecked[currNode.idx] = true; //***check하는 위치는 현재 노드를 꺼내서 2-1 조사를 하는 그 노드를 조사했다는 표시를 한다!
			//2-1. 인접 노드들을 조사하며 dist를 갱신한다.
			for (int j=0; j<graph.length; j++) {
				//아래에서 dist[currNode.idx] == currNode.weight 이다.
				if (dist[j] > dist[currNode.idx] + graph[currNode.idx][j]) {
					dist[j] = currNode.weight + graph[currNode.idx][j];
					queue.offer(new Node(j, dist[j]));
				}
			}
		}
	}
}
