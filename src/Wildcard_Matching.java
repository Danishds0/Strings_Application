import java.util.Scanner;

public class Wildcard_Matching {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String p = scan.nextLine();
        boolean isMatch = isMatch(s, p);
        System.out.println(isMatch);
        scan.close();
    }
    public static boolean isMatch(String s, String p) {
        int n = p.length(), m = s.length();
        boolean[]prev = new boolean[m + 1];
        // Base Conditions
        // Same as the memoization but easy to understand
        prev[0] = true;
        for(int j = 1; j <= m; j++) prev[j] = false;
        for(int i = 1; i <= n; i++){
            boolean[] curr = new boolean[m + 1];
            boolean flag = true;
            for(int k = 1; k <= i; k++){
                if(p.charAt(k - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;

            // Space Optimization
            // Time Complexity: O(N x M)
            // Space Complexity: O(M) + O(M)
            for(int j = 1; j <= m; j++){
                if(s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?'){
                    curr[j] = prev[j - 1];
                }
                else if(p.charAt(i - 1) == '*'){
                    curr[j] = prev[j] || curr[j - 1];
                }
                else curr[j] = false;
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}