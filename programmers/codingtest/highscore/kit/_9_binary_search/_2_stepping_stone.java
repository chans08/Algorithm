package codingtest.highscore.kit._9_binary_search;

import java.util.Arrays;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.55ms, 84.5MB)
테스트 2 〉	통과 (0.62ms, 71.1MB)
테스트 3 〉	통과 (0.62ms, 79.6MB)
테스트 4 〉	통과 (7.80ms, 71.5MB)
테스트 5 〉	통과 (4.48ms, 80.9MB)
테스트 6 〉	통과 (32.27ms, 86.5MB)
테스트 7 〉	통과 (40.34ms, 92.8MB)
테스트 8 〉	통과 (31.53ms, 74.9MB)
테스트 9 〉	통과 (0.48ms, 79.1MB)
 * @author CMN
 * @date 2022-05-01
 */
public class _2_stepping_stone {
	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		int answer = solution(distance, rocks, n);
		System.out.println("answer: " + answer);
	}

	/**
	 * https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-Java
	 * @param distance
	 * @param rocks
	 * @param n
	 * @return
	 */
	public static int solution(int distance, int[] rocks, int n) {
		// 이분탐색은 오름차순으로 정렬되어있는 경우를 전제로한다.
        Arrays.sort(rocks);
        return binerySearch(distance, rocks, n);
    }
	
	private static int binerySearch(int distance, int[] rocks, int n){
        long ans = 0;
        long left = 1, right = distance, mid = 0;
    
        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;
            
            for(int i = 0 ; i < rocks.length ; ++i){
                if(rocks[i] - prev < mid){
                	// mid보다 작은 값이 존재한다는 뜻으로
                    // 해당 돌을 제거한다.
                    cnt++;
                } else {
           			// mid보다 크거나 같은 값이 존재하므로
                    // prev를 현재 돌로 초기화한다.
                    prev = rocks[i];
                }
            }
            
            // 마지막 돌과 도착점 사이의 거리도 확인한다.
            if(distance - prev < mid) cnt++;
            
            if(cnt <= n){
            	// 주어진 n 보다 작거나 같은 만큼 돌을 없애서
                // 최솟값 x를 만들 수 있다.
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }
}
