/*
import java.io.*;
import java.util.*;

public class Main {

    static int max = (int)Math.pow(2, 30) - 1;
    static Path[] graph;
    static StringBuffer result = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            StringTokenizer nmw = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(nmw.nextToken());
            int m = Integer.parseInt(nmw.nextToken());
            int w = Integer.parseInt(nmw.nextToken());
            graph = new Path[m * 2 + w];

            for(int j = 0; j < m; j++) {
                StringTokenizer set = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(set.nextToken());
                int e = Integer.parseInt(set.nextToken());
                int t = Integer.parseInt(set.nextToken());
                graph[j] = new Path(s, e, t);
                graph[m + j] = new Path(e, s, t);
            }

            for(int j = 0; j < w; j++) {
                StringTokenizer set = new StringTokenizer(br.readLine());
                graph[m * 2 + j] = new Path(
                    Integer.parseInt(set.nextToken()),
                    Integer.parseInt(set.nextToken()),
                    -Integer.parseInt(set.nextToken())
                );
            }

            setResult(n);
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }

    private static void setResult(int len) {
        String resultStr = "NO";
        if(BF(len)) {
            resultStr = "YES";
        }
        result.append(resultStr).append("\n");
    }

    private static boolean BF(int len) {
        int[] table = new int[len + 1];

        //테이블 초기화
        for(int i = 0; i <= len; i++) {
            table[i] = max;
        }

        table[1] = 0;

        for(int i = 1; i < len; i++) {
            for(Path p : graph) {
                if(table[p.end] > table[p.start] + p.dist) table[p.end] = table[p.start] + p.dist;
            }
        }

        //음의 사이클 여부 검사
        for(Path p : graph) {
            if(table[p.end] > table[p.start] + p.dist) return true;
        }

        return false;
    }

    private static class Path {
        int start;
        int end;
        int dist;

        Path(int s, int e, int d) {
            this.start = s;
            this.end = e;
            this.dist = d;
        }
    }
}
*/
