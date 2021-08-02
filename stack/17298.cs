using System;
using System.IO;
using System.Text;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            StringReader reader = new StringReader(Console.ReadLine());
            string[] s = reader.ReadLine().Split();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = int.Parse(s[i]);

            Stack<int> stack = new Stack<int>();

            for (int i = 0; i < n; i++)
            {
                if (stack.Count() != 0)
                {
                    while (stack.Count() != 0 && nums[stack.Peek()] < nums[i])
                        nums[stack.Pop()] = nums[i];
                }

                stack.Push(i);
            }

            while (stack.Count() != 0)
                nums[stack.Pop()] = -1;

            nums[n - 1] = -1;

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n - 1; i++)
                builder.Append(nums[i]).Append(" ");
            builder.Append(nums[n - 1]);

            Console.WriteLine(builder);
        }
    }
}