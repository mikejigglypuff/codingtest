using System;
namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            long[,] dp = new long[n, 10];

            dp[0, 0] = 0;
            for (int i = 1; i <= 9; i++)
                dp[0, i] = 1;

            for (int i = 1; i < n; i++)
            {
                dp[i, 0] = dp[i - 1, 1] % 1000000000;
                for (int j = 1; j < 9; j++)
                    dp[i, j] = (dp[i - 1, j - 1] + dp[i - 1, j + 1]) % 1000000000;
                dp[i, 9] = dp[i - 1, 8] % 1000000000;
            }

            long sum = 0;
            for (int i = 0; i <= 9; i++)
                sum += dp[n - 1, i];
            

            Console.WriteLine(sum % 1000000000);
        }
    }
}