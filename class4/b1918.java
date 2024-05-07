/*
import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Integer> priority = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();

        priority.put('(', 0);
        priority.put(')', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if((int)c >= 65 && (int)c <= 90) {
                sb.append(c);
            } else if(c == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                int prior = priority.get(c);

                if(c != '(' && !stack.isEmpty() && prior <= priority.get(stack.peek())) {
                    while (!stack.isEmpty() && prior <= priority.get(stack.peek())) {
                        sb.append(stack.pop());
                    }
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
 */