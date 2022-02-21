package codingtest.hightscore.kit._5_brute_force_search;

import java.util.Arrays;

public class _3_carpet {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		int[] answer = solution(brown, yellow);
		System.out.println("answer: " + Arrays.toString(answer)); //[4, 3] 
	}
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        //1. yellow의 가로 구하며 알맞은 값을 체크하기
        for (int i=(brown-4)/2-1; i>=1; i--) { 
        	if (yellow % i != 0) {
        		continue;
        	}
        	int j = yellow / i;
        	if (brown == ((i + j) * 2 + 4)) {
        		answer = new int[]{i+2, j+2};
        		return answer;
        	}
        }
        throw new IllegalArgumentException("답이 없다..");
    }
}
