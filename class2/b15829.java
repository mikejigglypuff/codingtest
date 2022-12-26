package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15829 {
    final static int r = 31, M = 1234567891;
    public static long hashing(int n, String s) {
        int i;
        long x = 1, result = 0;
        for(i = 0; i < n; i++) {
            int num = (int)(s.charAt(i) - 96);
            result = (result + num * x % M) % M;
            x = x * r % M;
        }

        return result;
    }

    public static void main(String[] Args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            System.out.println(hashing(n, s));

        } catch (IOException e) {}
    }
}
