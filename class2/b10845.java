package class2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;

public class b10845 {
    public static void main(String[] Args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();

        try {
            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            int i;

            for (i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String comm = input[0];
                switch (comm) {
                    case "push":
                        queue.add(Integer.parseInt(input[1]));
                        break;
                    case "pop":
                        if (queue.isEmpty()) {
                            sb.append("-1\n");
                        } else {
                            sb.append(queue.remove() + "\n");
                        }
                        break;
                    case "size":
                        if (queue.isEmpty()) {
                            sb.append("0\n");
                        } else {
                            sb.append(queue.size() + "\n");
                        }
                        break;
                    case "empty":
                        if (queue.isEmpty()) {
                            sb.append("1\n");
                        } else {
                            sb.append("0\n");
                        }
                        break;
                    case "front":
                        if (queue.isEmpty()) {
                            sb.append("-1\n");
                        } else {
                            sb.append(queue.peekFirst() + "\n");
                        }
                        break;
                    case "back":
                        if (queue.isEmpty()) {
                            sb.append("-1\n");
                        } else {
                            sb.append(queue.peekLast() + "\n");
                        }
                        break;
                }
            }
            System.out.print(sb);

        } catch (IOException e) {}
    }
}
