using System;
using System.Collections.Generic;

namespace baekjoonC____
{
    class Program
    {
        static List<int> divisor(int n)
        {
            List<int> num = new List<int>();
            for(int i = n / 2; i >= 2; i--)
            {
                if (n % i == 0)
                    num.Add(i);
            }
            return num;
        }

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string ring = Console.ReadLine();
            string[] r = ring.Split(" ");
            int[] radius = new int[n];
            for (int i = 0; i < n; i++)
                radius[i] = int.Parse(r[i]);

            for (int i = 1; i < n; i++)
            {
                int share = radius[0], rest = radius[i];
                if (share > rest)
                {
                    if (share % rest == 0)
                    {
                        share /= rest;
                        rest = 1;
                    }
                    else
                    {
                        List<int> divisors = new List<int>();
                        divisors = divisor(rest);
                        foreach(int j in divisors)
                        {
                            if(share % j == 0)
                            {
                                share /= j;
                                rest /= j;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    if (rest % share == 0)
                    {
                        rest /= share;
                        share = 1;
                    }
                    else
                    {
                        List<int> divisors = new List<int>();
                        divisors = divisor(share);
                        foreach (int j in divisors)
                        {
                            if (rest % j == 0)
                            {
                                rest /= j;
                                share /= j;
                                break;
                            }
                        }
                    }
                }
                Console.WriteLine(share.ToString() + '/' + rest.ToString());
            }
        }
    }
}