package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 	17868KB	212ms
 * @author chaal
 *
 */
public class _1431_serial_number {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//1. 입력 데이터(n, serialNums) 초기화 
		int n = Integer.parseInt(scanner.nextLine());
		String[] serialNums = new String[n];
		for (int i=0; i<n; i++) {
			serialNums[i] = scanner.nextLine();
		}
		//System.out.println("serialNums: " + Arrays.toString(serialNums));
		
		//2. 1, 2, 3 조건에 맞춰 정렬
		Arrays.sort(serialNums, (a, b) -> {
			//2-1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
			if (a.length() != b.length()) {
				return a.length() - b.length();
			}
			//2-2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
			int aNumSum = getNumSum(a); 
			int bNumSum = getNumSum(b);
			//System.out.println("a, b, aNumSum, bNumSum: " + a + ", " + b + ", " + aNumSum + ", " + bNumSum);
			if (aNumSum != bNumSum) {
				return aNumSum - bNumSum;
			}
			//3-2. 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
			return a.compareTo(b);
		});
		//3. 정답 출력
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<serialNums.length; i++) {
			sb.append(serialNums[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int getNumSum(String serialNum) {
		int numSum = 0;
		for (int i=0; i<serialNum.length(); i++) {
			if (Character.isDigit(serialNum.charAt(i))) {
				numSum += Character.getNumericValue(serialNum.charAt(i));
			}
		}
		return numSum;
	}
}
