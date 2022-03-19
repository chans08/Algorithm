package codingtest.highscore.kit._3_heap;

import java.util.Arrays;

//@참고: https://ko.wikipedia.org/wiki/%ED%9E%99_(%EC%9E%90%EB%A3%8C_%EA%B5%AC%EC%A1%B0)
/**
 * [H|E|A|P|S|O|R|T] 를 최대힙으로 구성하기
 * @author CMN
 * @date 2022-03-19
 */
public class _ref_heap {
	public static void main(String[] args) {
		String[] data = {"H", "E", "A", "P", "S", "O", "R", "T"};
		for (int currIdx=data.length/2-1; currIdx>=0; currIdx--) {
			//1. 자료 구조 초기화
			int leftChildIdx = currIdx*2+1;
			int rightChildIdx = currIdx*2+2;
			//2. 힙정렬하기
			recursive(data, currIdx, leftChildIdx, rightChildIdx);
		}
		System.out.println("answer: " + Arrays.toString(data));// answer: [T, S, R, P, H, O, A, E]
	}
	
	/**
	 * 현재로부터 모든 자식노드들에 대하여 최대힙으로 정렬해간다.
	 * 밑에서 두번째 깊이부터 시작해서 노드에 달려있는 leaf 중 최고를 현노드로 한 후면,
	 *  부모노드로 왔을 때에는 자식 노드는 이미 힙정렬 된 상태이므로 현노드가 작으면 레벨에 맞추어 내려주면 된다.
	 * @param data
	 * @param currIdx
	 * @param leftChildIdx
	 * @param rightChildIdx
	 */
	private static void recursive(String[] data, int currIdx, int leftChildIdx, int rightChildIdx) {
		//2. 최대값을 현재 노드로 바꿔주기
		//2-1. 현재 노드에서 직계 노드 모임에서 max인 idx 찾기
		int maxIdx = findMaxIdx(data, currIdx, leftChildIdx, rightChildIdx);
		//2-2. swap
		boolean hasToBeSwap = !data[maxIdx].equals(data[currIdx]);
		if (!hasToBeSwap) {
			return;
		}
		swap(data, currIdx, maxIdx);
		//3. 자식노드에서 다시 국소 힙정렬
		recursive(data, maxIdx, maxIdx*2+1, maxIdx*2+2);
	}
	
	private static int findMaxIdx(String[] data, int currIdx, int leftChildIdx, int rightChildIdx) {
		int maxIdx = currIdx;
		String leftChild = leftChildIdx < data.length ? data[leftChildIdx] : null;
		String rightChild = rightChildIdx < data.length ? data[rightChildIdx] : null;
		if (leftChild != null && data[maxIdx].compareTo(leftChild) < 1) {
			maxIdx = leftChildIdx;
		}
		if (rightChild != null && data[maxIdx].compareTo(rightChild) < 1) {
			maxIdx = rightChildIdx;
		}
		return maxIdx;
	}
	
	/**
	 * i 와 j 의 원소를 swap 한다.
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(String[] data, int i, int j) {
		String tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
