/*
import java.io.*;
import java.util.*;

public class Main {
    static int n, inf = Integer.MAX_VALUE / 2;
    static int[][] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nmx = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nmx.nextToken());
        int m = Integer.parseInt(nmx.nextToken());
        int x = Integer.parseInt(nmx.nextToken()) - 1;
        List<List<class4.Main.Node>> graph = new ArrayList<>();
        List<List<class4.Main.Node>> reverse = new ArrayList<>();
        int answer = 0;

        dis = new int[2][n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            dis[0][i] = inf;
            dis[1][i] = inf;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            graph.get(start).add(new class4.Main.Node(dest, dist));
            reverse.get(dest).add(new class4.Main.Node(start, dist));
        }

        dijkstra(x, 0, graph);

        dijkstra(x, 1, reverse);

        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dis[0][i] + dis[1][i]);
        }

        System.out.println(answer);
    }

    public static void dijkstra(int start, int index, List<List<class4.Main.Node>> graph) {
        PriorityQueue<class4.Main.Node> pq = new PriorityQueue<>();
        pq.add(new class4.Main.Node(start, 0));
        dis[index][start] = 0;

        while (!pq.isEmpty()) {
            class4.Main.Node cur = pq.poll();
            if(dis[index][cur.num] < cur.dis) continue;

            for(class4.Main.Node next : graph.get(cur.num)) {
                int cost = dis[index][cur.num] + next.dis;
                if(cost < dis[index][next.num]) {
                    dis[index][next.num] = cost;
                    next.dis = cost;
                    pq.add(next);
                }
            }
        }
    }

    public static class Node implements Comparable<class4.Main.Node> {
        int num;
        int dis;

        Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(class4.Main.Node other) {
            if(dis < other.dis) return -1;
            else if(dis == other.dis) return 0;
            return 1;
        }
    }
}
 */