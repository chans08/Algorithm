package src.kakao._2018_blind_recruitment;

import java.util.Arrays;

public class _1_secret_map {
    public static void main(String[] args) {
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] answer = solution(n, arr1, arr2);
        System.out.println(Arrays.toString(answer)); //["#####","# # #", "### #", "# ##", "#####"]
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;
        for (int i=0; i<n; i++) {
            int num1 = arr1[i];
            int num2 = arr2[i];
            String binary1 = Integer.toBinaryString(num1);
            String binary2 = Integer.toBinaryString(num2);
            binary1 = addZero(binary1, n);
            binary2 = addZero(binary2, n);
            sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (binary1.charAt(j) == '0' && binary2.charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private static String addZero(String binary, int n) {
        int subtract = n - binary.length();
        StringBuilder sb = new StringBuilder();
        sb.append(binary);
        if (subtract > 0) {
            while (subtract-- > 0) {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }
}
