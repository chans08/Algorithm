package codingtest.highscore.kit._10_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
 * 정확성  테스트
테스트 1 〉	통과 (0.89ms, 72.3MB)
테스트 2 〉	통과 (2.46ms, 77.7MB)
테스트 3 〉	통과 (2.63ms, 75.6MB)
테스트 4 〉	통과 (4.20ms, 77.2MB)
테스트 5 〉	통과 (37.65ms, 89.8MB)
테스트 6 〉	통과 (146.75ms, 139MB)
테스트 7 〉	통과 (16.38ms, 89.1MB)
테스트 8 〉	통과 (75.47ms, 131MB)
테스트 9 〉	통과 (119.82ms, 141MB)
 * 참고: https://velog.io/@easycelsius/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EB%B0%A9%EC%9D%98-%EA%B0%9C%EC%88%98
 */
public class _3_room_cnt2 {
	public static void main(String[] args) {
		int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
		int answer = solution(arrows);
		System.out.println("answer: " + answer);
	}
	
	public static int solution(int[] arrows) {
		// 변수 선언
        int cnt = 0;

        // 방향 관련 배열 선언
        Pair pointHC = new Pair(0, 0);
        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

        // 방문 여부 관련 선언
        // key = 시작 node의 hashcode, value = 연결된 node들의 hashcode
        HashMap<Pair, ArrayList<Pair>> visitied = new HashMap<>();

        // 로직 처리
        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업(반복 2번)

                // 이동 진행
                Pair newPointHC = new Pair(pointHC.x + dx[arrow], pointHC.y + dy[arrow]);

                // 처음 방문하는 경우 = map에 키값이 없는 경우
                if (!visitied.containsKey(newPointHC)) {
                    // 리스트에 연결점 추가
                    visitied.put(newPointHC, makeEdgeList(pointHC));

                    if(visitied.get(pointHC) == null) { // 기존점도 없다면 업데이트
                        visitied.put(pointHC, makeEdgeList(newPointHC));
                    } else { // 기존점이 있다면 추가하기
                        visitied.get(pointHC).add(newPointHC);
                    }   

                // 재방문했고 간선을 처음 통과하는 경우
                } else if (visitied.containsKey(newPointHC) && !(visitied.get(newPointHC).contains(pointHC))) {
                    visitied.get(newPointHC).add(pointHC);
                    visitied.get(pointHC).add(newPointHC);
                    cnt++;
                }

                // 이동 완료
                pointHC = newPointHC;
            }
        }

        return cnt;
    }

    // 밸류값에 넣기 위한 리스트 만들기
    public static ArrayList<Pair> makeEdgeList(Pair pointHC) {
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(pointHC);
        return edge;
    }
	
	static class Pair {
		public int x;
		public int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.x == ((Pair)obj).x && this.y == ((Pair)obj).y;
		}
	}
}
