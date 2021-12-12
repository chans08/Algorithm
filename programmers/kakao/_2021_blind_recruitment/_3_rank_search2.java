package kakao._2021_blind_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3_rank_search2 {
	private static final int CONDITION_CNT = 4;
	private static final String HYPEN = "-";
	public static void main(String[] args) {
							//0, 	1,	2,	 	3,	  4-itemIdx
//		String[] info = {"java backend junior pizza 150",			//0-personIdx
//						"python frontend senior chicken 210",		//1
//						"python frontend senior chicken 150",		//2
//						"cpp backend senior pizza 260",				//3
//						"java backend junior chicken 80",			//4
//						"python backend senior chicken 50"};		//5
//		
//		String[] query = {"java and backend and junior and pizza 100", // condition: java backend junior pizza
//						"python and frontend and senior and chicken 200",
//						"cpp and - and senior and pizza 250",
//						"- and backend and senior and - 150",
//						"- and - and - and chicken 100",
//						"- and - and - and - 150"};
		
		String[] info = {"java backend junior pizza 150"};
		String[] query = {"java and backend and junior and pizza 100"};
		int[] sol = solution(info, query);
		//[1,1,1,1,2,4]
		System.out.println("sol: " + Arrays.toString(sol));
	}
	
	public static int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        Map<String, List<Integer>> groupToScores = new HashMap<>();
        for (int i=0; i<info.length; i++) {
        	String[] infoArray = info[i].split(" "); //length 5
        	//String[] conditions = Arrays.copyOf(infoArray, 4);
//        	for (int hypenCnt=0; hypenCnt<CONDITION_CNT; hypenCnt++) {
        	int hypenCnt = 2;
        		System.out.println("----------------------------");
        		System.out.println("hypenCnt: " + hypenCnt);
        		boolean[] visited = new boolean[infoArray.length-1];
        		combination(groupToScores, infoArray, visited, 0,  hypenCnt);
//        	}
        }
        System.out.println("groupToScores: " + groupToScores);
        return answer;
    }

	// 조합 -> start 를 늘려가며 재귀를 하고, 결과물을 result로 담아서 보내는게 핵심인듯!
	private static void combination(Map<String, List<Integer>> groupToScores, String[] infoArray, boolean[] visited, int start, int hypenCnt) {
		if (hypenCnt == 0) {
			String[] resultArray = getResultArray(infoArray, visited);
			String condition = String.join(" and ", resultArray); //java and backend and junior and pizza
    		List<Integer> scores = groupToScores.getOrDefault(condition, new ArrayList<Integer>());
    		scores.add(Integer.parseInt(infoArray[4]));
    		System.out.println("result: " + condition + infoArray[4]);
    		groupToScores.put(condition, scores);
    		return;
		}
		for (int i=start; i<infoArray.length-1; i++) {
			visited[i] = true;
			combination(groupToScores, infoArray, visited, start+1, hypenCnt-1);
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
