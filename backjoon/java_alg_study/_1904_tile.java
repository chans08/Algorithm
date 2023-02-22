import java.io.IOException;

public class _1904_tile {
    static int MOD = 15746;
    public static void main(String[] args) throws IOException {
        int n = read();
        int[] fibonacci = new int[n+1];
        fibonacci[1] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        fibonacci[2] = 2;
        if (n == 2) {
            System.out.println(2);
            return;
        }
        for (int i=3; i<=n; i++) {
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % MOD;
        }
        System.out.println(fibonacci[n]);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
