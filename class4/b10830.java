package class4;

/*
import java.io.*;
import java.util.*;

public class Main {
    static int n, max = 1000;
    static long b;
    static class4.Main.Matrix[] matrix;

    public static void main(String[] args) throws IOException {
        init();
        calc();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());

        n = Integer.parseInt(nm.nextToken());
        b = Long.parseLong(nm.nextToken());
        int twoLen = (int)(Math.log(b) / Math.log(2));

        matrix = new class4.Main.Matrix[twoLen + 1];
        for(int i = 0; i <= twoLen; i++) {
            matrix[i] = new class4.Main.Matrix(n);
        }

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            for(int j = 0; j < n; j++) {
                matrix[0].setMatrix(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= twoLen; i++) {
            matrix[i] = mulMatrix(matrix[i - 1], matrix[i - 1]);
        }
    }

    private static void calc() {
        class4.Main.Matrix result = matrix[0];
        int index = 0;
        b--;
        while (b > 0) {
            if(b % 2 != 0) {
                result = mulMatrix(result, matrix[index]);
            }

            b /= 2;
            index++;
        }

        int len = result.getLen();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                result.setMatrix(i, j, result.getMatrix(i, j) % max);
            }
        }

        System.out.println(result.toString());
    }

    private static class4.Main.Matrix mulMatrix(class4.Main.Matrix a, class4.Main.Matrix b) {
        int len = a.getLen();
        class4.Main.Matrix c = new class4.Main.Matrix(len);

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int sum = 0;

                for(int k = 0; k < len; k++) {
                    sum += (a.getMatrix(i, k) * b.getMatrix(k, j)) % max;
                }

                c.setMatrix(i, j, sum % max);
            }
        }

        return c;
    }

    static class Matrix {
        private int[][] matrix;

        Matrix(int n) {
            matrix = new int[n][n];
        }

        public void setMatrix(int y, int x, int val) {
            matrix[y][x] = val;
        }

        public int getMatrix(int y, int x) {
            return matrix[y][x];
        }

        public int getLen() { return matrix.length; }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            for(int[] i : matrix) {
                for(int num : i) {
                    sb.append(num).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);

            return sb.toString();
        }
    }
}
 */