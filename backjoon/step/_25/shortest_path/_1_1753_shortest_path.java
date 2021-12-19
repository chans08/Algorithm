package step._25.shortest_path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @참고1: https://subbak2.tistory.com/55
 * @참고2: https://dragon-h.tistory.com/20
 * @참고3: https://squareyun.tistory.com/20
 * @author CMN
 *
 */
public class _1_1753_shortest_path {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = Integer.MAX_VALUE;
	private static int V, E, K; //V: 정점의 개수, E: 간선의 개수, K: 시작 정점의 번호
	private static List<Node>[] adjList; //특정 시작 지점을 뜻하는 idx 에서 갈 수 있는 node idx 와 가중치에 관한 Node list 에 대한 배열
	private static int[] dist; //시작 정점에서 모든 노드로의 최소 거리 비용에 대한 배열
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]); //정점의 개수
		E = Integer.parseInt(input[1]); //간선의 개수
		K = Integer.parseInt(br.readLine()); //시작 정점
		dist = new int[V+1];
		//1. 인접리스트 초기화
		adjList = new ArrayList[V+1];
		for (int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		//2. 거리배열 무한대로 초기화
		Arrays.fill(dist, INF);
		
		//3. 방향간선 인접리스트 입력(주어진 조건 입력)
		for (int i=0; i<E; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			adjList[u].add(new Node(v, w));
		}
		
		//4. 출발지부터 다익스트라 진행
		dijkstra(K);
		
		//5. 전체 출력
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dijkstra(int start) {
		//1. 출발지 비용은 0으로 하고 출발지를 PQ에 넣고 시작
		Queue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node currNode = pq.poll();
			
			//2. 더 큰 가중치로 도착한 경우 패스
			if (currNode.weight > dist[currNode.end]) continue;
			
			//3. 현재 위치에 연결된 간선 탐색
			for (int i=0; i<adjList[currNode.end].size(); i++) {
				Node nextNode = adjList[currNode.end].get(i);
				
				//4. cost 가 더 작을 때에만 갱신하고 PQ에 넣기
				if (dist[nextNode.end] > currNode.weight + nextNode.weight) {
					dist[nextNode.end] = currNode.weight + nextNode.weight;
					pq.add(new Node(nextNode.end, dist[nextNode.end]));
				}
			}
			
		}
	}
}

/**
 * end: 갈 수 있는 노드
 * weight: end 로 가는데 드는 비용
 * @author CMN
 *
 */
class Node implements Comparable<Node> {
	int end, weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}