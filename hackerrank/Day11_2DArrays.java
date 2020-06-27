import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] arr = new int[6][6];
    private static final int HOURGLASS_MINIMUM_SUM = -63;

    public static void main(String[] args) {
        

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
z
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        //compare hourglass sum
        int[] sums = new int[16];
        int max = HOURGLASS_MINIMUM_SUM;
        int k = 0;
        for (int i=1; i<5; i++) {
            for (int j=1; j<5; j++){
                sums[k] = sumHourglass(i, j);
                if (max < sums[k]) max = sums[k];
                k++;
            }
        }

        System.out.println(max);
    }

    public static int sumHourglass(int x, int y) {
        int sum = 0;
        sum += arr[x-1][y-1] + arr[x-1][y] + arr[x-1][y+1];
        sum += arr[x][y];
        sum += arr[x+1][y-1] + arr[x+1][y] + arr[x+1][y+1];
        return sum;
    }
}
