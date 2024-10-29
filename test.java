import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        char[] result = br.readLine().toCharArray();
        while (--loop > 0) {
            char[] input = br.readLine().toCharArray();

            for(int i = 0; i < result.length; i++) {
                char cur = result[i];
                if(cur != '?' && cur != input[i]) { result[i] = '?'; }
            }
        }

        System.out.println(result);
    }
}
