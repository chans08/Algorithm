import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MetrixArea {
	static int n;
	static int[][] metrix;
	static int[][] visited;
	static List<Integer> areaSizes = new ArrayList<>();
	static int size = 0;
	static Stack<int[]> stack = new Stack<>();
	
	public static void main(String[] args) {
		readGiven();
		checkAreaSize();
		areaSizes.sort(null);
		System.out.println(areaSizes.size());
		if (areaSizes.size() > 0) {
			for (int i=0; i<areaSizes.size(); i++) {
				System.out.print(areaSizes.get(i));
				if (i < n) {
					System.out.print(" ");
				}
			}
		}
	}
	
	public static void readGiven() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		metrix = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				metrix[i][j] = scan.nextInt();
			}
		}
		
		visited = new int[n][n];
	}
	
	//check는 metrix에서, stack에는 좌표를 담기.
	public static void checkAreaSize() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (metrix[i][j] == 1 && visited[i][j] == 0) {
					stack.add(new int[]{i, j});
					visited[i][j] = 1;
					size++;
					while (!stack.isEmpty()) {
						checkAroundArea(stack.pop());
					}
					areaSizes.add(size);
				}
				size = 0;
			}
		}
	}
	
	public static void checkAroundArea(int[] coordinates) {
		int x = coordinates[0];
		int y = coordinates[1];
		if (x-1 >= 0 && metrix[x-1][y] == 1 && visited[x-1][y] == 0) {
			stack.add(new int[] {x-1, y});
			visited[x-1][y] = 1;
			size++;
		}
		if (x+1 < n && metrix[x+1][y] == 1 && visited[x+1][y] == 0) {
			stack.add(new int[] {x+1, y});
			visited[x+1][y] = 1;
			size++;
		}
		if (y-1 >= 0 && metrix[x][y-1] == 1 && visited[x][y-1] == 0) {
			stack.add(new int[] {x, y-1});
			visited[x][y-1] = 1;
			size++;
		}
		if (y+1 < n && metrix[x][y+1] == 1 && visited[x][y+1] == 0) {
			stack.add(new int[] {x, y+1});
			visited[x][y+1] = 1;
			size++;
		}
	}
}
