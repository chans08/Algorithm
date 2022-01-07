package codingtest.hightscore.kit._8_dfs_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * - bfs
 * 1. 시작 노드를 큐에 담으면서 방문체크 
 * 2. 큐에서 뽑아서 출력 -> 연관 노드를 큐에 담으면서 방문체크
 * 3. 큐가 빌때까지 2번을 반복
 * 
 * - dfs 
 * 1. 시작 노드를 스택에 담으면서  방문체크
 * 2. 스택에서 봅아서 출력 -> 연관 노드를 스택에 담으면서 방문체크
 * 3. 스택이 빌때까지 2번을 반복
 * @author CMN
 *
 */
/**
 *   0
 *  /
 * 1 -- 3    7
 * |  / | \ /
 * | /  |  5
 * 2 -- 4   \
 * 			 6 -- 8
 * @author CMN
 *
 */
public class _3_ref_bfs_dfs {
	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		//회귀는 프린트 순서를 보장하지 못한다.
		g.dfs(); //0 1 3 5 7 6 8 4 2 
		System.out.println();
		g.bfs(); //0 1 2 3 4 5 6 7 8
		System.out.println();
		//g.dfsR(); //0 1 2 3 4 5 6 8 7 
		System.out.println();
		g.dfs(3); //3 5 7 6 8 4 2 1 0
		System.out.println();
		g.bfs(3); //3 1 2 4 5 0 6 7 8 
		System.out.println();
		//g.dfsR(3); //3 1 0 2 4 5 6 8 7 
	}
}

class Graph {
	public Node[] nodes;
	
	public Graph(int size) {
		nodes = new Node[size];
		for (int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	public void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	public void dfs() {
		dfs(0);
	}
	
	public void dfs(int start) {
		for (Node n : nodes) {
			n.visited = false;
		}
		Node root = nodes[start];
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		root.visited = true;
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.printf(node.data + " ");
			List<Node> adjacentNodes = node.adjacent;
			for (Node adjacentNode : adjacentNodes) {
				if (!adjacentNode.visited) {
					stack.push(adjacentNode);
					//System.out.printf("[" + adjacentNode.data + "]");
					adjacentNode.visited = true;
				}
			}
		}
	}
	
	public void bfs() {
		bfs(0);
	}
	
	public void bfs(int start) {
		for (Node n : nodes) {
			n.visited = false;
		}
		Node root = nodes[start];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		root.visited = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.printf(node.data + " "); //0 1 3 5 7 6 8 4 2 0 
			for (Node adjacentNode : node.adjacent) {
				if (!adjacentNode.visited) {
					queue.offer(adjacentNode);
					adjacentNode.visited = true;
				}
			}
		}
	}
	
	public void dfsR() {
		dfsR(0);
	}
	
	public void dfsR(int start) {
		Node root = nodes[start];
		dfsR(root);
	}
	
	public void dfsR(Node start) {
		if (start == null) return;
		start.visited = true;
		System.out.printf(start.data + " ");
		for (Node adjacentNode : start.adjacent) {
			if (!adjacentNode.visited) {
				dfsR(adjacentNode);
			}
		}
	}
}

class Node {
	public int data;
	public LinkedList<Node> adjacent;
	public boolean visited;
	
	public Node(int data) {
		this.data = data;
		this.adjacent = new LinkedList<>();
		this.visited = false;
	}
}
