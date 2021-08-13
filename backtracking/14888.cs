using System;
using System.Collections.Generic;
using System.Linq;
namespace baekjoonC____
{
    class Program
    {
        static int max = -1000000000;
        static int min = 1000000000;
        static List<int> a;
        static void Oper(int result, int[] oper, int n)
        {
            if(n == a.Count() - 1)
            {
                if (result > max)
                    max = result;
                if (result < min)
                    min = result;
                return;
            }    
            for(int i = 0; i < 4; i++)
            {
                if (oper[i] == 0)
                    continue;
                int x = (n == 0) ? a[0] : result, y = a[n + 1];
                
                oper[i] -= 1;
                switch(i)
                {
                    case 0:
                        result = x + y;
                        break;

                    case 1:
                        result = x - y;
                        break;

                    case 2:
                        result = x * y;
                        break;

                    case 3:
                        result = x / y;
                        break;
                }
                Oper(result, oper, n + 1);

                result = x;
                oper[i] += 1;
            }
        }

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            a = Array.ConvertAll(Console.ReadLine().Split(" "), int.Parse).ToList();
            int[] oper = Array.ConvertAll(Console.ReadLine().Split(" "), int.Parse);

            Oper(0, oper, 0);
            Console.WriteLine(max);
            Console.WriteLine(min);
        }
    }
}