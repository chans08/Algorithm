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
 * 132956KB	876ms
 * @참고1: https://subbak2.tistory.com/55
 * @참고2: https://dragon-h.tistory.com/20
 * @다익스트라 알고리즘이란 참고3: https://squareyun.tistory.com/20
 * @다익스트라 알고리즘 참고4: https://m.blog.naver.com/PostView.naver?blogId=ndb796&logNo=221234424646&referrerCode=0&searchKeyword=%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC
 * [다익스트라 알고리즘(Dijkstra algorithm)]
1. 출발 노드를 설정
2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장
3. 방문한 노드를 제외한 가장 비용이 적은 노드 선택 -> 중요!!!
4. 해당 노드를 거쳐가는 모든 노드의 최소 비용을 고려하여 최소 비용을 갱신
5. 3~4번 반복
이때 추가로
- 이미 체크한 노드는 다시 체크 안해도 된다!
- 첫노드와 마지막 노드는 3, 4번 과정을 거치지 않아도 된다???

//주의!! \r\n 하면 출력 형식이 틀렸습니다. 오류남..
 * //주의!!: queue에 node를 넣을 때 node의  weight를 dist로 넣어줘야..(뜻에는 안맞지만) compare를 최소 dist로 제대로 해온다..!!!
 * @author CMN
 *
 */
public class _1_1753_shortest_path4 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = 100_000_000; //(1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000, 1<= W <= 10)
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int vCnt = Integer.parseInt(input[0]);
		int eCnt = Integer.parseInt(input[1]);
		int start = Integer.parseInt(br.readLine())-1;
		//1. 인접 리스트 초기화
		//정점번호는 0부터 시작하도록 함
		List<Node>[] adjList = new ArrayList[vCnt];
		for (int i=0; i<vCnt; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i=0; i<eCnt; i++) {
			input = br.readLine().split(" ");
			adjList[Integer.parseInt(input[0])-1].add(new Node(Integer.parseInt(input[1])-1, Integer.parseInt(input[2])));
		}
		//2. 다익스트라 알고리즘으로 dist 구하기
		//2-1. 필요한 자료 구조(dist, isChecked)들 세팅
		int[] dist = new int[vCnt];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean[] isChecked = new boolean[vCnt];
		//2-2. 다익스트라 알고리즘 돌리기
		dijkstra(adjList, start, isChecked, dist);
		//System.out.println("dist: " + Arrays.toString(dist));
		//3. 답안 출력
		for (int i=0; i<dist.length; i++) {
			bw.append(String.valueOf(dist[i] == INF ? "INF" : dist[i]));
			bw.append("\n"); //주의!! \r\n 하면 출력 형식이 틀렸습니다. 오류남..
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static void dijkstra(List<Node>[] adjList, int start, boolean[] isChecked, int[] dist) {
		//2-2-1. 필요한 자료 구조(PriorityQueue)를 세팅 및 start 노드 담기
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		//2-2-2. 인접노드를 조사하며 dist 갱신하기
		while (!queue.isEmpty()) {
			//2-2-2-1. queue에서 최단거리 노드 꺼내며 조사했다는 체크 미리하기
			Node currNode = queue.poll();
			if (isChecked[currNode.idx]) {
				continue;
			}
			isChecked[currNode.idx] = true;
			//2-2-2-2. 조사한적 없는 인접노드를 돌면서 dist 갱신하기
			for (Node adjNode : adjList[currNode.idx]) {
				if (dist[adjNode.idx] > dist[currNode.idx] + adjNode.weight) {
					dist[adjNode.idx] = dist[currNode.idx] + adjNode.weight;
					queue.offer(new Node(adjNode.idx, dist[adjNode.idx])); //주의!!: queue에 넣는 node의 weight를 dist로 넣어줘야..(뜻에는 안맞지만) compare를 최소 dist로 제대로 해온다..!!!
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
	int idx, weight;
	
	public Node(int idx, int weight) {
		this.idx = idx;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}