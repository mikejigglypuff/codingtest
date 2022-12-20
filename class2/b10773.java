import java.util.Scanner;
import java.util.Stack;

public class b10773 {
	public static int stack_sum(Stack<Integer> s) {
		int result = 0;
		while(!s.empty()) {
			result += s.pop();
		}
		return result;
	}

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int repeat_count = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		int i, x;
		for(i = 0; i < repeat_count; i++) {
			x = sc.nextInt();
			if(x != 0) { stack.push(x); }
			else { stack.pop(); }
		}

		System.out.println(stack_sum(stack));

	}
}
