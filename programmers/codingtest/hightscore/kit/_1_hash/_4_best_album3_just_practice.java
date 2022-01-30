package codingtest.highscore.kit._1_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
정확성  테스트
테스트 1 〉	통과 (6.63ms, 71.8MB)
테스트 2 〉	통과 (5.22ms, 80.9MB)
테스트 3 〉	통과 (7.39ms, 81.2MB)
테스트 4 〉	통과 (5.17ms, 79.7MB)
테스트 5 〉	통과 (6.24ms, 74.2MB)
테스트 6 〉	통과 (5.01ms, 74.3MB)
테스트 7 〉	통과 (7.00ms, 83.4MB)
테스트 8 〉	통과 (5.40ms, 77.6MB)
테스트 9 〉	통과 (4.91ms, 74.2MB)
테스트 10 〉	통과 (6.63ms, 79.8MB)
테스트 11 〉	통과 (4.62ms, 71.7MB)
테스트 12 〉	통과 (5.33ms, 77.7MB)
테스트 13 〉	통과 (7.52ms, 73.7MB)
테스트 14 〉	통과 (5.40ms, 70.6MB)
테스트 15 〉	통과 (4.84ms, 79.4MB)
 * @author CMN
 *
 */
public class _4_best_album3_just_practice {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
//		String[] genres = {"classic", "pop", "classic", "classic", "pop", "pop"};
//		int[] plays = {500, 600, 150, 800, 2500, 2500}; //[4, 5, 3, 0]
//		String[] genres = {"classic", "pop", "classic", "classic", "pop", "pop", "pop"};
//		int[] plays = {100, 100, 100, 100, 100, 100, 100}; //[1, 4, 0, 2]
//		String[] genres = {"a","b","c","d","a","d","d","d","a","a","c","c"};
//		int[] plays = {100,300,400,150,100,300,200,600,700,110,900,9000}; //[11,10,7,5,8,9,1]
		int[] answer = solution(genres, plays);
		System.out.println(Arrays.toString(answer));
	}
	
	/**
	 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
	2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
	3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
	 * @param genres
	 * @param plays
	 * @return
	 */
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		Map<String, Integer> genreToPlayCntMap = new HashMap<>();
		Map<String, Map<Integer, Integer>> genreToSongIdPlayCntMap = new HashMap<>();
		//1. 데이터 초기화
		for (int i=0; i<genres.length; i++) {
			genreToPlayCntMap.put(genres[i], genreToPlayCntMap.getOrDefault(genres[i], 0) + plays[i]);
			Map<Integer, Integer> songIdToPlayCntMap = genreToSongIdPlayCntMap.getOrDefault(genres[i], new HashMap<>());
			songIdToPlayCntMap.put(i, songIdToPlayCntMap.getOrDefault(i, 0) + plays[i]);
			genreToSongIdPlayCntMap.put(genres[i], songIdToPlayCntMap);
		}
		//2. 요건에 맞게 정렬
		//2-1. 요건1. 가장 많이 재생된 장르
		String[] genreArray = genreToPlayCntMap.keySet().toArray(new String[0]);
		Arrays.sort(genreArray, (g1, g2) -> genreToPlayCntMap.get(g2) - genreToPlayCntMap.get(g1));
		System.out.println("genreArray: " + Arrays.toString(genreArray));
		//2-2. 요건2. 장르 내에서 가장 많이 재생된 노래 (최대 2개)
		//요건3. 동일 재생 시 고유 번호가 낮은 노래 순
		List<Integer> _answer = new ArrayList<>();
		for (int i=0; i<genreArray.length; i++) {
			Map<Integer, Integer> songIdAndPlayCntMap = genreToSongIdPlayCntMap.get(genreArray[i]);
			List<Integer> songIdList = new ArrayList<>(songIdAndPlayCntMap.keySet());
			songIdList.sort((i1, i2) -> 
				{
					int playCnt1 = songIdAndPlayCntMap.get(i1);
					int playCnt2 = songIdAndPlayCntMap.get(i2);
					if (playCnt1 != playCnt2) {
						return playCnt2 - playCnt1;
					} else {
						return i1 - i2;
					}
				});
			//3. 최대 2개씩 담기
			int j = 0;
			while (j < 2 && j < songIdList.size()) {
				System.out.println(j);
				_answer.add(songIdList.get(j));
				j++;
			}
		}
		answer = _answer.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}
}
