package monthly.codechallenge.season1;

import java.util.ArrayList;
import java.util.List;
/**
 * 정확성  테스트
테스트 1 〉	통과 (0.10ms, 78.2MB)
테스트 2 〉	통과 (0.08ms, 75.1MB)
테스트 3 〉	통과 (14.55ms, 165MB)
테스트 4 〉	통과 (132.60ms, 214MB)
테스트 5 〉	통과 (194.89ms, 219MB)
테스트 6 〉	통과 (20.00ms, 147MB)
테스트 7 〉	통과 (1454.86ms, 218MB)
테스트 8 〉	통과 (1040.05ms, 212MB)
테스트 9 〉	통과 (15.80ms, 172MB)
테스트 10 〉	통과 (143.71ms, 207MB)
테스트 11 〉	통과 (153.03ms, 210MB)
테스트 12 〉	통과 (14.53ms, 156MB)
테스트 13 〉	통과 (118.50ms, 185MB)
테스트 14 〉	통과 (110.58ms, 229MB)
테스트 15 〉	통과 (14.39ms, 161MB)
테스트 16 〉	통과 (216.45ms, 236MB)
테스트 17 〉	통과 (135.55ms, 215MB)
테스트 18 〉	통과 (70.72ms, 229MB)
 * 
 * 풀이2를 보고 개선.. -> 결국 for문을 합치는걸로는 해결이 안되었고,
 * dfs 할 때 
 * a[startIdx] += a[idx];
 * 이 계산을 dfs 결과값에서 더하는걸로 최대한 dfs 후 코드를 줄여보아야 겠다..
 * (xx)
 * dfs 식이 동일해도 7,8 런타임이 나서 초기 자료구조 static으로 변경해줌...
 * (xx)
 * 
 * *** 세상에나...
 * for (int idx : list) 보다 for (int i=0; i<list.size; i++) 가 더 빨라서 runtime 에러가 해결됨..
 * 그치만 이것만으로는 안되는군... 하...
 * 
 * @author CMN
 * @date 2022-03-08
 */
public class _1_make_all_zero3 {
	public static void main(String[] args) {
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0,1},{3,4},{2,3},{0,3}}; //9
//		int[] a = {-2, 8, -5, -5, -3, 0, 5, 2};
//		int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}}; //17
		long answer = solution(a, edges);
		System.out.println("answer: " + answer);
	}
	
	static boolean[] isVisited;
	static long answer;
	static long[] aLongType;
	static List<Integer>[] adjListArray;
	
	/**
	 * root를 잡고 dfs로 트리를 돌면 된다..
	 * @param a 트리의 가중치 배열
	 * @param edges 간선정보
	 * @return 가중치를 모두 0으로 만드는 행동의 횟수
	 */
	public static long solution(int[] a, int[][] edges) {
        //1. 행동 판단이 바로 되는 조건들에 대하여 리턴한다.
        //1-1. a의 총 합이 0이 아니면 -1을 리턴한다.
  		long sum = 0;
        //2. edges가 단방향으로 표현되어 있기 때문에 adjListArray 로 초기정보를 다시 기록한다.
        adjListArray = new ArrayList[a.length];
        //2-1. a에 덧뺄셈이 들어가므로 long 타입으로 변환한다.
        aLongType = new long[a.length];
        for (int i=0; i<a.length; i++) {
        	adjListArray[i] = new ArrayList<>();
        	sum += a[i];
			aLongType[i] = a[i];
        }
        if (sum != 0) {
			return -1;
		}
        for (int i=0; i<edges.length; i++) {
        	adjListArray[edges[i][0]].add(edges[i][1]);
        	adjListArray[edges[i][1]].add(edges[i][0]);
        }
        //3. 부모 노드로 돌아오면서 가중치를 증감 계산 해준다!!!
        isVisited = new boolean[a.length];
        
        dfs(0);
        return answer;
    }
	
	private static long dfs(int startIdx) {
		isVisited[startIdx] = true;
		for (int i=0; i<adjListArray[startIdx].size(); i++) {
			int idx = adjListArray[startIdx].get(i);
			if (!isVisited[idx]) {
				aLongType[startIdx] += dfs(idx);
			}
		}
		answer += Math.abs(aLongType[startIdx]);
		return aLongType[startIdx];
	}
}
