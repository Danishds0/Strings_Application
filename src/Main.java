import java.util.List;
import java.util.Scanner;
class Main {
    // d is the number of characters in the input alphabet


    /* Driver program to test above function */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String txt = scan.next();
        String pat = scan.next();
        List<Integer> ans = Rabin_Karp.search(pat, txt);
        System.out.println("ans = " + ans);
    }
}
