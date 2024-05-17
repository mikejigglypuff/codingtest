/*
import java.io.*;
import java.util.*;

public class Main {
    static char[][] cheese;
    static int n, m, minAir = 2, time = 0;
    static int[][] d = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int[][] melts;

    public static void main(String[] args) throws IOException {
        init();

        while (existsCheese()) {
            bfs();
            removeCheese();
            ++time;
        }

        System.out.println(time);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());

        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        cheese = new char[n][m];
        melts = new int[n][m];

        for(int i = 0; i < n; i++) {
            cheese[i] = br.readLine().replace(" ", "").toCharArray();
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            ++melts[cur[0]][cur[1]];

            for(int[] dir : d) {
                int curX = cur[1] + dir[1], curY = cur[0] + dir[0];
                if(curX >= 0 && curX < m && curY >= 0 && curY < n) {
                    if(melts[curY][curX] == 0 && cheese[curY][curX] == '0') {
                        queue.add(new int[]{curY, curX});
                        melts[curY][curX] = 1;
                    } else if(cheese[curY][curX] == '1') {
                        ++melts[curY][curX];
                    }
                }
            }
        }
    }

    private static void removeCheese() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(melts[i][j] >= minAir) {
                    cheese[i][j] = '0';
                }
                melts[i][j] = 0;
            }
        }
    }

    private static boolean existsCheese() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(cheese[i][j] == '1') return true;
            }
        }
        return false;
    }

    private static void testInit() {
        /*
        n = 8;
        m = 9;
        cheese = new char[][]{
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '0', '1', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'}
        };
        */
        /*
        n = 3;
        m = 3;
        cheese = new char[][]{
                {'0', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '0'}
        };
         */
        /*
        n = 8;
        m = 9;
        cheese = new char[][]{
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '1', '1', '1', '0', '1', '1', '0', '0'},
                {'0', '1', '0', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '0', '0', '0', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '0', '0', '1', '1', '1', '0'},
                {'0', '0', '1', '0', '0', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'}
        };
         */

        /*
        n = 11;
        m = 15;
        cheese = new char[][]{
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '0', '0', '0', '1', '0', '0', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '0', '1', '0', '0', '1', '1', '1', '0', '1', '1', '0'},
                {'0', '0', '1', '0', '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0'},
                {'0', '1', '1', '0', '1', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'0', '0', '0', '1', '1', '0', '1', '0', '1', '0', '0', '0', '0', '1', '0'},
                {'0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '0', '0', '1', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}
         };


         melts = new int[n][m];
    }
}
 */