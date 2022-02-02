package step._25.shortest_path;

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