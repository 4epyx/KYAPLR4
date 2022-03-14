package com.company;

import java.util.ArrayList;

public class Task2
{
    private static boolean contains(int elem, int[] Arr)
    {
        for(int i : Arr)
        {
            if(elem == i)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean contains(int elem, ArrayList<Integer> Arr)
    {
        for(int i : Arr)
        {
            if (elem == i)
            {
                return true;
            }
        }
        return false;
    }
    private static int[] findMinMax(int[][] Arr)
    {
        int min = Arr[0][0];
        int max = Arr[0][0];
        for(int i = 0; i < Arr.length; i++)
        {
            for(int j = 0; j < Arr.length; j++)
            {
                if(Arr[i][j] < min)
                {
                    min = Arr[i][j];
                }

                if(Arr[i][j] > max)
                {
                    max = Arr[i][j];
                }
            }
        }
        return new int[]{min, max};
    }
    public static int[][] Relation(int[][] Arr)
    {
        int[] MinMax = findMinMax(Arr);
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for(int i = 0; i < Arr.length; i++)
        {
            for(int j = 0; j < Arr[i].length; j++)
            {
                if(contains(Arr[i][j], MinMax))
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        ArrayList<ArrayList<Integer>> resArrayList = new ArrayList<>();
        for(int i = 0; i < Arr.length; i++)
        {
            ArrayList<Integer> h = new ArrayList<>();
            if(contains(i, rows))
            {
                continue;
            }
            for(int j = 0; j < Arr[i].length; j++)
            {
                if(contains(j, cols))
                {
                    continue;
                }
                h.add(Arr[i][j]);
            }
            resArrayList.add(h);
        }
        int[][] res;
        if(resArrayList.size()!= 0) {
            res = new int[resArrayList.size()][resArrayList.get(0).size()];
        }
        else
        {
            res = new int[resArrayList.size()][resArrayList.size()];
        }

        for(int i = 0; i < resArrayList.size(); i++)
        {
            for(int j = 0; j < resArrayList.get(0).size(); j++)
            {
                res[i][j] = resArrayList.get(i).get(j);
            }
        }
        return res;
    }
}
