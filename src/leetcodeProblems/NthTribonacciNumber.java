package leetcodeProblems;

/**
 * @author raian.rahman
 * @since 4/24/24
 */
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        if(n<=2) {
            return Math.min(n,1);
        }

        int a=0;
        int b=1;
        int c=1;

        for(int i=3;i<=n;i++) {
            int sum = a+b+c;
            a = b;
            b = c;
            c = sum;
        }

        return c;
    }
}
