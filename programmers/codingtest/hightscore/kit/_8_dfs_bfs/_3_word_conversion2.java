package codingtest.hightscore.kit._8_dfs_bfs;

/**
 * 테스트 1 〉	통과 (0.03ms, 73.8MB)
테스트 2 〉	통과 (0.06ms, 69.3MB)
테스트 3 〉	통과 (0.13ms, 72MB)
테스트 4 〉	통과 (0.02ms, 77.7MB)
테스트 5 〉	통과 (0.02ms, 70.7MB)
 * @author CMN
 *
 */
public class _3_word_conversion2 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int answer = solution(begin, target, words); //4
		System.out.println("answer: " + answer);
	}
	
	/**
	 * begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾기
	 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
		2. words에 있는 단어로만 변환할 수 있습니다.
	 * @param begin
	 * @param target
	 * @param words
	 * @return
	 */
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean[] visited = new boolean[words.length];
		int[] min = {51};
		dfsR(begin, target, words, visited, 0, min);
		answer = min[0] == 51 ? 0 : min[0];
		return answer;
	}

	public static void dfsR(String currNode, String target, String[] words, boolean[] visited, int depth, int[] min) {
		if (depth < min[0] && currNode.equals(target)) {
			min[0] = depth;
			return;
		}

		for (int i=0; i<words.length; i++) {
			if (!visited[i] && isDiffJustOneChar(currNode, words[i])) {
				visited[i] = true;
				dfsR(words[i], target, words, visited, depth+1, min);
				visited[i] = false;
			}
		}
	}

	private static boolean isDiffJustOneChar(String currNode, String nextNode) {
		boolean isOneDiff = false;
		for (int i=0; i<currNode.length(); i++) {
			boolean isDiff = currNode.charAt(i) != nextNode.charAt(i);
			if (isOneDiff && isDiff) {
				return false;
			}

			if (!isOneDiff && isDiff) {
				isOneDiff = true;
			}
		}
		return true;
	}
}
