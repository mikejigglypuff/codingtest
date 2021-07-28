using System;
using System.Collections.Generic;

namespace baekjoonC____
{
    class Program
    {
        static int gcd(int a, int b)
        {
            if (a > 1 && b > 1)
            {
                int c;
                while (b != 0)
                {
                    c = a % b;
                    a = b;
                    b = c;
                }
                return a;
            }
            else
                return a < b ? a : b;
        }

        static void Main(string[] args)
        {
            int x = int.Parse(Console.ReadLine());
            List<int> num = new List<int>(new int[x]);
            for (int i = 0; i < x; i++)
                num[i] = int.Parse(Console.ReadLine());
            num.Sort();

            int g;

            if (x == 2)
                g = Math.Abs(num[0] - num[1]);
            else
            {
                int[] num_minus = new int[x - 1];
                int mingcd = num_minus[0];
                num_minus[0] = num[1] - num[0];

                for (int i = 1; i < x - 1; i++)
                {
                    num_minus[i] = num[i + 1] - num[i];
                    int gc = gcd(num_minus[i], num_minus[i - 1]);
                    if (mingcd == 0 || mingcd > gc)
                        mingcd = gc;
                }
                g = mingcd;
            }

            string result = "";

            for (int k = 2; k < g; k++)
                if (g % k == 0)
                    result += k.ToString() + " ";
            result += g.ToString();

            Console.WriteLine(result);
        }
    }
}