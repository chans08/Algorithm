package com.algorithm2020.qualification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given the starting and ending times of each activity, find any schedule that does not require the same person to cover overlapping activities, or say that it is impossible.
 * 
 * [Input]
 * T: the number of test cases
 * N: the number of activities to assign
 * The i-th of these lines: contains two integers Si and Ei.
 * 	Si: starts exactly Si minutes after midnight
 * 	Ei: ends exactly Ei minutes after midnight
 * 
 * [Output]
 * Case #x: y
 * 	x: test case number (starting from 1)
 * 	y: IMPOSSIBLE if there is no valid schedule
 * 		or a string of exactly N characters otherwise. C(Cameron) or J(Jamie).
 * 
 * 
 * @author CMN
 *
 */
public class ParentingPartneringReturns {
	private static int T;
	private static int N;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		scanner.nextLine();
		for (int i=1; i<=T; i++) {
			N = scanner.nextInt();
			scanner.nextLine();
			
			int[][] schedules = new int[N][2];//
			List<Integer> startsIdxList = new ArrayList<>();//
			for (int j=0; j<N; j++) {
				schedules[j] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				startsIdxList.add(j);
			}
			startsIdxList.sort((Integer idx1, Integer idx2) -> {
				if (schedules[idx1][0] > schedules[idx2][0]) return 1;
				else return -1;
			});
			
			int index;
			int cEnd = 0;
			int jEnd = 0;
			String[] results = new String[N];//
			String worker = null;
			for (int j=0; j<N; j++) {
				index = startsIdxList.get(j);
				if (schedules[index][0] >= cEnd) {
					worker = "C";
					cEnd = schedules[index][1];
				} else if (schedules[index][0] >= jEnd) {
					worker = "J";
					jEnd = schedules[index][1];
				} else {
					results = null;
					break;
				}
				results[index] = worker;
			}
			
			System.out.printf("Case #%d: %s\r\n", i, printOneline(results));
		}
	}
	
	public static String printOneline(String[] arrays) {
		if (arrays == null) return "IMPOSSIBLE";
		
		String result = "";
		for (String e : arrays) {
			result += e;
		}
		return result;
	}
}
