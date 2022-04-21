package mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 85548KB	980ms
 * @author CMN
 * @date 2022-04-04
 */
public class _1922_network_connection {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int computerCnt = Integer.parseInt(br.readLine());
		int edgeCnt = Integer.parseInt(br.readLine());
		int total = 0;
		// 1. find union을 사용해 같은 tree인지 판별.
		// 부모노드 선언 및 자기자신의 부모는 자기자신으로 초기화 
		int[] parent = new int[computerCnt+1];
		for (int i=1; i<=computerCnt; i++) {
			parent[i] = i;
		}
		int[][] edgeInfo = new int[edgeCnt][3];
		// 2. 초기데이터 담기 
		for (int i=0; i<edgeCnt; i++) {
			edgeInfo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// 2-1. kruskal 알고리즘 사용을 위해 비용 오름차순으로 정렬 
		Arrays.sort(edgeInfo, (info1, info2) -> info1[2] - info2[2]);
		// 크루스칼 알고리즘 적용
		for (int i=0; i<edgeCnt; i++) {
			int from = edgeInfo[i][0];
			int to = edgeInfo[i][1];
			int cost = edgeInfo[i][2];
			
			int fromParent = findParent(parent, from);
			int toParent = findParent(parent, to);
			
			if (fromParent == toParent) {
				continue;
			}
			
			total += cost;
			parent[toParent] = fromParent; 
		}
		bw.write(String.valueOf(total));
		bw.flush();
		br.close();
		bw.close();
	}

	private static int findParent(int[] parent, int node) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = findParent(parent, parent[node]); //부모 노드를 찾은 값으로 갱신함으로써 다음번에 찾을 때 빠르게 찾을 수 있다.
	}
}
