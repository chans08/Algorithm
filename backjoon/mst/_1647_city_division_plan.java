package mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ** return parent[node] = getParent(parent[node], parent);
 * 위에서 parent[node] =  부분이 없으면 시간초과 뜸..
 * 341200KB	2564ms
 * @author CMN
 * @date 2022-04-11
 */
public class _1647_city_division_plan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = 0;
		// 주어진 자료 손질하기
		String[] input = br.readLine().split(" ");
		int homeCnt = Integer.parseInt(input[0]);
		int roadCnt = Integer.parseInt(input[1]);
		int[][] roadInfo = new int[roadCnt][3];
		StringTokenizer st;
		for (int i=0; i<roadCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			roadInfo[i][0] = Integer.parseInt(st.nextToken());
			roadInfo[i][1] = Integer.parseInt(st.nextToken());
			roadInfo[i][2] = Integer.parseInt(st.nextToken());
		}
		// roadInfo 경비 오름차순으로 정렬
		Arrays.sort(roadInfo, (info1, info2) -> info1[2] - info2[2]);
		
		// 부모노드 초기화하기
		int[] parent = new int[homeCnt+1];
		for (int i=1; i<=homeCnt; i++) {
			parent[i] = i;
		}
		int cnt = 0;
		// 크루스칼 알고리즘을 통해 작은 경비부터 tree 만들기
		for (int i=0; i<roadInfo.length; i++) {
			if (cnt == homeCnt-2) {
				break;
			}
			int parentA = findParent(roadInfo[i][0], parent);
			int parentB = findParent(roadInfo[i][1], parent);
			if (parentA == parentB) {
				continue;
			}
			parent[parentB] = parentA;
			total += roadInfo[i][2];
			cnt++;
		}
		bw.write(String.valueOf(total));
		bw.flush();
		br.close();
		bw.close();
	}

	private static int findParent(int node, int[] parent) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = findParent(parent[node], parent);
	}
}
