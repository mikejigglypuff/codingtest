import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10828 {
	public static void main(String[] Args) {
		Stack<Integer> stack = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(bf.readLine());
			int i;
			String result = "";

			for (i = 0; i < n; i++) {
				String[] input = bf.readLine().split(" ");
				String comm = input[0];

				switch (comm) {
					case "push":
						stack.add(Integer.parseInt(input[1]));
						break;
					case "pop":
						if (stack.isEmpty()) {
							result += "-1\n";
						} else {
							result += stack.pop() + "\n";
						}
						break;
					case "size":
						if (stack.isEmpty()) {
							result += "0\n";
						} else {
							result += stack.size() + "\n";
						}
						break;
					case "empty":
						result += stack.isEmpty() ? "1\n" : "0\n";
						break;
					case "top":
						if (stack.isEmpty()) {
							result += "-1\n";
						} else {
							result += stack.peek() + "\n";
						}
						break;
				}
			}

			System.out.println(result);
		} catch (IOException e) {

		}
	}
}
