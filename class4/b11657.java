/*
import java.io.*;
import java.util.*;

public class Main {
    static int maxVal = (int)Math.pow(2, 31);
    static Node[] graph;
    static long[] dis;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //v, e 설정
        StringTokenizer ne = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(ne.nextToken());
        int m = Integer.parseInt(ne.nextToken());

        graph = new Node[m];
        dis = new long[n + 1];

        int[][] num1 = new int[][]{
                {1, 2, 4},
                {1, 3, 3},
                {2, 3, -4},
                {3, 1, -2}
        };
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            long dis = Long.parseLong(st.nextToken());
            graph[i] = new Node(start, dest, dis);
        }

        if(n > 1) {
            String answer = "-1";
            if (Bellman(1, n)) {
                StringBuilder sb = new StringBuilder();

                for (int i = 2; i <= n; i++) {
                    sb.append((dis[i] == maxVal) ? "-1\n" : dis[i] + "\n");
                }

                sb.deleteCharAt(sb.length() - 1);
                answer = sb.toString();
            }

            System.out.println(answer);
        }

    }

    public static boolean Bellman(int start, int n) {
        Arrays.fill(dis, maxVal);
        dis[start] = 0;

        for(int i = 1; i <= n; i++) {
            for(Node node : graph) {
                long nextDis = dis[node.start] + node.dis;
                if(dis[node.start] != maxVal && dis[node.dest] > dis[node.start] + node.dis) {
                    if(i == n) {
                        return false;
                    }
                    dis[node.dest] = dis[node.start] + node.dis;
                }
            }
        }

        return true;
    }

    public static class Node {
        public int start;
        public int dest;
        public long dis;

        public Node(int start, int dest, long dis) {
            this.start = start;
            this.dest = dest;
            this.dis = dis;
        }
    }
}
 */