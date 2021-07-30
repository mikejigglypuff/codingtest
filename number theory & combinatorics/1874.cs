using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder builder = new StringBuilder();
            int n = int.Parse(Console.ReadLine());
            List<int> seq = new List<int>();

            for(int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                seq.Add(int.Parse(s));
            }

            int num = 0, max = 0;
            Stack<int> stack = new Stack<int>();
            List<int> result = new List<int>();
            while(result.Count() < n)
            {
                for(int i = (max != 0) ? max + 1 : 1; i <= seq[num]; i++)
                {
                    stack.Push(i);
                    builder.Append("+\n");
                }
                if (seq[num] == stack.Peek())
                {
                    result.Add(stack.Pop());
                    builder.Append("-\n");
                }
                else
                    break;
                max = (max < seq[num]) ? seq[num] : max;
                num += 1;
            }

            if (result.Count() == n)
                Console.WriteLine(builder);
            else
                Console.WriteLine("NO");
        }
    }
}