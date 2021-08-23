using System;
using System.Collections.Generic;
namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<int> scores = new List<int>();
            for (int i = 0; i < n; i++)
                scores.Add(int.Parse(Console.ReadLine()));
            List<int> dp = new List<int>();

            dp.Add(scores[0]);
            if(n > 1)
                dp.Add(scores[0] + scores[1]);
            if(n > 2)
                dp.Add(Math.Max(scores[0], scores[1]) + scores[2]);
            for (int i = 3; i < n; i++)
                dp.Add(Math.Max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i]);
            

            Console.WriteLine(dp[n - 1]);
        }
    }
}