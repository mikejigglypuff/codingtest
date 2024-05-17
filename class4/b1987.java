/*
import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int maxLen = 1, ascii = 65;
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer rc = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(rc.nextToken());
        int c = Integer.parseInt(rc.nextToken());

        graph = new char[r][c];

        for(int i = 0; i < r; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        boolean[] isVisited = new boolean[26];
        dfs(0, 0, 1, isVisited);

        System.out.println(maxLen);
    }

    public static void dfs(int x, int y, int depth, boolean[] isVisited) {
        isVisited[(int)graph[y][x] - ascii] = true;

        for(int i = 0; i < 4; i++) {
            int curX = x + dx[i], curY = y + dy[i];
            if(curX >= 0 && curX < graph[0].length && curY >= 0 && curY < graph.length) {
                char next = graph[curY][curX];
                if(!isVisited[(int)next - ascii]) {
                    dfs(curX, curY, depth + 1, Arrays.copyOf(isVisited, isVisited.length));
                }
            }
        }

        if(maxLen < depth) maxLen = depth;
    }
}
 */