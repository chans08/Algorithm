package monthly.codechallenge.season1;

import java.util.ArrayList;
import java.util.List;

/**
 * ***** weight 자료형 long이여야 한다!!(test 4,5,10,13,14,16,18)
 * ***** a 또한 덧뺄셈이 들어가므로 자료형이 long[] 이여야 한다!! (test 11,17)
 * **** test 7,8 의 경우 재귀함수로 풀어서 재귀가 깊어짐에 따라 stackoverflow가 발생할 수 있어서 비정상 종료됐을 수도..
 * @참고(재귀함수 성능): https://velog.io/@bosl95/%EB%B0%98%EB%B3%B5%EB%AC%B8%EA%B3%BC-%EC%9E%AC%EA%B7%80%ED%95%A8%EC%88%98
 * ** @참고2(공식 문제 해설): https://prgms.tistory.com/47?category=882795
 * 정확성  테스트
테스트 1 〉	통과 (0.07ms, 78.1MB)
테스트 2 〉	통과 (0.11ms, 77.5MB)
테스트 3 〉	통과 (3.40ms, 154MB)
테스트 4 〉	통과 (145.84ms, 217MB)
테스트 5 〉	통과 (151.13ms, 213MB)
테스트 6 〉	통과 (3.56ms, 157MB)
테스트 7 〉	실패 (런타임 에러)
테스트 8 〉	실패 (런타임 에러)
테스트 9 〉	통과 (3.40ms, 159MB)
테스트 10 〉	통과 (126.69ms, 209MB)
테스트 11 〉	통과 (133.29ms, 231MB)
테스트 12 〉	통과 (3.39ms, 156MB)
테스트 13 〉	통과 (146.61ms, 233MB)
테스트 14 〉	통과 (145.26ms, 222MB)
테스트 15 〉	통과 (3.68ms, 158MB)
테스트 16 〉	통과 (213.22ms, 221MB)
테스트 17 〉	통과 (165.65ms, 193MB)
테스트 18 〉	통과 (86.71ms, 233MB)
 * @author CMN
 * @date 2022-03-07
 */
public class _1_make_all_zero {
	public static void main(String[] args) {
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0,1},{3,4},{2,3},{0,3}}; //9
//		int[] a = {-2, 8, -5, -5, -3, 0, 5, 2};
//		int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}}; //17
		long answer = solution(a, edges);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * root를 잡고 dfs로 트리를 돌면 된다..
	 * @param a 트리의 가중치 배열
	 * @param edges 간선정보
	 * @return 가중치를 모두 0으로 만드는 행동의 횟수
	 */
	public static long solution(int[] a, int[][] edges) {
        long answer = -2;
        //1. 행동 판단이 바로 되는 조건들에 대하여 리턴한다.
        answer = isJudged(a);
        if (answer != -2) {
        	return answer;
        }
        //2. edges가 단방향으로 표현되어 있기 때문에 adjListArray 로 초기정보를 다시 기록한다.
        List<Integer>[] adjListArray = new ArrayList[a.length];
        for (int i=0; i<a.length; i++) {
        	adjListArray[i] = new ArrayList<>();
        }
        for (int i=0; i<edges.length; i++) {
        	adjListArray[edges[i][0]].add(edges[i][1]);
        	adjListArray[edges[i][1]].add(edges[i][0]);
        }
        //3. 부모 노드로 돌아오면서 가중치를 증감 계산 해준다!!!
        boolean[] isVisited = new boolean[a.length];
        isVisited[0] = true;
        long[] answerArray = new long[1];
        //3-1. a에 덧뺄셈이 들어가므로 long 타입으로 변환한다.
        long[] aLongType = new long[a.length];
        for (int i=0; i<a.length; i++) {
        	aLongType[i] = (long)a[i];
        }
        dfs(0, isVisited, answerArray, aLongType, adjListArray);
        return answerArray[0];
    }
	
	private static void dfs(int startIdx, 
							boolean[] isVisited, 
							long[] answerArray,
							long[] a,
							List<Integer>[] adjListArray) {
		for (int idx : adjListArray[startIdx]) {
			if (!isVisited[idx]) {
				isVisited[idx] = true;
				dfs(idx, isVisited, answerArray, a, adjListArray);
				answerArray[0] += Math.abs(a[idx]);
				a[startIdx] += a[idx];
				//a[idx] = 0;
			}
		}
	}
	
	/**
	 * //1. 행동 판단이 바로 되는 조건들에 대하여 리턴한다.
	 * @param a
	 * @return 행동 판단이 바로 되면 행동판단 횟수 또는 원하는 결과값, 
	 * 			그렇지 않은 경우 -2
	 */
	private static int isJudged(int[] a) {
		//1-1. a의 총 합이 0이 아니면 -1을 리턴한다.
		long sum = 0;
		//1-2. a의 모든 가중치가 0이면 0을 리턴한다.
		boolean isAllZero = true;
		for (int i=0; i<a.length; i++) {
			sum += a[i];
			isAllZero &= (a[i] == 0);
		}
		if (sum != 0) {
			return -1;
		}
		if (isAllZero) {
			return 0;
		}
		return -2;
	}
}
