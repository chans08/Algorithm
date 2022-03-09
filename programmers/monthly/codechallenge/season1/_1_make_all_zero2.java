package monthly.codechallenge.season1;

import java.util.ArrayList;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.09ms, 87.2MB)
테스트 2 〉	통과 (0.08ms, 76.1MB)
테스트 3 〉	통과 (12.26ms, 164MB)
테스트 4 〉	통과 (155.94ms, 223MB)
테스트 5 〉	통과 (148.03ms, 207MB)
테스트 6 〉	통과 (11.12ms, 156MB)
테스트 7 〉	통과 (1396.98ms, 221MB)
테스트 8 〉	통과 (1106.55ms, 243MB)
테스트 9 〉	통과 (12.06ms, 157MB)
테스트 10 〉	통과 (141.76ms, 213MB)
테스트 11 〉	통과 (146.30ms, 203MB)
테스트 12 〉	통과 (13.22ms, 165MB)
테스트 13 〉	통과 (109.91ms, 172MB)
테스트 14 〉	통과 (115.70ms, 179MB)
테스트 15 〉	통과 (11.71ms, 162MB)
테스트 16 〉	통과 (158.44ms, 175MB)
테스트 17 〉	통과 (132.50ms, 212MB)
테스트 18 〉	통과 (51.10ms, 219MB)
 * @author CMN
 * @date 2022-03-08
 */
public class _1_make_all_zero2 {
	public static void main(String[] args) {
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0,1},{3,4},{2,3},{0,3}}; //9
//		int[] a = {-2, 8, -5, -5, -3, 0, 5, 2};
//		int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}}; //17
		long answer = solution(a, edges);
		System.out.println("answer: " + answer);
	}
	

    static long answer;
    static boolean[] visited;
    static long[] long_a;
    static ArrayList<Integer>[] children;

    public static long solution(int[] a, int[][] edges) {
        answer = 0;
        visited = new boolean[a.length];
        children = new ArrayList[a.length];
        long_a = new long[a.length];

        long sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            children[i] = new ArrayList<>();
            long_a[i] = a[i];
        }

        if(sum != 0) return -1;

        for(int i = 0 ; i < edges.length; i++){
            children[edges[i][0]].add(edges[i][1]);
            children[edges[i][1]].add(edges[i][0]);
        }

        dfs(0);

        return answer;
    }

    public static long dfs(int v){
        visited[v] = true;
        
        for(int i = 0; i < children[v].size(); i++){
            int next = children[v].get(i);
            if(!visited[next]){
                long_a[v] += dfs(next);
            }
        }

        answer += Math.abs(long_a[v]);

        return long_a[v];
    }
}
