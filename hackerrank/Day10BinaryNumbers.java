import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int remain = 0, sum = 0, max = 0;
        while (n > 0) {
            remain = n % 2;
            if (remain == 1) {
                sum += remain;
                if (sum > max) max = sum;
            } else {
                sum = 0;
            }
            n = n / 2;
        } 
        System.out.println(max);

        scanner.close();
    }
}
