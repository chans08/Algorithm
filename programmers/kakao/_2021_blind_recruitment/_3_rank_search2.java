package kakao._2021_blind_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 정확성  테스트
테스트 1 〉	통과 (4.17ms, 77.7MB)
테스트 2 〉	통과 (3.86ms, 77.6MB)
테스트 3 〉	통과 (5.46ms, 78.1MB)
테스트 4 〉	통과 (16.15ms, 87.4MB)
테스트 5 〉	통과 (23.73ms, 109MB)
테스트 6 〉	통과 (38.62ms, 103MB)
테스트 7 〉	통과 (18.79ms, 87.8MB)
테스트 8 〉	통과 (125.43ms, 110MB)
테스트 9 〉	통과 (131.47ms, 115MB)
테스트 10 〉	통과 (125.81ms, 124MB)
테스트 11 〉	통과 (19.75ms, 84.4MB)
테스트 12 〉	통과 (30.90ms, 102MB)
테스트 13 〉	통과 (26.51ms, 83.6MB)
테스트 14 〉	통과 (82.59ms, 117MB)
테스트 15 〉	통과 (50.47ms, 113MB)
테스트 16 〉	통과 (20.15ms, 107MB)
테스트 17 〉	통과 (32.97ms, 107MB)
테스트 18 〉	통과 (50.82ms, 109MB)

효율성  테스트
테스트 1 〉	통과 (1306.96ms, 314MB)
테스트 2 〉	통과 (1315.44ms, 330MB)
테스트 3 〉	통과 (1415.03ms, 344MB)
테스트 4 〉	통과 (1423.64ms, 359MB)

-> combination() 함수 썼을 때,
테스트 1 〉	통과 (990.34ms, 235MB)
테스트 2 〉	통과 (962.81ms, 227MB)
테스트 3 〉	통과 (1029.21ms, 253MB)
테스트 4 〉	통과 (1052.11ms, 253MB)

-> makeCombination() 함수 썼을 때,
테스트 1 〉	통과 (1044.21ms, 193MB)
테스트 2 〉	통과 (922.78ms, 182MB)
테스트 3 〉	통과 (929.29ms, 192MB)
테스트 4 〉	통과 (1095.54ms, 197MB)

-> groupToScores key 로 " and " 형태 key 인 경우
테스트 1 〉	통과 (1002.09ms, 262MB)
테스트 2 〉	통과 (1006.81ms, 288MB)
테스트 3 〉	통과 (1018.64ms, 267MB)
테스트 4 〉	통과 (1138.98ms, 269MB)

** 효율성 테스트를 위해
*1. 모든 정렬을 미리 해둔다. -> step 2 로 표현
*2. groupToScores key 로 " and " 형태보다 "" 로 붙여서 key를 만들었을 때 효율성이 조금 더 좋다.
*
 * @author CMN
 *
 */
public class _3_rank_search2 {
	public static void main(String[] args) {
							//0, 	1,	2,	 	3,	  4-itemIdx
		String[] info = {"java backend junior pizza 150",			//0-personIdx
						"python frontend senior chicken 210",		//1
						"python frontend senior chicken 150",		//2
						"cpp backend senior pizza 260",				//3
						"java backend junior chicken 80",			//4
						"python backend senior chicken 50"};		//5
		
		String[] query = {"java and backend and junior and pizza 100", // condition: java backend junior pizza
						"python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250",
						"- and backend and senior and - 150",
						"- and - and - and chicken 100",
						"- and - and - and - 150"};
		
//		String[] info = {"java backend junior pizza 150"};
//		String[] query = {"java and backend and junior and pizza 100"};
		int[] sol = solution(info, query);
		//[1,1,1,1,2,4]
		System.out.println("sol: " + Arrays.toString(sol));
	}
	
	private static final int CONDITION_CNT = 4;
	private static Map<String, List<Integer>> groupToScores = new HashMap<>();
	public static int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        // 1. 지원 항목의 조합으로 나올 수 있는 모든 경우 구하기
        for (int i=0; i<info.length; i++) {
        	String[] infoArray = info[i].split(" "); //length 5
        	for (int hypenCnt=0; hypenCnt<=CONDITION_CNT; hypenCnt++) {
        		boolean[] visited = new boolean[infoArray.length-1];
        		combination(groupToScores, infoArray, visited, 0,  hypenCnt);
        	}
        }
        
        // 2. 같은 경우에 있는 지원자의 점수 정렬하기
        for (String key : groupToScores.keySet()) {
        	Collections.sort(groupToScores.get(key));
        }
        
        // 3. 조건에 해당하는 지원자가 몇명인지 구하기
        for (int i=0; i<queries.length; i++) {
        	//String[] temp = queries[i].replace(" and ", "").split(" ");
        	List<Integer> scores = groupToScores.get(queries[i].substring(0, queries[i].lastIndexOf(" ")));
        	//List<Integer> scores = groupToScores.get(temp[0]);
        	if (scores == null) {
        		answer[i] = 0;
        	} else {
//        		Collections.sort(scores); // query의 개수가 많을 때 효율성 테스트를 통과하기 어렵다.
        		int standardScore = Integer.parseInt(queries[i].split(" ")[7]);
//        		int standardScore = Integer.parseInt(temp[1]);
        		answer[i] = binarySearch(scores, standardScore);
        		//int idx = Collections.binarySearch(scores, standardScore);
        		//int lowerIdx = idx < 0 ? (idx + 1) * (-1) : idx; //실패(해당 점수 이상을 찾아내지 못함) 및 시간초과 뜸 -> 직접 구현 필요!!
        		//answer[i] = scores.size() - lowerIdx;
        	}
        }
        return answer;
    }
	
	public static int binarySearch(List<Integer> scoreList, int score) {
        int low = 0;
        int high = scoreList.size() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(scoreList.get(mid) < score) low = mid + 1;
            else high = mid - 1;
        }

        return scoreList.size() - low;
    }

	// 조합 -> 시작점 i 를 늘려가며 재귀를 하고, 결과물을 result로 담아서 보내는게 핵심인듯!
	private static void combination(Map<String, List<Integer>> groupToScores, String[] infoArray, boolean[] visited, int start, int hypenCnt) {
		if (hypenCnt == 0) {
			String[] resultArray = getResultArray(infoArray, visited);
			String condition = String.join(" and ", resultArray); //java and backend and junior and pizza
			//String condition = String.join("", resultArray); //java and backend and junior and pizza
			//System.out.println("condition: " + condition);
    		List<Integer> scores = groupToScores.getOrDefault(condition, new ArrayList<Integer>());
    		scores.add(Integer.parseInt(infoArray[4]));
    		groupToScores.put(condition, scores);
    		return;
		}
		for (int i=start; i<infoArray.length-1; i++) {
			visited[i] = true;
			combination(groupToScores, infoArray, visited, i+1, hypenCnt-1);
			visited[i] = false;
		}
	}

	private static String[] getResultArray(String[] infoArray, boolean[] visited) {
		String[] resultArray = new String[infoArray.length-1];
		for (int i=0; i<infoArray.length-1; i++) {
			if (visited[i]) {
				resultArray[i] = infoArray[i];
			} else {
				resultArray[i] = "-";
			}
		}
		return resultArray;
	}
}
