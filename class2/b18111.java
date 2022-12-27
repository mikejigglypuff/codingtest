package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b18111 {
    static int n, m, b, mintime = 128 * (int)Math.pow(10, 6), maxfloor = 0;
    static int[][] blocks;

    public static void till_ground() {
        int floor = 0, time = 0, sum = 0, x, i, j;

        while (true) {
            time = 0;
            sum = 0;

            for(i = 0; i < n; i++) {
                for(j = 0; j < m; j++) {
                    x = blocks[i][j] - floor;
                    sum += x;
                    if(x > 0) {
                        time += x * 2;
                    }
                    else {
                        time += Math.abs(x);
                    }
                }
            }

            if(sum + b >= 0) {
                if(time < mintime) {
                    mintime = time;
                    maxfloor = floor;
                }
                else if(time == mintime && floor > maxfloor) {
                    maxfloor = floor;
                }
            }
            else {
                break;
            }

            floor++;
        }
    }

    public static void main(String[] Args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] nmb = br.readLine().split(" ");
            n = Integer.parseInt(nmb[0]);
            m = Integer.parseInt(nmb[1]);
            b = Integer.parseInt(nmb[2]);
            blocks = new int[n][m];

            int i, j;
            for(i = 0; i < n; i++) {
                nmb = br.readLine().split(" ");
                for(j = 0; j < m; j++) {
                    blocks[i][j] = Integer.parseInt(nmb[j]);
                }
            }

            till_ground();
            System.out.println(String.format("%d %d", mintime, maxfloor));

        } catch (IOException e) {}
    }
}
