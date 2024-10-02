/*
import java.util.*;

public class Main {
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) {
        long a = 12345678999L, b = 99987654321L;
        fibonacci(b);
        System.out.println(fiboSum(a, b));
    }

    private static void fibonacci(long max) {
        long start1 = 1, start2 = 2;
        nums.add(start1);
        nums.add(start2);

        while (start2 < max) {
            long temp = start2;
            start2 += start1;
            start1 = temp;
            nums.add(start2);
        }
    }

    private static long fiboSum(long start, long end) {
        long sum = 0;
        for(long l : nums) {
            if(l > start && l < end) sum += l;
        }
        return sum;
    }
}
*/