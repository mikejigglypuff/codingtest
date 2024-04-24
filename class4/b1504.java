/*
import java.io.*;
import java.util.*;

public class Main {
    static long maxVal = (long)Math.pow(2, 32) - 1;
    static Node[][] dis;
    public static void main(String[] args) throws IOException {
        long answer = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer ne = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(ne.nextToken());
        int e = Integer.parseInt(ne.nextToken());


        //그래프 초기화
        dis = new Node[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dis[i][j] = new Node(i, maxVal);
            }
        }

        //간선 초기화
        for(int i = 0; i < e; i++) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(edge.nextToken());
            int e2 = Integer.parseInt(edge.nextToken());
            long d = Long.parseLong(edge.nextToken());
            dis[e1][e2] = new Node(e2, d);
            dis[e2][e1] = new Node(e1, d);
        }

        StringTokenizer ab = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(ab.nextToken());
        int b = Integer.parseInt(ab.nextToken());

        //1->a, 1->b, a->n, b->n의 최솟값 구하기
        long startToA = dijkstra(1, a, n);
        long startToB = dijkstra(1, b, n);
        long aToN = dijkstra(a, n, n);
        long bToN = dijkstra(b, n, n);
        long aToB = dijkstra(a, b, n);

        long AB = (startToA == maxVal || bToN == maxVal) ? maxVal : startToA + bToN;
        long BA = (startToB == maxVal || aToN == maxVal) ? maxVal : startToB + aToN;
        if((AB != maxVal || BA != maxVal) && aToB != maxVal) {
            answer = Math.min(AB, BA) + aToB;
        }

        System.out.println(answer);
    }

    public static long dijkstra(int start, int end, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n + 1];
        pq.add(new Node(start, 0));
        long[] d = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            d[i] = maxVal;
        }
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int num = cur.num;
            if(d[num] < cur.dis) continue;
            isVisited[num] = true;

            for(int i = 1; i <= n; i++) {
                Node next = dis[num][i];
                if(isVisited[i] || next.dis == maxVal) continue;

                long cost = cur.dis + next.dis;


                if(cost < d[i]) {
                    d[next.num] = cost;
                    pq.add(new Node(next.num, cost));
                }
            }
        }

        return d[end];
    }

    public static class Node implements Comparable<Node> {
        int num;
        long dis;

        Node(int num, long dis) {
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