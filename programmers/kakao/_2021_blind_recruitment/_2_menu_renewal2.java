package kakao._2021_blind_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _2_menu_renewal2 {
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		//String[] orders = {"XYZ", "XWY", "WXA"};
		int[] courses = {2,3,4};
		//int[] courses = {2,3,5};
		String[] ans = solution(orders, courses);
		for(String s : ans)
			System.out.println(s);
	}
	public static String[] solution(String[] orders, int[] courses) {
		
	}
	
	private static void combination(char[] memu, boolean[] visited, HashMap<String, Integer> menuToCntMap, int start, int n, int r) {
		String result;
		if (r == 0) {
			result = getResult(memu, visited);
			menuToCntMap.add(result);
			return;
		}
		
		for (int i=start; i<n; i++) {
			visited[i] = true;
			combination(memu, visited, menuToCntMap, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	private static String getResult(char[] charArr, boolean[] visited) {
		String result = "";
		for (int i=0; i<charArr.length; i++) {
			if (visited[i]) {
				result += charArr[i];
			}
		}
		return result;
	}
}
