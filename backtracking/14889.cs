using System;
using System.Collections.Generic;
using System.Linq;
namespace baekjoonC____
{
    class Program
    {
        static int[][] syn;
        static int min = 1000;

        static void startlink(int n)
        {
            for (int i = 1 << (n / 2 + 1) - 1; i < (1 << n); i++)
            {
                List<int> start = new List<int>();
                List<int> link = new List<int>();

                for(int j = 0; j < n; j++)
                {
                    if ((i & (1 << j)) != 0)
                        start.Add(j);
                    else
                        link.Add(j);
                }

                if (start.Count() == n / 2 && link.Count() == n / 2)
                {
                    int ssum = abilsum(start), lsum = abilsum(link);
                    int result = Math.Abs(ssum - lsum);
                    if (result < min)
                        min = result;
                }
            }
        }

        static int abilsum(List<int> nums)
        {
            int sum = 0, count = 0, length = nums.Count();
            while(count < length)
            {
                int m = nums[count];
                for(int i = count + 1; i < length; i++)
                {
                    int n = nums[i];
                    sum += syn[n][m] + syn[m][n];
                }
                count++;
            }
            return sum;
        }

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            syn = new int[n][];
            for (int i = 0; i < n; i++)
                syn[i] = Array.ConvertAll(Console.ReadLine().Split(" "), int.Parse);


            startlink(n);
            Console.WriteLine(min);
        }
    }
}