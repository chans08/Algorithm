package kakao._2021_blind_recruitment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class _3_rank_search_efficiency_test_fail {
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
		int[] sol = solution(info, query);
		//[1,1,1,1,2,4]
		System.out.println("sol: " + Arrays.toString(sol));
	}
	
	public static int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
        	//1. init conditions, queryScore
        	String[] conditions = queries[i].split(" and "); //{java, backend, junior, pizza}
        	String[] temp = conditions[3].split(" ");
        	conditions[3] = temp[0];
        	int queryScore = Integer.parseInt(temp[1]); //100
        	
        	//2. query type from String[] to String[][]
        	String[][] infoArray = Stream.of(info).map(line -> line.split(" "))
        											.toArray(String[][]::new); //[java, backend, junior, pizza, 150] ...
        	//3. search matching info 
        	Set<Integer> personIdxs = new HashSet<>();
        	Set<Integer> _personIdxs;
        	for (int personIdx=0; personIdx<infoArray.length; personIdx++) { //m: person idx
        		if (conditions[0].equals("-") || conditions[0].equals(infoArray[personIdx][0])) {
        			personIdxs.add(personIdx);
        		}
        	}
        	_personIdxs = new HashSet<>(personIdxs);
        	for (int personIdx : _personIdxs) {
        		if (!conditions[1].equals("-") && !conditions[1].equals(infoArray[personIdx][1])) {
        			personIdxs.remove(personIdx);
        		}
        	}
        	_personIdxs = new HashSet<>(personIdxs);
        	for (int personIdx : _personIdxs) {
        		if (!conditions[2].equals("-") && !conditions[2].equals(infoArray[personIdx][2])) {
        			personIdxs.remove(personIdx);
        		}
        	}
        	_personIdxs = new HashSet<>(personIdxs);
        	for (int personIdx : _personIdxs) {
        		if (!conditions[3].equals("-") && !conditions[3].equals(infoArray[personIdx][3])) {
        			personIdxs.remove(personIdx);
        		}
        	}
        	_personIdxs = new HashSet<>(personIdxs);
        	for (int personIdx : _personIdxs) {
        		if (!(Integer.parseInt(infoArray[personIdx][4]) >= queryScore)) {
        			personIdxs.remove(personIdx);
        		}
        	}
        	answer[i] = personIdxs.size();
        }
        return answer;
    }
}
