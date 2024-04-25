/*
import java.io.*;
import java.util.*;

public class Main {
    static int maxVal = (int)Math.pow(2, 31) - 1;
    static List<List<Node>> dis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //v, e 설정
        StringTokenizer ve = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(ve.nextToken());
        int e = Integer.parseInt(ve.nextToken());

        //그래프 초기화
        for(int i = 0; i < v + 1; i++) {
            dis.add(new ArrayList<>());
        }

        //시작점 설정
        int start = Integer.parseInt(br.readLine());

        //간선 초기화
        for(int i = 0; i < e; i++) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(edge.nextToken());
            int e2 = Integer.parseInt(edge.nextToken());
            int d = Integer.parseInt(edge.nextToken());
            dis.get(e1).add(new Node(e2, d));
        }

        int[] dij = Arrays.copyOfRange(dijkstra(start, v), 1, v + 1);

        System.out.println(Stringify(dij));
    }

    public static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n + 1];

        int[] d = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            d[i] = maxVal;
        }

        pq.add(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int num = cur.num;
            if(d[num] < cur.dis) continue;
            isVisited[num] = true;

            for(Node next : dis.get(cur.num)) {
                if(isVisited[next.num]) continue;

                int cost = cur.dis + next.dis;
                if(cost < d[next.num]) {
                    d[next.num] = cost;
                    pq.add(new Node(next.num, cost));
                }
            }
        }

        return d;
    }

    public static String Stringify(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int i : arr) {
            String adds = "INF\n";
            if(i != maxVal) adds = i + "\n";
            sb.append(adds);
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static class Node implements Comparable<Node> {
        int num;
        int dis;

        Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node other) {
            if(dis < other.dis) return -1;
            else if(dis == other.dis) return 0;
            return 1;
        }
    }
}
 */