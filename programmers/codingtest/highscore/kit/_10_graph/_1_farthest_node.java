package codingtest.highscore.kit._10_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.41ms, 73.8MB)
테스트 2 〉	통과 (0.74ms, 76.8MB)
테스트 3 〉	통과 (0.52ms, 71MB)
테스트 4 〉	통과 (1.57ms, 70.8MB)
테스트 5 〉	통과 (3.31ms, 77.1MB)
테스트 6 〉	통과 (5.36ms, 84.2MB)
테스트 7 〉	통과 (28.06ms, 102MB)
테스트 8 〉	통과 (40.24ms, 103MB)
테스트 9 〉	통과 (42.37ms, 113MB)
 * @author CMN
 * @date 2022-05-28
 */
public class _1_farthest_node {
	private static Map<Integer, Node> graph = new HashMap<>();
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int answer = solution(n, edge);
		System.out.println("answer: " + answer);
	}
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        //1. 그래프 그리기
        for (int i=1; i<=n; i++) {
        	graph.put(i, new Node(i));
        }
        
        for (int i=0; i<edge.length; i++) {
        	graph.get(edge[i][0]).addAdjNode(graph.get(edge[i][1]));
        	graph.get(edge[i][1]).addAdjNode(graph.get(edge[i][0]));
        }
        
        //2. 가장 먼 노드 찾기
        int[] dist = new int[n+1]; // i 노드=인덱스로 거리를 담는다.
        int edgeCnt = 1;
        int sameDepthNodeCnt = 0; 
        Queue<Node> distQueue = new LinkedList<>();
        for (Node node: graph.get(1).adjNodes) {
        	dist[node.index] = edgeCnt;
        	distQueue.offer(node);
        	sameDepthNodeCnt++;
        }
        
        edgeCnt = 2;
        int nextSameDepthNodeCnt = 0;
        answer = sameDepthNodeCnt;
        while (!distQueue.isEmpty()) {
        	if (sameDepthNodeCnt == 0) {
        		edgeCnt++;
        		sameDepthNodeCnt = nextSameDepthNodeCnt;
        		nextSameDepthNodeCnt = 0;
        		answer = sameDepthNodeCnt;
        	}
        	Node curr = distQueue.poll();
        	sameDepthNodeCnt--;
        	for (Node adjNode: curr.adjNodes) {
        		if (adjNode.index != 1 && dist[adjNode.index] == 0) { // 1이 아닌 방문하지 않은 노드에서 거리 체크한다.
        			dist[adjNode.index] = edgeCnt;
        			distQueue.offer(adjNode);
        			nextSameDepthNodeCnt++;
        		}
        	}
        }
        
//        System.out.println("edgeCnt: " + edgeCnt);
//        System.out.println("sameDepthNodeCnt: " + sameDepthNodeCnt);
        return answer;
    }
	
	private static class Node {
		public int index;
		public List<Node> adjNodes = new ArrayList<>();
		
		public Node(int index) {
			this.index = index;
		}
		
		public void addAdjNode(Node adjNode) {
			adjNodes.add(adjNode);
		}
		
		@Override
		public String toString() {
			return String.format("%d: %s", index, adjNodes.parallelStream().mapToInt(e -> e.index).boxed().collect(Collectors.toList()));
		}
	}
}
