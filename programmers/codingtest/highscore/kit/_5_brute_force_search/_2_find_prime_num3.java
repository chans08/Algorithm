package codingtest.hightscore.kit._5_brute_force_search;

import java.util.HashSet;
import java.util.Set;

/**
테스트 1 〉	통과 (16.07ms, 90.8MB)
테스트 2 〉	통과 (18.03ms, 79.4MB)
테스트 3 〉	통과 (12.20ms, 78.7MB)
테스트 4 〉	통과 (16.49ms, 76.1MB)
테스트 5 〉	통과 (23.06ms, 91.6MB)
테스트 6 〉	통과 (12.26ms, 73MB)
테스트 7 〉	통과 (12.90ms, 80.8MB)
테스트 8 〉	통과 (24.16ms, 85.7MB)
테스트 9 〉	통과 (12.09ms, 70.2MB)
테스트 10 〉	통과 (19.04ms, 78.5MB)
테스트 11 〉	통과 (15.45ms, 82.4MB)
테스트 12 〉	통과 (14.46ms, 77.3MB)
 * @author CMN
 *
 */
public class _2_find_prime_num3 {
	public static void main(String[] args) {
		String numbers = "17";
//		String numbers = "011";
//		String numbers = "9999999";
		int answer = solution(numbers);
		System.out.println("answer: " + answer);
	}
	
	/**
	 * numbers 로 만들 수 있는 소수 개수 구하기
	 * @param numbers 0~9까지 숫자만으로 이루어진, 길이 1 이상 7 이하인 문자열. 최대 9999999
	 * @return
	 */
	public static int solution(String numbers) {
        int answer = 0;
        
        //1. numbers 로 만들 수 있는 모든 숫자 allNums 구하기(순열)
        Set<Integer> allNums = getAllNums(numbers.toCharArray());
        //System.out.println("allNums: " + allNums);
        
        //2. 소수 세기
        answer = getPrimeCnt(allNums);
        
        return answer;
    }
	
	private static int getPrimeCnt(Set<Integer> allNums) {
		int cnt = 0;
		for (int num : allNums) {
			if(isPrime(num)) cnt++;
		}
		return cnt;
	}
	
	private static boolean isPrime(int num) {
		if (num == 0 || num == 1)
			return false;
		for (int i=2; i<=Math.sqrt(num); i++) { // 에라토스테네스의 체의 체크할 수
    		if (num % i == 0) {
//    			System.out.println("num: " + num);
    			return false;
    		}
        }
		return true;
	}

	/**
	 * numbers 숫자들로 만들 수  있는 모든 수 집합을 반환한다.
	 * @param numbers
	 * @return
	 */
	private static Set<Integer> getAllNums(char[] numbers) {
		Set<Integer> rtnSet = new HashSet<>();
		for (int r=1; r<=numbers.length; r++) {
			//System.out.println("r: rtnList: " + r + ": " + rtnSet);
			permutation(rtnSet, numbers, new boolean[numbers.length], numbers.length, r, "");
		}
		return rtnSet;
	}
	
	private static void permutation(Set<Integer> rtnSet, char[] numbers, boolean[] isPicked, int n, int r, String output) {
		if (r == 0) {
			rtnSet.add(Integer.parseInt(output));
			return;
		}
		for (int i=0; i<n; i++) {
			if (isPicked[i]) continue;
			isPicked[i] = true;
			permutation(rtnSet, numbers, isPicked, n, r-1, output + numbers[i]);
			isPicked[i] = false;
		}
	}
}
