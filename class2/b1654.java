package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1654 {
    static int[] cables;
    static int k, n;

    public static long lancable() {
        long start = 1, end = Integer.MAX_VALUE;
        long mid = (long)Math.sqrt(start * end);
        while (end - start > 2) {
            if(lennum(mid) >= n) {
                start = mid;
            }
            else {
                end = mid;
            }
            mid = (long)Math.sqrt(start * end);
        }

        mid = end;
        while (mid > start) {
            if(lennum(mid) >= n) {
                return mid;
            }
            else {
                mid -= 1;
            }
        }

        return mid;
    }

    public static int lennum(long n) {
        if(n == 0) { return 0; }

        int result = 0, i;
        for(i = 0; i < k; i++) {
            result += cables[i] / n;
        }
        return result;
    }

    public static void main(String[] Args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            cables = new int[k];

            int i;
            for(i = 0; i < k; i++) {
                cables[i] = Integer.parseInt(br.readLine());
            }

            System.out.println(lancable());

        } catch (IOException e) {}
    }
}
