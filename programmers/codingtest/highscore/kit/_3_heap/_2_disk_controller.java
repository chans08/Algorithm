package codingtest.highscore.kit._3_heap;

/**
 * 실패!!
정확성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (2.68ms, 63.5MB)
테스트 12 〉	실패 (51.16ms, 69.4MB)
테스트 13 〉	실패 (42.14ms, 87.2MB)
테스트 14 〉	실패 (0.50ms, 77.2MB)
테스트 15 〉	실패 (0.34ms, 63.2MB)
테스트 16 〉	통과 (0.60ms, 73.5MB)
테스트 17 〉	실패 (0.32ms, 71.5MB)
테스트 18 〉	실패 (0.27ms, 68.1MB)
테스트 19 〉	통과 (0.39ms, 77.2MB)
테스트 20 〉	통과 (0.31ms, 74.9MB)
 * @author CMN
 * @date 2022-03-11
 */
public class _2_disk_controller {
	public static void main(String[] args) {
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; //9
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20, 1}}; //7
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20, 1}, {7, 1}}; //6
//		int[][] jobs = {{1, 3}, {1, 9}, {2, 6}}; //9
		int[][] jobs = {{1, 9}, {1, 3}, {2, 6}}; // 9
		int answer = solution(jobs);
		System.out.println("answer: " + answer); 
	}
	
	/**
	 * - 조건
	 * 	- jobs의 길이는 1 이상 500 이하
	 * 	- 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하
	 * 	- 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하
	 * ** 평균이 가장 적어지는 방법은 요청시간과, 종료 둘다 적을 수록 좋은 상관관계가 있다..
	 * @param jobs [[0, 3], [1, 9], [2, 6]]
	 * @return 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리할때의 평균 9
	 */
	public static int solution(int[][] jobs) {
        //1. 평균을 구할 jobs의 순서 나열하기(순열)
        boolean[] isVisited = new boolean[jobs.length];
        int[][] resultJobs = new int[jobs.length][2];
        int[] _answer = {2000}; //job의 처리 최악의 경우의 평균 시간보다 더 큰값으로 초기화한다.
        permutation(jobs, resultJobs, 0, isVisited, _answer);
        return _answer[0];
    }

	/**
	 * jobs 순서에 대하여 순열을 만든다.
	 * @param jobs
	 * @param resultJobs
	 * @param depth
	 * @param isVisited
	 * @param _answer _answer[0] = answer
	 */
	private static void permutation(int[][] jobs, 
			int[][] resultJobs,
			int depth,
			boolean[] isVisited, 
			int[] _answer) {
		if (depth == jobs.length) {
			//2. 평균 구하고, _answer를 평균의 최소값으로 대체하기
//			Arrays.stream(resultJobs).forEach(arr
//						-> System.out.println("arr: " + Arrays.toString(arr)));
			int mean = getMean(resultJobs);
			//System.out.println("mean: " + mean);
			if (_answer[0] > mean) {
				_answer[0] = mean;
			}
			return;
		}
		for (int i=0; i<jobs.length; i++) {
			if (!isVisited[i]) {
				resultJobs[depth] = jobs[i];
				isVisited[i] = true;
				permutation(jobs, resultJobs, depth + 1, isVisited, _answer);
				isVisited[i] = false;
			}
		}
	}
	
	private static int getMean(int[][] jobs) {
		double sum = 0;
		int preJobEnd = jobs[0][0] + jobs[0][1];
        sum += jobs[0][1] - jobs[0][0];
        for (int i=1; i<jobs.length; i++) {
        	if (jobs[i][0] < preJobEnd) {
        		preJobEnd = jobs[i][1] + preJobEnd;
        	} else {
        		preJobEnd = jobs[i][0] + jobs[i][1];
        	}
        	sum += preJobEnd - jobs[i][0];
        	//System.out.println("sum: " + sum);
        }
        return (int)Math.floor(sum / jobs.length);
	}
}
