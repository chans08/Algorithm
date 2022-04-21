package codingtest.highscore.kit._7_dp;

import java.util.HashSet;
import java.util.Set;

/**
정확성  테스트
테스트 1 〉	통과 (1.83ms, 76.3MB)
테스트 2 〉	통과 (0.08ms, 68.2MB)
테스트 3 〉	통과 (0.11ms, 67MB)
테스트 4 〉	통과 (19.79ms, 82.5MB)
테스트 5 〉	통과 (15.62ms, 76.4MB)
테스트 6 〉	통과 (0.82ms, 76.7MB)
테스트 7 〉	통과 (1.30ms, 74.7MB)
테스트 8 〉	통과 (31.33ms, 95.3MB)
테스트 9 〉	통과 (0.12ms, 81.5MB) -> N = number 인 경우
 * @author CMN
 * @date 2022-04-22
 */
public class _1_expressed_as_n {
	public static void main(String[] args) {
//		int N = 5;
//		int number = 12; //4
		int N = 2;
		int number = 11; //3
		int answer = solution(N, number);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * N을 8번 이하로 써서 숫자를 붙여서, 사칙연산으로 number 만들기
	 * @param N
	 * @param number
	 * @return
	 */
	public static int solution(int N, int number) {
        //1. 1, ... , 8개 사용한 계산 결과 set에 대한 배열을 만든다.
        Set<Integer>[] calcResults = new HashSet[9];
        for (int i=1; i<=8; i++) {
        	calcResults[i] = new HashSet<>();
        }
        //2. i개 사용한 결과 모아서 원하는 number와 비교하고 맞으면 횟수 return, 아니면 -1 return
        for (int i=1; i<=8; i++) {
        	calcResults[i].add(getAttachNum(N, i));
        	//u+v=i (i=2 -> (u,v)=(1,1)) 인 u, v에 대하여 사칙연산한 결과를 낸다.
        	for (int u=1; u<i; u++) {
        		int v = i-u;
        		for (int uCalcResult : calcResults[u]) {
        			for (int vCalcResult : calcResults[v]) {
        				calcResults[i].add(uCalcResult + vCalcResult);
        				calcResults[i].add(uCalcResult - vCalcResult);
        				calcResults[i].add(uCalcResult * vCalcResult);
        				if (vCalcResult != 0) {
        					calcResults[i].add(uCalcResult / vCalcResult);
        				}
        			}
        		}
        	}
        	//3. 결과값과 비교해서 return 하기
        	if (calcResults[i].contains(number)) {
        		return i;
        	}
        }
        return -1;
    }
	
	/**
	 * n 을 i 번 붙여쓴 숫자를 return 한다.
	 * @param n
	 * @param i
	 * @return
	 */
	private static int getAttachNum(int n, int i) {
		StringBuilder sb = new StringBuilder();
		for (int t=0; t<i; t++) {
			sb.append(String.valueOf(n));
		}
		return Integer.parseInt(sb.toString());
	}
}
