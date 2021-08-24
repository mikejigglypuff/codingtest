using System;
namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= n; i++)
            {
                int two = (i % 2 == 0) ? dp[i / 2] + 1 : dp[(i - 1) / 2] + 2;
                int three = (i % 3 == 0) ? dp[i / 3] + 1 : (i % 3 == 1) ? dp[(i - 1) / 3] + 2 : dp[(i - 2) / 3] + 3;
                dp[i] = Math.Min(dp[i - 1] + 1, Math.Min(two, three));
            }
            Console.WriteLine(dp[n]);
        }
    }
}