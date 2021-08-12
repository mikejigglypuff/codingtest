using System;
using System.Collections.Generic;
namespace baekjoonC____
{
    class Program
    {
        
        static bool fill(ref int[][] sudoku, int num, ref Stack<int[]> stack)
        {
            if (num == 81)
                return true;

            int targetx = num % 9, targety = num / 9;
            if (sudoku[targety][targetx] != 0)
                return fill(ref sudoku, num + 1, ref stack);
            else
            {
                int[] loc = new int[] { targety, targetx };
                for (int i = 1; i <= 9; i++)
                {
                    if (check(sudoku, loc, i))
                    {
                        int[] adds = new int[] { targety, targetx, i };
                        stack.Push(adds);
                        sudoku[targety][targetx] = i;

                        if (fill(ref sudoku, num + 1, ref stack))
                            return true;

                        sudoku[targety][targetx] = 0;
                        stack.Pop();

                    }

                }
            }
            return false;
        }
        
        static List<int[]> findzero(int[][] sudoku)
        {
            List<int[]> result = new List<int[]>();
            for (int i = 0; i < 81; i++)
            {
                int j = i / 9, k = i % 9;
                if (sudoku[j][k] == 0)
                {
                    int[] loc = new int[] { j, k };
                    result.Add(loc);
                }
            }
            return result;
        }

        static bool check(int[][] sudoku, int[] loc, int num)
        {
            bool w = true, h = true, s = true;
            for (int i = 0; i < 9; i++)
            {
                if (sudoku[loc[0]][i] == num)
                {
                    w = false;
                    break;
                }
                else if(sudoku[i][loc[1]] == num)
                {
                    w = false;
                    break;
                }
                else if(sudoku[(loc[0] / 3 * 3) + (i / 3)][(loc[1] / 3 * 3) + (i % 3)] == num)
                {
                    w = false;
                    break;
                }
            }
            return (w && h && s);
        }

        static void Main(string[] args)
        {
            
            int[][] sudoku = new int[9][];
            for(int i = 0; i < 9; i++)
            {
                string[] s = Console.ReadLine().Split(" ");
                sudoku[i] = Array.ConvertAll(s, int.Parse);
            }
            
            List<int[]> zeros = findzero(sudoku);
            Stack<int[]> stack = new Stack<int[]>();

            fill(ref sudoku, 0, ref stack);
            while(stack.Count > 0)
            {
                int[] peeks = stack.Pop();
                sudoku[peeks[0]][peeks[1]] = peeks[2];
            }

            for(int i = 0; i < 9; i++)
            {
                string result = "";
                for(int j = 0; j < 8; j++)
                    result += sudoku[i][j].ToString() + " ";
                Console.WriteLine(result + sudoku[i][8]);
            }
        }
    }
}