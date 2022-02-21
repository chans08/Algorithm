package codingtest.highscore.kit._1_hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.05ms, 76.4MB)
 * 테스트 2 〉	통과 (0.06ms, 76.4MB)
 * 테스트 3 〉	통과 (0.36ms, 76.6MB)
 * 테스트 4 〉	통과 (0.66ms, 79.1MB)
 * 테스트 5 〉	통과 (0.60ms, 82.3MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (37.76ms, 81.4MB)
 * 테스트 2 〉	통과 (89.58ms, 88.3MB)
 * 테스트 3 〉	통과 (81.95ms, 94.4MB)
 * 테스트 4 〉	통과 (79.85ms, 95MB)
 * 테스트 5 〉	통과 (69.02ms, 95.6MB)
 */
public class _1_athlete_who_did_not_finish2 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String answer = solution(participant, completion);
		System.out.println(answer);
	}

	public static String solution(String[] participant, String[] completion) {
		//1. 참가자들의 이름과 이름당 명수를 Map에 담는다.
		Map<String, Integer> athleteNameToCnt = new HashMap<>();
		for (String player : participant) {
			athleteNameToCnt.put(player, athleteNameToCnt.getOrDefault(player, 0)+1);
		}
		//2. 완주자들을 Map에서 한명씩 카운트를 제거한다.
		for (String completePlayer : completion) {
			athleteNameToCnt.put(completePlayer, athleteNameToCnt.get(completePlayer)-1);
		}
		//3. 카운트가 0이 아닌 미완주자를 찾는다.
		for (String player : athleteNameToCnt.keySet()) {
			if (athleteNameToCnt.get(player) != 0) {
				return player;
			}
		}
		throw new IllegalArgumentException("미완주자가 없습니다.");
	}
}
