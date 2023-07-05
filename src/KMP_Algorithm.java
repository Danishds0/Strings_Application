import java.util.Scanner;

public class KMP_Algorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String pattern = scan.nextLine();

        boolean ans = findPattern(text, pattern);
        System.out.println(ans);

    }

    public static boolean findPattern(String s, String p) {
        // Write your code here.
        int m = p.length(), n = s.length();
        int[] table = prefixTable(p.toCharArray(), m);

        int i = 0, j = 0;
        while (i < n) {
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
                if (j == m) return true;
            } else if (j > 0) j = table[j - 1];
            else i++;
        }
        return false;
    }

    public static int[] prefixTable(char[] p, int n) {
        int[] table = new int[n];
        table[0] = 0;
        int j = 0, i = 1;
        while (i < n) {
            if (p[i] == p[j]) {
                table[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) j = table[j - 1];
            else {
                table[i] = 0;
                i++;
            }
        }
        return table;
    }
}