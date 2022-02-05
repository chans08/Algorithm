package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 	334980KB	2348ms
 * @author CMN
 * @date 2022-01-31
 */
public class _1620_i_am_poketmon_master_leedasom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int poketmonCnt = scanner.nextInt();
		int questionCnt = scanner.nextInt();
		//System.out.println("poketmonCnt, questionCnt: " + poketmonCnt + ", " + questionCnt);
		scanner.nextLine();
		Map<String, String> nameToIdxMap = new HashMap<>();
		Map<String, String> idxToNameMap = new HashMap<>();
		//1. 조건 초기화
		for (int i=1; i<=poketmonCnt; i++) {
			String pocketmonName = scanner.nextLine();
			//System.out.println("pocketmonName: " + pocketmonName);
			nameToIdxMap.put(pocketmonName, String.valueOf(i));
			idxToNameMap.put(String.valueOf(i), pocketmonName);
		}
		
		//2. 문제에 맞는 정답 출력
		for (int i=0; i<questionCnt; i++) {
			String question = scanner.nextLine();
			//System.out.println("question: " + question);
			if (question.charAt(0) <= '9') {
				System.out.println(idxToNameMap.get(question));
			} else {
				System.out.println(nameToIdxMap.get(question));
			}
		}
	}
}
