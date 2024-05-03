/*
import java.io.*;
import java.util.*;

public class Main {
    static int maxVal = (int)Math.pow(2, 31);
    static List<List<Node>> graph;
    static int[] dis;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n, m 설정
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dis = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(dest, dis));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, n);

        System.out.println(dis[end]);
    }

    public static void dijkstra(int start, int n) {
        Arrays.fill(dis, maxVal);
        dis[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] isVisited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            isVisited[cur.dest] = true;
            if(cur.dis > dis[cur.dest]) continue;
            dis[cur.dest] = cur.dis;

            List<Node> nextNodes = graph.get(cur.dest);
            for(Node next : nextNodes) {
                int cost = dis[cur.dest] + next.dis;
                if(!isVisited[next.dest] && dis[next.dest] > cost) {
                    next.dis = cost;
                    dis[next.dest] = cost;
                    pq.add(next);
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        public int dest;
        public int dis;

        public Node(int dest, int dis) {
            this.dest = dest;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node node) {
            return -Integer.compare(node.dis, this.dis);
        }

        @Override
        public String toString() {
            return "dest: " + dest + ", dis: " + dis;
        }
    }
}
 */