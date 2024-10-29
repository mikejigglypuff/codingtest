/*
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final long inf = 10000000000L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] graph = new long[n][n];
        initGraph(graph, n);

        int lines = Integer.parseInt(br.readLine());
        while (lines-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long dist = Long.parseLong(st.nextToken());
            graph[start - 1][end - 1] = Math.min(graph[start - 1][end - 1], dist);
        }

        FW(graph, n);
        print2dArr(graph);
    }

    private static void initGraph(long[][] graph, int size) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                graph[i][j] = (i == j) ? 0 : inf;
            }
        }
    }

    private static void FW(long[][] graph, int n) {
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    private static void print2dArr(long[][] graph) {
        StringBuffer sb = new StringBuffer();

        for(long[] i : graph) {
            for(long l : i) {
                if(l != inf) sb.append(l).append(" ");
                else sb.append("0 ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }
}
 */