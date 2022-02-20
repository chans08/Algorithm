package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 2 -> Arrays.copy 대신한 로직 개선으로 속도 높힘.
 * 		363376KB	2912ms
 * @author chaal
 *
 */
public class _18870_coordinate_compression3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//1. 입력값(n, numArray) 초기화
		int n = Integer.parseInt(scanner.nextLine());
		int[] numArray = new int[n];
		int[] copyedNumArray = new int[n];
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			numArray[i] = num;
			copyedNumArray[i] = num;
		}
		//2. 오름차순으로 정렬된 서로 다른 좌표 리스트를 만들어 해당 (원소, idx) 를 매핑한다. 이때 이 idx가 원하는 출력값이된다.
		//2-1. 오름차순으로 정렬하기
		Arrays.sort(copyedNumArray);
		//System.out.println("distinctNumArray: " + Arrays.toString(distinctNumArray)); //[-10, -9, 2, 4]
		//2-2. (원소, idx) 매핑 맵 만들기
		Map<Integer, Integer> elementToIdxMap = new HashMap<>();
		int idx = 0;
		for (int i=0; i<copyedNumArray.length; i++) {
			if (elementToIdxMap.get(copyedNumArray[i]) == null) {
				elementToIdxMap.put(copyedNumArray[i], idx);
				idx++;
			}
		}
		//3. 정답 출력
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<numArray.length; i++) {
			sb.append(elementToIdxMap.get(numArray[i]) + " ");
		}
		System.out.println(sb.toString());
	}
}
