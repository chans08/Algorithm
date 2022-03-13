package codingtest.highscore.kit._3_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 재구현
 * 정확성  테스트
테스트 1 〉	통과 (5.31ms, 83.2MB)
테스트 2 〉	통과 (2.48ms, 74MB)
테스트 3 〉	통과 (2.54ms, 78.2MB)
테스트 4 〉	통과 (2.84ms, 77.8MB)
테스트 5 〉	통과 (3.72ms, 81.9MB)
테스트 6 〉	통과 (1.45ms, 69.7MB)
테스트 7 〉	통과 (2.45ms, 74.6MB)
테스트 8 〉	통과 (1.99ms, 74.6MB)
테스트 9 〉	통과 (1.90ms, 79MB)
테스트 10 〉	통과 (2.68ms, 81.1MB)
테스트 11 〉	통과 (1.05ms, 71.9MB)
테스트 12 〉	통과 (0.99ms, 74.5MB)
테스트 13 〉	통과 (1.07ms, 76.9MB)
테스트 14 〉	통과 (1.38ms, 77.3MB)
테스트 15 〉	통과 (1.47ms, 74.6MB)
테스트 16 〉	통과 (1.37ms, 71.6MB)
테스트 17 〉	통과 (1.20ms, 78.2MB)
테스트 18 〉	통과 (1.10ms, 75.4MB)
테스트 19 〉	통과 (1.01ms, 72.5MB)
테스트 20 〉	통과 (1.10ms, 77.4MB)
 */
public class _2_disk_controller4 {
	public static void main(String[] args) {
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; //9
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20, 1}}; //7
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20, 1}, {7, 1}}; //6
//		int[][] jobs = {{1, 3}, {1, 9}, {2, 6}}; // 9
		int[][] jobs = {{1, 9}, {1, 3}, {2, 6}}; // 9
		int answer = solution(jobs);
		System.out.println("answer: " + answer);
	}

	/**
	 * @param jobs [[0, 3], [1, 9], [2, 6]]
	 * @return 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리할때의 평균 9
	 */
	public static int solution(int[][] jobs) {
		float answer = 0;
		//1. jobs 정렬 및 초기자료구조(jobPQueue) 세팅
		Arrays.sort(jobs, (job1, job2) -> {
			if (job1[0] <= job2[0]) {
				return -1;
			}
			return 1;
//			return job1[0] - job2[0];
		});
		Queue<int[]> jobPQueue = new PriorityQueue<>((job1, job2) -> {
			if (job1[1] < job2[1]) {
				return -1;
			}
			return 1;
			//return job1[1] - job2[1];
		});
		//2. answer에 작업시작시간부터 끝날때까지 걸린 시간을 더한다.
		int i = 0;
		int time = 0;
		while (true) {
			while (i < jobs.length && jobs[i][0] <= time) {
				jobPQueue.offer(jobs[i]);
				i++;
			}
			if (jobPQueue.isEmpty()) {
				time = jobs[i][0];
				continue;
			}
			int[] job = jobPQueue.poll();
			time += job[1];
			answer += time - job[0];
			if (i == jobs.length && jobPQueue.isEmpty()) {
				break;
			}
		}
		//3. 평균 구하여 return
		answer /= jobs.length;
		return (int) answer;
	}
}
