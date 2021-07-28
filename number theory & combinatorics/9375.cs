using System;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int t = int.Parse(Console.ReadLine());
            for(int i = 0; i < t; i++)
            {
                int n = int.Parse(Console.ReadLine());
                Dictionary<string, string> clothes = new Dictionary<string, string>();
                for(int j = 0; j < n; j++)
                {
                    string[] s = Console.ReadLine().Split();
                    clothes.Add(s[0], s[1]);
                }

                var ordercloth = clothes.OrderBy(x => x.Value);

                string currents = "";
                List<int> nums = new List<int>();
                int num = 1;
                foreach (var r in ordercloth)
                {
                    if (currents != "" && currents != r.Value)
                    {
                        nums.Add(num);
                        num = 1;
                    }
                    currents = r.Value;
                    num += 1;
                }
                if (num != 0)
                    nums.Add(num);

                int result = 1;
                foreach (int x in nums)
                    result *= x;
                Console.WriteLine(result - 1);
                
            }
        }
    }
}