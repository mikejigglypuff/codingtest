using System;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static LinkedList<int> Leftmove(LinkedList<int> link)
        {
            int n = link.First.Value;
            link.RemoveFirst();
            link.AddLast(n);
            return link;
        }

        static LinkedList<int> Rightmove(LinkedList<int> link)
        {
            int n = link.Last.Value;
            link.RemoveLast();
            link.AddFirst(n);
            return link;
        }

        static void Main(string[] args)
        {
            string[] s1 = Console.ReadLine().Split();
            int n = int.Parse(s1[0]), m = int.Parse(s1[1]);

            string[] s2 = Console.ReadLine().Split();
            int[] nums = new int[m];
            for(int i = 0; i < m; i++)
                nums[i] = int.Parse(s2[i]);

            LinkedList<int> linkedlist = new LinkedList<int>();
            for (int i = n; i > 0; i--)
                linkedlist.AddFirst(i);
            int result = 0;

            foreach(int i in nums)
            {
                List<int> outs = new List<int>();
                int iindex = 0;
                for(int j = 0; j < n; j++)
                {
                    if(i == linkedlist.ElementAt(j))
                    {
                        iindex = j;
                        break;
                    }
                }
                while (linkedlist.First.Value != i)
                {
                    if (iindex > n / 2)
                        linkedlist = Rightmove(linkedlist);
                    else
                        linkedlist = Leftmove(linkedlist);
                    result += 1;
                }

                linkedlist.RemoveFirst();
                n -= 1;
            }

            Console.WriteLine(result);
        }
    }
}