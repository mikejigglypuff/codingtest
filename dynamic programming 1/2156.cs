using System;
namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] wine = new int[n];
            int[] dp = new int[n];
            for(int i = 0; i < n; i++)
                wine[i] = int.Parse(Console.ReadLine());

            dp[0] = wine[0];
            if (n >= 3)
            {
                dp[1] = dp[0] + wine[1];
                dp[2] = Math.Max(Math.Max(dp[0] + wine[2], wine[1] + wine[2]), dp[1]);
                for (int i = 3; i < n; i++)
                {
                    dp[i] = Math.Max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]);
                    dp[i] = Math.Max(dp[i - 1], dp[i]);
                }
            }
            else if (n == 2)
                dp[1] = dp[0] + wine[1];

            Console.WriteLine(dp[n - 1]);
        }
    }
}