package codingtest.hightscore.kit._5_brute_force_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_mock_test2 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		//int[] answers = {1,3,2,4,2};
		int[] result = solution(answers);
		System.out.println("result: " + Arrays.toString(result));
	}
	
	private static int[] guess1 = {1, 2, 3, 4, 5};
	private static int[] guess2 = {2, 1, 2, 3, 2, 4, 2, 5};
	private static int[] guess3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	public static int[] solution(int[] answers) {
		List<Integer> resultList = new ArrayList<>();
		int[] scores = new int[3]; //idx(guess1 -> 0, quess2 -> 1, quess3 -> 3) 당 score
		int answer;
		for (int i=0; i<answers.length; i++) {
			answer = answers[i];
			scores[0] = answer == guess1[i % guess1.length] ? ++scores[0] : scores[0];
			scores[1] = answer == guess2[i % guess2.length] ? ++scores[1] : scores[1];
			scores[2] = answer == guess3[i % guess3.length] ? ++scores[2] : scores[2];
		}
		
		int[] scoresClone = scores.clone();
		Arrays.sort(scoresClone);
		//System.out.println("scoresClone: " + Arrays.toString(scoresClone));
		int max = scoresClone[scores.length-1];
		for (int i=0; i<scores.length; i++) {
			if (scores[i] >= max) {
				resultList.add(i+1);
			}
		}
		return resultList.stream().mapToInt(Integer::intValue).toArray();
	}
}
