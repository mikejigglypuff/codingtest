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
            for (int i = 0; i < t; i++)
            {
                string[] s1 = Console.ReadLine().Split();
                int n = int.Parse(s1[0]), m = int.Parse(s1[1]);

                string[] s2 = Console.ReadLine().Split();
                int[][] documents = new int[n][];
                for (int j = 0; j < n; j++)
                {
                    documents[j] = new int[2];
                    documents[j][0] = j;
                    documents[j][1] = int.Parse(s2[j]);
                }

                Queue<int[]> queue = new Queue<int[]>();

                foreach (int[] arr in documents)
                    queue.Enqueue(arr);

                int result = 0;
                while (true)
                {
                    bool fail = false;
                    int[] peeks = queue.Dequeue();
                    int length = queue.Count();
                    int[][] qarray = queue.ToArray();

                    for (int j = 0; j < length; j++)
                    {
                        if (peeks[1] < qarray[j][1])
                        {
                            fail = true;
                            break;
                        }
                    }
                    if (fail)
                        queue.Enqueue(peeks);
                    else
                    {
                        result += 1;
                        if (peeks[0] == m)
                            break;
                    }
                }

                Console.WriteLine(result);
            }
        }
    }
}