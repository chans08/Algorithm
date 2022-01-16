package step._24.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * 14448	128
 * @author CMN
 *
 */
public class _2_2606_virus {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerCnt = Integer.parseInt(br.readLine());
		int edgeCnt = Integer.parseInt(br.readLine());
		//1. 컴퓨터의 연결을 표현하는 인접행렬 초기화하기(컴퓨터1 = 0, 컴퓨터2 = 1, ...)
		int[][] adjacentMatrix = new int[computerCnt][computerCnt];
		boolean[] isVisited = new boolean[computerCnt];
		for (int i=0; i<edgeCnt; i++) {
			int[] temp = Stream.of(br.readLine().split(" "))
								.mapToInt(Integer::parseInt)
								.toArray();
			adjacentMatrix[temp[0]-1][temp[1]-1] = 1;
			adjacentMatrix[temp[1]-1][temp[0]-1] = 1;
		}
		
		//2. 1번 컴퓨터부처 출발하여 연결된 컴퓨터 개수 세기
		isVisited[0] = true; //1번 컴퓨터 방문 체크하기
		int start = 0;
		int[] connectedComputerCnt = new int[1];
		dfsR(adjacentMatrix, isVisited, computerCnt, start, connectedComputerCnt);
		System.out.println(connectedComputerCnt[0]);
	}

	private static void dfsR(int[][] adjacentMatrix, boolean[] isVisited, int computerCnt, int start, int[] connectedComputerCnt) {
		for (int i=0; i<computerCnt; i++) {
			if (!isVisited[i] && adjacentMatrix[start][i] == 1) {
				isVisited[i] = true;
				connectedComputerCnt[0]++;
				dfsR(adjacentMatrix, isVisited, computerCnt, i, connectedComputerCnt);
			}
		}
	}
}
