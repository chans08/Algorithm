import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int numInt;
        double numDouble;
        String str;

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        numInt = scan.nextInt();
        scan.nextLine();
        numDouble = scan.nextDouble();
        scan.nextLine();
        str = scan.nextLine();
        
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + numInt);

        /* Print the sum of the double variables on a new line. */
		System.out.printf("%.1f\r\n", d + numDouble);

        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s + str);

        scan.close();