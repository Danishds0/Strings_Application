import java.util.Scanner;

public class Repeated_String_Match {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();

        int ans = repeatedStringMatch(a, b);
        System.out.println(ans);
        scan.close();
    }

    private static int repeatedStringMatch(String a, String b) {
        int n = a.length(), m = b.length();
        StringBuilder sb = new StringBuilder();
        int index = m / n, count = 0;
        for (int i = 0; i <= index + 2; i++) {
            if(sb.toString().contains(b)) return count;
            else{
                sb.append(a);
                count++;
            }
        }
        return -1;
    }
}
