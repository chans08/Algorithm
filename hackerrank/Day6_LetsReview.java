import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i=0; i<t; i++) {
            String s = scan.nextLine();
            printer(s);
        }
    }

    public static void printer(String s) {

        String odd = "";
        String even = "";

        for (int i=0; i<s.length(); i++) {
            if (i % 2 == 1) odd += s.charAt(i);
            else even += s.charAt(i);
        }

        System.out.printf("%s %s\r\n", even, odd);
    }
}