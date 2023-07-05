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

    // Tabulation or bottom-up solution

    public static int longestCommonSeq(String a, String b){
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // Space Optimization solution

    public static int longestCommonSequence(String a, String b){
        int n = a.length(), m = b.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}

class Mains {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();

        int ans = Longest_Common_Subsequence.longestCommon(a, b);
        int ans2 = Longest_Common_Subsequence.longestCommonSeq(a, b);
        int ans3 = Longest_Common_Subsequence.longestCommonSequence(a, b);
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
