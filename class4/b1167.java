package class4;

/*
public class Main {

    static Node[] tree;
    static int maxNode, maxDis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int start = 0;
        tree = new Node[v + 1];

        for(int i = 0; i < v; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(s.nextToken());
            Map<Integer, Integer> m = new HashMap<>();

            while(true) {
                int connects = Integer.parseInt(s.nextToken());
                if(connects < 0) break;

                int distance = Integer.parseInt(s.nextToken());
                m.put(connects, distance);
            }

            if(m.size() == 1) start = n;
            tree[n] = new Node(m);
        }

        dfs(start, -1, 0);
        dfs(maxNode, -1, 0);

        System.out.println(maxDis);
    }

    public static void dfs(int cur, int prev, int dis) {
        Node curNode = tree[cur];
        if(!curNode.isPromising(prev)) {
            if(maxDis < dis) {
                maxDis = dis;
                maxNode = cur;
            }
            return;
        }

        for(int key : curNode.dis.keySet()) {
            if(key != prev) {
                dfs(key, cur, dis + curNode.dis.get(key));
            }
        }
    }

    public static class Node {
        public Map<Integer, Integer> dis;

        Node(Map<Integer, Integer> dis) {
            this.dis = dis;
        }

        public boolean isPromising(int prev) {
            for (int key : dis.keySet()) {
                if(key != prev) return true;
            }
            return false;
        }

        public int maxDistanceNode(int prev) {
            int result = 0;

            for(int key : dis.keySet()) {
                if(key != prev && result < dis.get(key)) result = key;
            }

            return result;
        }
    }
}
 */