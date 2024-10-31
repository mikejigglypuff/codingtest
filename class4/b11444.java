/*
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final long mod = 1000000007;
    static Map<Long, Long> memo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memo.put(0L, 0L);
        memo.put(1L, 1L);
        memo.put(2L, 1L);
        memo.put(3L, 2L);

        long n = Long.parseLong(br.readLine());
        System.out.println(fibo(n));
    }

    public static long fibo(long n) {
        if(memo.containsKey(n)) return memo.get(n);

        long a = fibo(n / 2 + 1), b = fibo(n / 2), c;

        if(n % 2 != 0) {
            memo.put(n, ((a % mod) * (a % mod) % mod + (b % mod) * (b % mod) % mod) % mod);
        } else {
            c = fibo(n / 2 - 1);
            memo.put(n, ((a % mod) * (b % mod) % mod + (b % mod) * (c % mod) % mod) % mod);
        }
        return memo.get(n);
    }
}
 */