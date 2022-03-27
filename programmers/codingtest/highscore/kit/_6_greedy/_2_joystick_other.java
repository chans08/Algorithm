package codingtest.highscore.kit._6_greedy;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.03ms, 75.5MB)
테스트 2 〉	통과 (0.05ms, 74.3MB)
테스트 3 〉	통과 (0.03ms, 73.3MB)
테스트 4 〉	통과 (0.04ms, 72.4MB)
테스트 5 〉	통과 (0.05ms, 76.9MB)
테스트 6 〉	통과 (0.03ms, 75.8MB)
테스트 7 〉	통과 (0.04ms, 71.5MB)
테스트 8 〉	통과 (0.04ms, 76.4MB)
테스트 9 〉	통과 (0.03ms, 73.8MB)
테스트 10 〉	통과 (0.03ms, 74.5MB)
테스트 11 〉	통과 (0.06ms, 76.2MB)
테스트 12 〉	통과 (0.04ms, 73.3MB)
테스트 13 〉	통과 (0.05ms, 74.7MB)
테스트 14 〉	통과 (0.06ms, 72.3MB)
테스트 15 〉	통과 (0.05ms, 73.9MB)
테스트 16 〉	통과 (0.03ms, 74.1MB)
테스트 17 〉	통과 (0.06ms, 69.4MB)
테스트 18 〉	통과 (0.05ms, 72.3MB)
테스트 19 〉	통과 (0.04ms, 74MB)
테스트 20 〉	통과 (0.06ms, 74MB)
테스트 21 〉	통과 (0.03ms, 74.8MB)
테스트 22 〉	통과 (0.03ms, 71.2MB)
테스트 23 〉	통과 (0.04ms, 77.1MB)
테스트 24 〉	통과 (0.04ms, 84.8MB)
테스트 25 〉	통과 (0.04ms, 76.4MB)
테스트 26 〉	통과 (0.04ms, 78.3MB)
테스트 27 〉	통과 (0.04ms, 69.2MB)
 */
public class _2_joystick_other {
	public static void main(String[] args) {
		String name = "JEROEN"; //56
//		String name = "JAN"; //23
//		String name = "A"; //0
//		String name = "JAZ"; //11
//		String name = "BBBBAAAABA"; //12(5+7)
		int answer = solution(name);
		System.out.println("answer: "+ answer);
	}
	
	/**
	 * ** 깔끔한 풀이!!
	 * @참고: https://programmers.co.kr/learn/courses/30/lessons/42860/solution_groups?language=java
	 * 
	 * - 맨 처음엔 A로만 이루어져
	 * - 조이스틱 이동
	 	▲ - 다음 알파벳
		▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
		◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
	 - 제한 사항
		name은 알파벳 대문자로만 이루어져 있습니다.
		name의 길이는 1 이상 20 이하입니다.
	 * @param name 만들고자 하는 이름
	 * @return 조이스틱 조작 횟수의 최솟값
	 */
	public static int solution(String name) {
		int answer = 0;
		//1. 알파벳 변경에 대한 조작 횟수의 합
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(char c:name.toCharArray())
            answer+=diff[c-'A'];

        //2. 이동에 대한 조작 횟수의 합
        //BBBBAAAABA
        int length=name.length();
        int min=length-1;
        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }                
            min=Math.min(min, i+length-next + Math.min(i, length-next));
        }
        return answer+min;
    }
}
