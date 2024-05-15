/*
import java.io.*;
import java.util.*;

public class Main {
    static long MODULE = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dice = Integer.parseInt(br.readLine());
        long answer = 0;

        for(int i = 0; i < dice; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long b = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            answer += (a * cal(MODULE - 2, b)) % MODULE;
        }

        System.out.println(answer % MODULE);
    }
    public static long cal(long deg, long b) {
        if(deg == 1) {
            return b % MODULE;
        }

        long v = cal(deg / 2, b);
        if(deg % 2 == 0) {
            return (v * v) % MODULE;
        }
        return ((v * v) % MODULE) * b % MODULE;
    }
}
 */