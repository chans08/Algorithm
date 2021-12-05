package kakao._2021_blind_recruitment;

import java.util.ArrayList;
import java.util.List;

public class _2_ref_combination {
	public static void main(String[] args) {
		/**
		 * 
		 * arr: 조합을 뽑아낼 배열
		 * output: 조합으로 뽕은 배열
		 * n: 전체 원소개수
		 * r: 조합의 크기
		 */
		int[][] arrs = {{1, 2}, {1, 3}, {2, 3}};
		for (int[] arr : arrs) {
			boolean[] visited = new boolean[arr.length];
			int n = arr.length;
			int r = 1;
			List<String> outputs = new ArrayList<>(); 
			combination(arr, visited, outputs, 0, n, r);
			System.out.println("outputs: " + outputs);
		}
	}
	
	private static void combination(int[] arr, boolean[] visited, List<String> outputs, int start, int n, int r) {
		String result;
		if (r == 0) {
			result = getResult(arr, visited);
			outputs.add(result);
			return;
		}
		
		for (int i=start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, outputs, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	private static String getResult(int[] arr, boolean[] visited) {
		String result = "";
		for (int i=0; i<arr.length; i++) {
			if (visited[i]) {
				result += arr[i];
			}
		}
		return result;
	}
}
