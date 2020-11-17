import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * vestigium = trace
 * N by N square matrix
 * trace: the sum of the values on the main diagonal (which runs from the upper left to the lower right).
 * cell contains one of 1 - N different values, with no repeated within a row or a column
 * compute the number of rows and the number of columns that contain repeated values.
 * 
 * Input
 * - test cases: T
 * - the size of the matrix: N
 * - N lines
 * 
 * Output
 * Case #x: k r c
 * 
 * x: test case number (cf. 1)
 * k: the trace of matrix
 * r: the number of rows of the matrix that contain repeated elements. 가로줄 행
 * c: the number of columns of the matrix that contain repeated elements. 세로줄 열
 * 
 * @author CMN
 *
 */
public class QualificationRound2020 {
	private static int T;
	private static int N;
	private static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int i=1; i<=T; i++) {
			N = scanner.nextInt();
			matrix = new int[N][N];
			
			scanner.nextLine();
			for (int j=0; j<N; j++) {
				String[] strings = scanner.nextLine().split(" ");
				matrix[j] = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
			}
			
			int k = getTrace(N, matrix);
			int r = getNumberOfRows(N, matrix);
			int c = getNumberOfColumns(N, matrix);
			System.out.printf("Case #%d: %d %d %d\r\n", i, k, r, c);
		}
	}
	
	public static int getTrace(int N, int[][] matrix) {
		int result = 0;
		for (int i=0; i<N; i++) {
			result += matrix[i][i];
		}
		
		return result;
	}
	
	public static int getNumberOfRows(int N, int[][] matrix) {
		int result = 0;
		for (int i=0; i<N; i++) {
			Set<Integer> set = new HashSet<>(N);
			set.add(matrix[i][0]);
			for (int j=1; j<N; j++) {
				if (set.contains(matrix[i][j])) {
					result++;
					break;
				}
				
				set.add(matrix[i][j]);
			}
		}
		
		return result;
	}
	
	public static int getNumberOfColumns(int N, int[][] matrix) {
		int result = 0;
		for (int i=0; i<N; i++) {
			Set<Integer> set = new HashSet<>(N);
			set.add(matrix[0][i]);
			for (int j=1; j<N; j++) {
				if (set.contains(matrix[j][i])) {
					result++;
					break;
				}
				
				set.add(matrix[j][i]);
			}
		}
		
		return result;
	}
}
