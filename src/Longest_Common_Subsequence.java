import java.util.Arrays;
import java.util.Scanner;

public class Longest_Common_Subsequence {
    //Memoization
    public static int longestCommon(String a, String b){
        int n = a.length(), m = b.length();
        int[][] dp = new int[n][m];
        for (int[] rows: dp) {
            Arrays.fill(rows, -1);
        }
        return func(a, n - 1, b, m - 1, dp);
    }

    private static int func(String a, int index1, String b, int index2, int[][] dp) {
        if(index1 < 0 || index2 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(a.charAt(index1) == b.charAt(index2)){
            return dp[index1][index2] = 1 + func(a, index1 - 1, b, index2 - 1, dp);
        }
        else return dp[index1][index2] = Math.max(func(a, index1 - 1, b, index2, dp), func(a, index1, b, index2 - 1, dp));
    }
}
class Mains {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();

        int ans = Longest_Common_Subsequence.longestCommon(a, b);
        System.out.println(ans);
    }
}
