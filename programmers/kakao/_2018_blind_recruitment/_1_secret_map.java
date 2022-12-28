package src.kakao._2018_blind_recruitment;

import java.util.Arrays;

/*
 정확성  테스트
테스트 1 〉	통과 (0.08ms, 71.7MB)
테스트 2 〉	통과 (0.08ms, 74.1MB)
테스트 3 〉	통과 (0.06ms, 77.4MB)
테스트 4 〉	통과 (0.07ms, 76.1MB)
테스트 5 〉	통과 (0.07ms, 76.7MB)
테스트 6 〉	통과 (0.10ms, 75.8MB)
테스트 7 〉	통과 (0.07ms, 78.1MB)
테스트 8 〉	통과 (0.05ms, 82.6MB)
 */
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
            int num = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(num);
            binary = addZero(binary, n);
            sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (binary.charAt(j) == '0') {
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
        if (subtract > 0) {
            while (subtract-- > 0) {
                sb.append("0");
            }
        }
        sb.append(binary);
        return sb.toString();
    }
}
