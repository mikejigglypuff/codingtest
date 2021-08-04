using System;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int n = int.Parse(s[0]), k = int.Parse(s[1]);

            Queue<int> queue = new Queue<int>();
            for (int i = 1; i < n + 1; i++)
                queue.Enqueue(i);

            string result = "";
            while(queue.Count() > 1)
            {
                int length = queue.Count();
                int count = (length >= k) ? k - 1 : (k - 1) % length;
                List<int> outs = new List<int>(k - 1);

                for(int i = 0; i < count; i++)
                    outs.Add(queue.Dequeue());

                result += queue.Dequeue().ToString() + ", ";

                foreach(int num in outs)
                    queue.Enqueue(num);
            }

            result += queue.Dequeue().ToString();
            Console.WriteLine("<" + result + ">");
        }
    }
}