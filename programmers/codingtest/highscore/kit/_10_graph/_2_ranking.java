package codingtest.highscore.kit._10_graph;

import java.util.HashSet;
import java.util.Set;

/**
정확성  테스트
테스트 1 〉	통과 (0.03ms, 78.5MB)
테스트 2 〉	통과 (0.03ms, 75.8MB)
테스트 3 〉	통과 (0.06ms, 75MB)
테스트 4 〉	통과 (0.30ms, 77.9MB)
테스트 5 〉	통과 (0.91ms, 73.8MB)
테스트 6 〉	통과 (3.30ms, 87.9MB)
테스트 7 〉	통과 (8.09ms, 75MB)
테스트 8 〉	통과 (10.19ms, 77.4MB)
테스트 9 〉	통과 (9.78ms, 78.1MB)
테스트 10 〉	통과 (10.84ms, 82.8MB)
 * @author CMN
 * @date 2022-05-29
 */
public class _2_ranking {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int answer = solution(n, results);
		System.out.println("answer: " + answer);
	}
	
	/**
선수의 수는 1명 이상 100명 이하입니다.
경기 결과는 1개 이상 4,500개 이하입니다.
	 * @param n
	 * @param results [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
	 * @return
	 */
	public static int solution(int n, int[][] results) {
        int answer = 0;
        //1. 그래프 그리기
        int[][] floyd = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
        	for (int j=1; j<=n; j++) {
        		floyd[i][j] = 10000;
        	}
        }
        
        for (int i=0; i<results.length; i++) {
        	int x = results[i][0];
        	int y = results[i][1];
        	floyd[x][y] = 1;
        }
        
        //2. 최소거리 구하기
        // 거쳐가는 정점
        for (int i=1; i<=n; i++) {
        	// 시작 정점
        	for (int j=1; j<=n; j++) {
        		// 끝 정점
        		for (int k=1; k<=n; k++) {
        			if (floyd[j][k] > floyd[j][i] + floyd[i][k]) {
        				floyd[j][k] = floyd[j][i] + floyd[i][k];
        			}
        		}
        	}
        }
        
        //3. 순위 개수 구하기
        for (int i=1; i<=n; i++) {
        	int count = 0;
        	for (int j=1; j<=n; j++) {
        		if (floyd[i][j] < 10000 || floyd[j][i] < 10000) {
        			count++;
        		}
        	}
        	if (count == n-1)
        		answer++;
        }
        return answer;
    }
}

