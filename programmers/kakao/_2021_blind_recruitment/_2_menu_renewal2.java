package kakao._2021_blind_recruitment;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class _2_menu_renewal2 {
	public static void main(String[] args) {
		//String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] courses = {2,3,4};
		//int[] courses = {2,3,5};
		String[] ans = solution(orders, courses);
		System.out.println("ans: " + Arrays.toString(ans));
	}
	
	/**
	 * @param orders ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
	 * @param courses [2,3,4]
	 * @return ["AC", "ACDE", "BCFG", "CDE"] >> 사전 순으로 오름차순 정렬
	 */
	public static String[] solution(String[] orders, int[] courses) {
		Set<String> maxMenu = new TreeSet<>();
		for (int course : courses) {
			TreeMap<String, Integer> menuToCntMap = new TreeMap<>();
			boolean[] visited;
			for (String order : orders) {
				order = getAscAlphabets(order);
				
				visited = new boolean[order.length()];
				combination(order, visited, menuToCntMap, 0, order.length(), course);
			}
			maxMenu.addAll(getMaxCntMenu(menuToCntMap));
		}
		return maxMenu.toArray(new String[0]);
	}
	
	private static String getAscAlphabets(String order) {
		char[] charArray = order.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	private static Set<String> getMaxCntMenu(TreeMap<String, Integer> menuToCntMap) {
		Set<String> rtn = new TreeSet<>();
		OptionalInt max = menuToCntMap.values().stream()
													.mapToInt(num -> num)
													.filter(num -> num > 1)
													.max();
													
		if (!max.isPresent()) {
			return rtn;
		} else {
			return menuToCntMap.entrySet().parallelStream()
									.filter(entry -> entry.getValue() == max.getAsInt())
									.map(entry -> entry.getKey())
									.collect(Collectors.toSet());
		}
	}

	private static void combination(String order, boolean[] visited, TreeMap<String, Integer> menuToCntMap, int start, int n, int r) {
		String menu;
		if (r == 0) {
			menu = getMenu(order, visited);
			menuToCntMap.put(menu, menuToCntMap.getOrDefault(menu, 0)+1);
			return;
		}
		
		for (int i=start; i<n; i++) {
			visited[i] = true;
			combination(order, visited, menuToCntMap, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	private static String getMenu(String order, boolean[] visited) {
		String menu = "";
		for (int i=0; i<order.length(); i++) {
			if (visited[i]) {
				menu += order.charAt(i);
			}
		}
		return menu;
	}
}
