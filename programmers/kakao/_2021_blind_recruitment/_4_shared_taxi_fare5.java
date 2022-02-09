package kakao._2021_blind_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.56ms, 77.4MB)
 * 테스트 2 〉	통과 (0.52ms, 73.7MB)
 * 테스트 3 〉	통과 (0.65ms, 73.6MB)
 * 테스트 4 〉	통과 (0.92ms, 76.5MB)
 * 테스트 5 〉	통과 (0.87ms, 76.3MB)
 * 테스트 6 〉	통과 (0.91ms, 78.9MB)
 * 테스트 7 〉	통과 (0.90ms, 75.6MB)
 * 테스트 8 〉	통과 (1.20ms, 79.2MB)
 * 테스트 9 〉	통과 (0.73ms, 77.9MB)
 * 테스트 10 〉	통과 (0.87ms, 77.8MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (5.59ms, 52.3MB)
 * 테스트 2 〉	통과 (19.09ms, 58.2MB)
 * 테스트 3 〉	통과 (5.54ms, 53.9MB)
 * 테스트 4 〉	통과 (4.44ms, 52.3MB)
 * 테스트 5 〉	통과 (6.77ms, 52.5MB)
 * 테스트 6 〉	통과 (4.09ms, 52.4MB)
 * 테스트 7 〉	통과 (59.88ms, 64.4MB)
 * 테스트 8 〉	통과 (46.58ms, 66.8MB)
 * 테스트 9 〉	통과 (20.33ms, 64.6MB)
 * 테스트 10 〉	통과 (24.41ms, 66.3MB)
 * 테스트 11 〉	통과 (34.07ms, 64.5MB)
 * 테스트 12 〉	통과 (29.31ms, 61.5MB)
 * 테스트 13 〉	통과 (23.22ms, 58.6MB)
 * 테스트 14 〉	통과 (32.06ms, 60.8MB)
 * 테스트 15 〉	통과 (31.02ms, 58.7MB)
 * 테스트 16 〉	통과 (3.30ms, 52.3MB)
 * 테스트 17 〉	통과 (2.92ms, 52.9MB)
 * 테스트 18 〉	통과 (3.54ms, 52.8MB)
 * 테스트 19 〉	통과 (7.43ms, 52.6MB)
 * 테스트 20 〉	통과 (11.03ms, 57MB)
 * 테스트 21 〉	통과 (12.04ms, 53.8MB)
 * 테스트 22 〉	통과 (24.93ms, 62.6MB)
 * 테스트 23 〉	통과 (25.14ms, 58.7MB)
 * 테스트 24 〉	통과 (32.57ms, 64.1MB)
 * 테스트 25 〉	통과 (2.46ms, 52.5MB)
 * 테스트 26 〉	통과 (2.37ms, 52.9MB)
 * 테스트 27 〉	통과 (10.69ms, 53.3MB)
 * 테스트 28 〉	통과 (8.88ms, 54.1MB)
 * 테스트 29 〉	통과 (3.29ms, 52.5MB)
 * 테스트 30 〉	통과 (2.55ms, 52.8MB)
 * @author chaal
 *
 */
public class _4_shared_taxi_fare5 {
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		/*
		int n = 2;
		int s = 1;
		int a = 2;
		int b = 2;
		int[][] fares = {{2, 1, 10}};
		*/
		int sharedFare = solution(n, s, a, b, fares);
		System.out.println("sharedFare: " + sharedFare);
	}

	private static int INF = 20000001; //요금 * 노드 개수 보다 커야 함!!!
	private static class Node implements Comparable<Node>{
		int idx, weight;
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	/**
	 * 다익스트라를 활용한 풀이
	 * @param n
	 * @param s
	 * @param a
	 * @param b
	 * @param fares
	 * @return
	 */
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = INF;
		//1. 인접리스트 초기화
		List<Node>[] adjListArray = new ArrayList[n+1];
		for (int i=0; i<adjListArray.length; i++) {
			adjListArray[i] = new ArrayList<>();
		}
		for (int i=0; i<fares.length; i++) {
			adjListArray[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
			adjListArray[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
		}
		
		//2. s, a, b에 다익스트라를 적용하여 각각의 dist 에 담기
		int[] distS = new int[n+1];
		int[] distA = new int[n+1];
		int[] distB = new int[n+1];
		Arrays.fill(distS, INF);
		Arrays.fill(distA, INF);
		Arrays.fill(distB, INF);
		dijkstra(adjListArray, s, distS);
		dijkstra(adjListArray, a, distA);
		dijkstra(adjListArray, b, distB);
//		System.out.println("distS: " + Arrays.toString(distS));
//		System.out.println("distA: " + Arrays.toString(distA));
//		System.out.println("distB: " + Arrays.toString(distB));
		
		//3. 합류 도착지점 i들에 대하여 최소값 비용 구하기
		for (int i=1; i<=n; i++) {
			if (answer > distS[i] + distA[i] + distB[i]) {
				answer = distS[i] + distA[i] + distB[i];
			}
		}
        return answer; 
    }
	private static void dijkstra(List<Node>[] adjListArray, int start, int[] dist) {
		dist[start] = 0;
		boolean[] isVisited = new boolean[dist.length];
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node currNode = queue.poll();
			isVisited[currNode.idx] = true;
			for (Node adjNode : adjListArray[currNode.idx]) {
				if (!isVisited[adjNode.idx] && dist[adjNode.idx] > dist[currNode.idx] + adjNode.weight) {
					dist[adjNode.idx] = dist[currNode.idx] + adjNode.weight;
					queue.offer(new Node(adjNode.idx, dist[adjNode.idx]));
				}
			}
		}
	}
}
