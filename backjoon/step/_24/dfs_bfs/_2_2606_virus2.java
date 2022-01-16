package step._24.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 14204	124
 * @author CMN
 *
 */
public class _2_2606_virus2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerCnt = Integer.parseInt(br.readLine());
		int edgeCnt = Integer.parseInt(br.readLine());
		HashSet<Integer>[] computerConnected = new HashSet[computerCnt+1];
		for (int i=1; i<=computerCnt; i++) {
			computerConnected[i] = new HashSet<>();
		}
		boolean[] isVisited = new boolean[computerCnt+1];
		//1. 컴퓨터의 연결을 표현하는 인접행렬 초기화하기
		for (int i=0; i<edgeCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			computerConnected[start].add(end);
			computerConnected[end].add(start);
		}
		//2. dfs로 네트워크 상의 컴퓨터 수 세기
		int start = 1;
		int[] computerConnectedCnt = new int[1];
		dfsR(computerConnected, isVisited, start, computerConnectedCnt);
		System.out.println(computerConnectedCnt[0]);
	}

	private static void dfsR(HashSet<Integer>[] computerConnected, boolean[] isVisited, int start,
			int[] computerConnectedCnt) {
		isVisited[start] = true;
		Set<Integer> connectedComputer = computerConnected[start];
		for (int next : connectedComputer) {
			if (!isVisited[next]) {
				computerConnectedCnt[0]++;
				dfsR(computerConnected, isVisited, next, computerConnectedCnt);
			}
		}
	}
}
